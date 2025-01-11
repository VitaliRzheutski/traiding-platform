package com.vitali.controller;

import com.vitali.domain.OrderType;
import com.vitali.modal.Coin;
import com.vitali.modal.Orders;
import com.vitali.modal.User;
import com.vitali.request.CreateOrderRequest;
import com.vitali.service.CoinService;
import com.vitali.service.OrderService;
import com.vitali.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;
//    @Autowired
//    private WalletTransactionService walletTransactionService;

    @PostMapping("/pay")
    public ResponseEntity<Orders>payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateOrderRequest req
    )throws Exception{
        User user = userService.findUserByJwt(jwt);
        Coin coin = coinService.findById(req.getCoinId());
        Orders order = orderService.processOrder(coin, req.getQuantity(),req.getOrderType(),user);
        return ResponseEntity.ok(order);
    }


    @PostMapping("/{orderId}")
    public ResponseEntity<Orders>getOrderById(
            @RequestHeader("Authorization") String jwtToken,
            @PathVariable Long orderId
    )throws Exception{
        User user = userService.findUserByJwt(jwtToken);
        Orders order = orderService.getOrderById(orderId);

        if(order.getUser().getId().equals(user.getId())) {
            return ResponseEntity.ok(order);
        }else{
            throw new Exception("You don't have permission to access this order");
        }
    }

    @GetMapping()
    public ResponseEntity<List<Orders>>getAlOrdersForUser(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(required = false) OrderType order_type,
            @RequestParam(required = false) String asset_symbol


    )throws Exception{
        Long userId = userService.findUserByJwt(jwt).getId();
        List<Orders> userOrders = orderService.getAllOrdersOfUser(userId,order_type,asset_symbol);

        return ResponseEntity.ok(userOrders);

    }


}

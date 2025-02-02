package com.vitali.controller;

import com.vitali.domain.WalletTransactionType;
import com.vitali.modal.*;
import com.vitali.response.PaymentResponse;
import com.vitali.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class WalletController {
    @Autowired
    private WalletService walletService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private TransactionService transactionService ;

    @GetMapping("/api/wallet")
    public ResponseEntity<Wallet>getUserWallet(@RequestHeader("Authorization")String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/api/wallet/{walletId}/transfer")
    public ResponseEntity<Wallet> walletToWalletTransfer(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long walletId,
            @RequestBody WalletTransaction req
    ) throws Exception {
        User senderUser=userService.findUserByJwt(jwt);
        Wallet receiverWallet=walletService.findWalletById(walletId);
        Wallet wallet = walletService.walletToWalletTransaction(senderUser, receiverWallet, req.getAmount());
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

//    @RequestMapping("/api/wallet/{walletId}/transfer")
//    public ResponseEntity<Wallet> walletToWalletTransfer(
//            @RequestHeader("Authorization") String jwt,
//            @PathVariable Long walletId,
//            @RequestBody WalletTransaction req
//    ) throws Exception {
//        // Get user from JWT
//        User senderUser = userService.findUserByJwt(jwt);
//
//        // Get receiver wallet by ID
//        Wallet receiverWallet = walletService.findWalletById(walletId);
//
//        // Fetch sender wallet (you should retrieve the sender's wallet as well)
////        Wallet userWallet = walletService.findWalletByUser(senderUser);
//        Wallet userWallet = walletService.getUserWallet(senderUser);
//        // Perform the wallet-to-wallet transaction
//        Wallet wallet = walletService.walletToWalletTransaction(senderUser, receiverWallet, req.getAmount());
//
//        System.out.println("!wallet: " + wallet);  // Print for debugging
//        System.out.println("!receiverWallet: " + receiverWallet);  // Print for debugging
//
//
//        // Create a transaction for this wallet transfer
//        WalletTransaction walletTransaction = transactionService.createTransaction(
//                userWallet,  // Sender's wallet
//                WalletTransactionType.WITHDRAWAL, // Assuming withdrawal type for sender
//                receiverWallet,  // Receiver's wallet (optional, depending on your logic)
//                "Wallet to wallet transfer",  // Description
//                "14"  // Amount being transferred
//        );
//
//        System.out.println("Created WalletTransaction: " + walletTransaction);
//
//        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
//    }

    @RequestMapping("/api/wallet/order/{orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long orderId
    ) throws Exception {
        User user=userService.findUserByJwt(jwt);

        Orders order = orderService.getOrderById(orderId);

        Wallet wallet = walletService.payOrderPayment(order, user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/deposit")
    public ResponseEntity<Wallet> addBalanceToWallet(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(name = "order_id") Long orderId,
            @RequestParam(name = "payment_id") String paymentId
    ) throws Throwable {
        User user=userService.findUserByJwt(jwt);
        Wallet wallet = walletService.getUserWallet(user);
        PaymentOrder order = paymentService.getPaymentOrderById(orderId);

        Boolean status=paymentService.ProceedPaymentOrder(order, paymentId);

        if(wallet.getBalance()==null){
            wallet.setBalance(BigDecimal.valueOf(0));
        }
        if(status){
            wallet=walletService.addBalance(wallet, order.getAmount());
        }

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);

    }


}

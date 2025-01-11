package com.vitali.controller;

import com.razorpay.RazorpayException;
import com.vitali.domain.PaymentMethod;
import com.vitali.modal.PaymentOrder;
import com.vitali.modal.User;
import com.vitali.response.PaymentResponse;
import com.vitali.service.PaymentService;
import com.vitali.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private UserService userService;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/api/payment/{paymentMethod}/amount/{amount}")
    public ResponseEntity<PaymentResponse>paymentHandler(
            @PathVariable PaymentMethod paymentMethod,
            @PathVariable Long amount,
            @RequestHeader("Authorization") String jwt) throws Exception {

            User user = userService.findUserByJwt(jwt);
            PaymentResponse paymentResponse;
        PaymentOrder order = paymentService.createOrder(user,amount ,paymentMethod);

        if(paymentMethod.equals(PaymentMethod.RAZORPAY)){
            paymentResponse=paymentService.createRazorpayPaymentLink(user,amount, order.getId());
        }else{
            paymentResponse=paymentService.createRazorpayPaymentLink(user,amount, order.getId()); //order
        }
        return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }
}

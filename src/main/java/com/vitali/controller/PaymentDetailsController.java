package com.vitali.controller;

import com.vitali.modal.PaymentDetails;
import com.vitali.modal.User;
import com.vitali.service.PaymentDetailsService;
import com.vitali.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentDetailsController {
    @Autowired
    private PaymentDetailsService paymentDetailsService;
    @Autowired
    private UserService userService;

    @PostMapping("/payment-details")
    public ResponseEntity<PaymentDetails> addPaymentDetails(
            @RequestBody PaymentDetails paymentDetailsRequest,
            @RequestHeader("Authorization")String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

        PaymentDetails paymentDetails = paymentDetailsService.addPaymentDetails(

                paymentDetailsRequest.getAccountNumber(),
                paymentDetailsRequest.getAccountHolderName(),
                paymentDetailsRequest.getIfsc(),
                paymentDetailsRequest.getBankName(),
                user
        );
    return new ResponseEntity<>(paymentDetails, HttpStatus.CREATED);
    }

    @GetMapping("/payment-details")
    public ResponseEntity<PaymentDetails> getUsersPaymentDetails(
            @RequestHeader("Authorization")String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

        PaymentDetails paymentDetails = paymentDetailsService.getUsersPaymentDetails(user);
        return new ResponseEntity<>(paymentDetails, HttpStatus.CREATED);
    }


}

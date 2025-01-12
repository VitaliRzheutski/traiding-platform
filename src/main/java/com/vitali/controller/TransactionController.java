package com.vitali.controller;

//import com.vitali.modal.Transaction;
import com.vitali.modal.User;
import com.vitali.modal.Wallet;
//import com.vitali.modal.WalletTransaction;
import com.vitali.modal.WalletTransaction;
import com.vitali.service.TransactionService;
import com.vitali.service.UserService;
import com.vitali.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping
public class TransactionController {
    @Autowired
    private UserService userService;
    @Autowired
    private WalletService walletService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/api/transactions")
    private ResponseEntity<List<WalletTransaction>>getUserWallet(
            @RequestHeader("Authorization")String jwt) throws Exception{
        User user = userService.findUserByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);

        List<WalletTransaction> transactionList = transactionService.getTransactionsByWallet(wallet);


        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }
}

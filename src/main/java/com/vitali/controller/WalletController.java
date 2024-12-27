package com.vitali.controller;

import com.vitali.modal.User;
import com.vitali.modal.Wallet;
import com.vitali.modal.WalletTransaction;
import com.vitali.service.UserService;
import com.vitali.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @Autowired
    private UserService userService;

    public ResponseEntity<Wallet>getUserWallet(@RequestHeader("Authorization")String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/api/wallet/${walletId}/transfer")
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


}
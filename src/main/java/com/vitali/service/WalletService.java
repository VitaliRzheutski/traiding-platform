package com.vitali.service;

import com.vitali.modal.Order;
import com.vitali.modal.User;
import com.vitali.modal.Wallet;

public interface WalletService {
    Wallet getUserWallet(User user);
    Wallet addBalance(Wallet wallet, Long money);
    Wallet findWalletById(Long id);
    Wallet walletToWalletTransaction(User sender,Wallet wallet );
    Wallet payOrderPayment(Order order, User user);

}

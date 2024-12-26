package com.vitali.service;

import com.vitali.modal.Order;
import com.vitali.modal.User;
import com.vitali.modal.Wallet;
import com.vitali.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private  WalletRepository walletRepository;

    @Override
    public Wallet getUserWallet(User user) {
        Wallet wallet = walletRepository.findByUserId(user.getId());
        if (wallet == null) {
            wallet = new Wallet();
            wallet.setUser(user);
        }

        return wallet;
    }

    @Override
    public Wallet addBalance(Wallet wallet, Long money) {
        return null;
    }

    @Override
    public Wallet findWalletById(Long id) {
        return null;
    }

    @Override
    public Wallet walletToWalletTransaction(User sender, Wallet wallet) {
        return null;
    }

    @Override
    public Wallet payOrderPayment(Order order, User user) {
        return null;
    }
}

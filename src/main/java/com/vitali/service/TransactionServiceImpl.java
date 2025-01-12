package com.vitali.service;

import com.vitali.modal.Wallet;
import com.vitali.modal.WalletTransaction;
import com.vitali.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private WalletTransactionRepository walletTransactionRepository;

    @Override
    public List<WalletTransaction> getTransactionsByWallet(Wallet wallet) throws Exception {
        List<WalletTransaction> transactions = walletTransactionRepository.findByWallet(wallet);

        if (transactions == null || transactions.isEmpty()) {
            throw new Exception("No transactions found for the specified wallet");
        }

        return transactions;// walletTransactionRepository.findByWallet(wallet);
    }
}
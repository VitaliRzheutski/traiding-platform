package com.vitali.service;

import com.vitali.domain.WalletTransactionType;
import com.vitali.modal.Wallet;
import com.vitali.modal.WalletTransaction;
import com.vitali.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public WalletTransaction createTransaction(Wallet wallet,
                                               WalletTransactionType transactionType,
                                               String referenceId,
                                               String description,
                                               Long amount) {
        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setWallet(wallet);
        walletTransaction.setTransactionType(transactionType);
        walletTransaction.setTimestamp(LocalDateTime.now());
        walletTransaction.setDescription(description);
        walletTransaction.setAmount(amount);
        walletTransaction.setReferenceId(referenceId);

        // Save the transaction to the database
//        return walletTransactionRepository.save(walletTransaction);
        WalletTransaction savedTransaction = walletTransactionRepository.save(walletTransaction);
        return savedTransaction;
    }
}
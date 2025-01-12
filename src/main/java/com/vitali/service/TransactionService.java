package com.vitali.service;

//import com.vitali.modal.Transaction;
import com.vitali.domain.WalletTransactionType;
import com.vitali.modal.Wallet;
import com.vitali.modal.WalletTransaction;

import java.util.List;

public interface TransactionService {

    List<WalletTransaction> getTransactionsByWallet(Wallet wallet) throws Exception;
    WalletTransaction createTransaction(Wallet wallet,
                                        WalletTransactionType transactionType,
                                        String referenceId,
                                        String description,
                                        Long amount);

}

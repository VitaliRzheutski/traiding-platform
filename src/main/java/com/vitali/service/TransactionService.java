package com.vitali.service;

//import com.vitali.modal.Transaction;
import com.vitali.modal.Wallet;
import com.vitali.modal.WalletTransaction;

import java.util.List;

public interface TransactionService {

    List<WalletTransaction> getTransactionsByWallet(Wallet wallet) throws Exception;

}

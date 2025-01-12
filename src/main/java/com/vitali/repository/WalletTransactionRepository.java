package com.vitali.repository;

//import com.vitali.modal.Transaction;
import com.vitali.modal.Wallet;
import com.vitali.modal.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
    List<WalletTransaction> findByWallet(Wallet wallet);
}
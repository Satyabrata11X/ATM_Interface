package com.ATM_Machine_Interface.ATM_Machine_Interface.transaction;

import com.ATM_Machine_Interface.ATM_Machine_Interface.account.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccount(BankAccount account);
}
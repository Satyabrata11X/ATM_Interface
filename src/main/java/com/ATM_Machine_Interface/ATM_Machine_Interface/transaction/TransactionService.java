package com.ATM_Machine_Interface.ATM_Machine_Interface.transaction;

import com.ATM_Machine_Interface.ATM_Machine_Interface.account.AccountRepository;
import com.ATM_Machine_Interface.ATM_Machine_Interface.account.BankAccount;
import com.ATM_Machine_Interface.ATM_Machine_Interface.common.exception.InsufficientBalanceException;
import com.ATM_Machine_Interface.ATM_Machine_Interface.common.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(
            TransactionRepository transactionRepository,
            AccountRepository accountRepository) {

        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    // Deposit Money
    public Transaction deposit(String accountNumber, Double amount) {

        BankAccount account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Account not found with number: "
                                        + accountNumber));

        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAccount(account);

        return transactionRepository.save(transaction);
    }

    // Withdraw Money
    public Transaction withdraw(String accountNumber, Double amount) {

        BankAccount account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Account not found with number: "
                                        + accountNumber));

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException(
                    "Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);

        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setAccount(account);

        return transactionRepository.save(transaction);
    }

    // Transaction History
    public List<Transaction> getTransactionHistory(
            String accountNumber) {

        BankAccount account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Account not found with number: "
                                        + accountNumber));

        return transactionRepository.findByAccount(account);
    }
}
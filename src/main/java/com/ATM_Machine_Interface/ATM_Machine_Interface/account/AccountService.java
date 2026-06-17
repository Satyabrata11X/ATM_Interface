package com.ATM_Machine_Interface.ATM_Machine_Interface.account;

import com.ATM_Machine_Interface.ATM_Machine_Interface.common.exception.AccountAlreadyExistsException;
import com.ATM_Machine_Interface.ATM_Machine_Interface.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create Account
    public BankAccount createAccount(BankAccount account) {

        accountRepository.findByAccountNumber(
                        account.getAccountNumber())
                .ifPresent(existing -> {
                    throw new AccountAlreadyExistsException(
                            "Account number "
                                    + account.getAccountNumber()
                                    + " already exists");
                });

        return accountRepository.save(account);
    }

    // Get Account by Account Number
    public Optional<BankAccount> getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    // Get Account by ID
    public Optional<BankAccount> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Get All Accounts
    public List<BankAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Delete Account
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    // Check Balance
    public Double getBalance(String accountNumber) {

        BankAccount account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Account not found with number: " + accountNumber));

        return account.getBalance();
    }
}
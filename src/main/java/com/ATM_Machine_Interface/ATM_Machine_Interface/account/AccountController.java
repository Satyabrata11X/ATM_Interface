package com.ATM_Machine_Interface.ATM_Machine_Interface.account;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create Account
    @PostMapping
    public ResponseEntity<BankAccount> createAccount(
            @RequestBody BankAccount account) {

        return ResponseEntity.ok(
                accountService.createAccount(account)
        );
    }

    // Get All Accounts
    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllAccounts() {

        return ResponseEntity.ok(
                accountService.getAllAccounts()
        );
    }

    // Get Account By Id
    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(
            @PathVariable Long id) {

        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get Balance
    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<Double> getBalance(
            @PathVariable String accountNumber) {

        return ResponseEntity.ok(
                accountService.getBalance(accountNumber)
        );
    }

    // Delete Account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(
            @PathVariable Long id) {

        accountService.deleteAccount(id);

        return ResponseEntity.ok("Account deleted successfully");
    }
}

package com.ATM_Machine_Interface.ATM_Machine_Interface.transaction;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(
            TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Deposit Money
    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(
            @Valid @RequestBody DepositRequest request) {

        Transaction transaction =
                transactionService.deposit(
                        request.getAccountNumber(),
                        request.getAmount());

        return ResponseEntity.ok(transaction);
    }

    // Withdraw Money
    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(
            @Valid @RequestBody WithdrawRequest request) {

        Transaction transaction =
                transactionService.withdraw(
                        request.getAccountNumber(),
                        request.getAmount());

        return ResponseEntity.ok(transaction);
    }

    // Transaction History
    @GetMapping("/history/{accountNumber}")
    public ResponseEntity<List<Transaction>> getHistory(
            @PathVariable String accountNumber) {

        return ResponseEntity.ok(
                transactionService.getTransactionHistory(
                        accountNumber));
    }
}
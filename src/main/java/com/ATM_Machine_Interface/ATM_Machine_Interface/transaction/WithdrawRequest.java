package com.ATM_Machine_Interface.ATM_Machine_Interface.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawRequest {

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @Positive(message = "Amount must be greater than zero")
    private Double amount;
}
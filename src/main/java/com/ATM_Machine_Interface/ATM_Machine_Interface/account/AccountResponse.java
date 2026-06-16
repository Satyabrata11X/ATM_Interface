package com.ATM_Machine_Interface.ATM_Machine_Interface.account;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AccountResponse {

    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private Double balance;
    private LocalDateTime createdAt;
}
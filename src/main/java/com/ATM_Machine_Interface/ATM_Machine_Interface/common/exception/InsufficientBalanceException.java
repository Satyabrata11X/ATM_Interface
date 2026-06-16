package com.ATM_Machine_Interface.ATM_Machine_Interface.common.exception;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
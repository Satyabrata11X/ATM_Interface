package com.ATM_Machine_Interface.ATM_Machine_Interface.common.exception;

public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
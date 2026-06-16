package com.ATM_Machine_Interface.ATM_Machine_Interface.common.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
package com.bankapp01.bankapp.exceptions;

public class NotSufficientFundException extends RuntimeException {
    public NotSufficientFundException(String message) {
        super(message);
    }
}

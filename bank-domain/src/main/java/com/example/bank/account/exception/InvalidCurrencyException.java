package com.example.bank.account.exception;

public class InvalidCurrencyException extends IllegalArgumentException {

    public InvalidCurrencyException() {
    }

    public InvalidCurrencyException(String s) {
        super(s);
    }

    public InvalidCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCurrencyException(Throwable cause) {
        super(cause);
    }
}
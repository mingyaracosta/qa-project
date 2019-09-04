package com.mingyaracosta.qa.services;

public class InsufficientBalanceException extends TransactionException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

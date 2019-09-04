package com.mingyaracosta.qa.services;

public class BadTransactionAmountException extends TransactionException {
    public BadTransactionAmountException(String message) {
        super(message);
    }
}

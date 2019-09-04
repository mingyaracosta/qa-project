package com.mingyaracosta.qa.entities;

import lombok.Getter;

import java.util.Date;

@Getter
public class Transaction {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        UNDEFINED
    }

    private final double amount;
    private final Date transactionDate;
    private final TransactionType transactionType;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = new Date();

        if (this.amount > 0) {
            this.transactionType = TransactionType.DEPOSIT;
        } else if (this.amount < 0) {
            this.transactionType = TransactionType.WITHDRAWAL;
        } else {
            this.transactionType = TransactionType.UNDEFINED;
        }
    }

    private void setTransactionType() {

    }
}

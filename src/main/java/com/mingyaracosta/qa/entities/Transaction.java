package com.mingyaracosta.qa.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Transaction {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        UNDEFINED
    }

    private double amount;
    private double balance;
    private Date transactionDate;
    private TransactionType transactionType;

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
}

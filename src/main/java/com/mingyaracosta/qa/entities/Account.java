package com.mingyaracosta.qa.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class Account {
    @Getter
    @Setter
    private final String accountNumber;
    @Getter
    @Setter
    private final String ownerName;
    @Getter
    @Setter
    private double balance;
    @Getter
    private List<Transaction> transactions;

    public Account(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
        this.transactions = new LinkedList<>();
    }
}

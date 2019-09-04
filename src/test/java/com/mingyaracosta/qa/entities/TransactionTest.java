package com.mingyaracosta.qa.entities;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {
    @Test
    public void createTransactionTest() {
        Transaction transaction = new Transaction(45.0);
        Assert.assertEquals(45, transaction.getAmount(), 0);
    }

    @Test
    public void createDepositTransactionTest() {
        Transaction transaction = new Transaction(45.0);
        Assert.assertEquals(Transaction.TransactionType.DEPOSIT, transaction.getTransactionType());
    }

    @Test
    public void createWithdrawalTransacionTest() {
        Transaction transaction = new Transaction(-13.0);
        Assert.assertEquals(Transaction.TransactionType.WITHDRAWAL, transaction.getTransactionType());
    }

    @Test
    public void createUndifinedTransactionTest() {
        Transaction transaction = new Transaction(0.0);
        Assert.assertEquals(Transaction.TransactionType.UNDEFINED, transaction.getTransactionType());
    }
}

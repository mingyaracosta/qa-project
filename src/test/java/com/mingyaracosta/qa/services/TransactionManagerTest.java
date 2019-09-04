package com.mingyaracosta.qa.services;

import com.mingyaracosta.qa.entities.Account;
import com.mingyaracosta.qa.entities.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionManagerTest {
    private Account account;
    private TransactionManager transactionManager;

    @Before
    public void beforeEveryTest() {
        this.account = new Account("1000002345678", "Wilton Mingyar Acosta Choclo");
        this.transactionManager = TransactionManager.getInstance();
        this.transactionManager.setAccount(account);
    }

    @Test
    public void registerTransactionTest() throws InsufficientBalanceException, BadTransactionAmountException {
        transactionManager.registerTransaction(new Transaction(10));
        assertEquals(1, transactionManager.getTransactions().size());
    }

    @Test
    public void registerDepositTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double depositAmount = 100;
        Transaction deposit = new Transaction(depositAmount);
        transactionManager.registerTransaction(deposit);
        assertEquals(depositAmount, transactionManager.getAccount().getBalance(), 0);
    }

    @Test
    public void registerWithdrawalTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double depositAmount = 100;
        transactionManager.registerTransaction(new Transaction(depositAmount));
        double withdrawalAmount = -50;
        Transaction withdrawal = new Transaction(withdrawalAmount);
        transactionManager.registerTransaction(withdrawal);
        assertEquals(depositAmount + withdrawalAmount, transactionManager.getAccount().getBalance(), 0);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void registerWrongWithdrawalTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double withdrawalAmount = -150;
        Transaction withdrawal = new Transaction(withdrawalAmount);
        transactionManager.registerTransaction(withdrawal);
    }

    @Test(expected = BadTransactionAmountException.class)
    public void registerZeroTransactionTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double depositAmount = 0;
        transactionManager.registerTransaction(new Transaction(depositAmount));
    }
}

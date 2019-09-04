package com.mingyaracosta.qa.services;

import com.mingyaracosta.qa.entities.Account;
import com.mingyaracosta.qa.entities.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionServiceTest {
    private Account account;
    private TransactionService transactionService;

    @Before
    public void beforeEveryTest() {
        this.account = new Account("1000002345678", "Wilton Mingyar Acosta Choclo");
        this.transactionService = TransactionService.getInstance();
        this.transactionService.setAccount(account);
    }

    @Test
    public void registerTransactionTest() throws InsufficientBalanceException, BadTransactionAmountException {
        transactionService.registerTransaction(new Transaction(10));
        assertEquals(1, transactionService.getTransactions().size());
    }

    @Test
    public void registerDepositTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double depositAmount = 100;
        Transaction deposit = new Transaction(depositAmount);
        transactionService.registerTransaction(deposit);
        assertEquals(depositAmount, transactionService.getAccount().getBalance(), 0);
    }

    @Test
    public void registerWithdrawalTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double depositAmount = 100;
        transactionService.registerTransaction(new Transaction(depositAmount));
        double withdrawalAmount = -50;
        Transaction withdrawal = new Transaction(withdrawalAmount);
        transactionService.registerTransaction(withdrawal);
        assertEquals(depositAmount + withdrawalAmount, transactionService.getAccount().getBalance(), 0);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void registerWrongWithdrawalTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double withdrawalAmount = -150;
        Transaction withdrawal = new Transaction(withdrawalAmount);
        transactionService.registerTransaction(withdrawal);
    }

    @Test(expected = BadTransactionAmountException.class)
    public void registerZeroTransactionTest() throws InsufficientBalanceException, BadTransactionAmountException {
        double depositAmount = 0;
        transactionService.registerTransaction(new Transaction(depositAmount));
    }
}

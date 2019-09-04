package com.mingyaracosta.qa.services;

import com.mingyaracosta.qa.entities.Account;
import com.mingyaracosta.qa.entities.Transaction;

import java.util.List;

public class TransactionManager {
    private static TransactionManager instance = new TransactionManager();
    private Account account;

    public static TransactionManager getInstance() {
        return instance;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void registerTransaction(Transaction transaction) throws InsufficientBalanceException, BadTransactionAmountException {
        validateTransactionAmount(transaction);
        List<Transaction> transactions = account.getTransactions();
        transactions.add(transaction);
        updateAccountBalance(transaction);
    }

    private void validateTransactionAmount(Transaction transaction) throws InsufficientBalanceException, BadTransactionAmountException {
        if (transaction.getAmount() == 0) {
            throw new BadTransactionAmountException("The transaction amount can not be 0");
        }
        if (transaction.getAmount() * -1 > this.account.getBalance()) {
            throw new InsufficientBalanceException("Your balance is not big enough");
        }
    }

    private void updateAccountBalance(Transaction transaction) {
        double currentBalance = this.account.getBalance();
        double newBalance = currentBalance + transaction.getAmount();
        this.account.setBalance(newBalance);
    }

    public List<Transaction> getTransactions() {
        return this.account.getTransactions();
    }

    public Account getAccount() {
        return this.account;
    }
}

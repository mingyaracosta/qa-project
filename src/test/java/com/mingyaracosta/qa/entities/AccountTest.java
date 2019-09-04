package com.mingyaracosta.qa.entities;

import static org.junit.Assert.*;
import org.junit.Test;

public class AccountTest {

    @Test
    public void createAccountTest() {
        Account account = new Account("1000002345678", "Wilton Mingyar Acosta Choclo");
        assertEquals("1000002345678", account.getAccountNumber());
        assertEquals(0, account.getBalance(), 0);
        assertEquals("Wilton Mingyar Acosta Choclo", account.getOwnerName());
    }

    @Test
    public void createTransactionsList() {
        Account account = new Account("1000002345678", "Wilton Mingyar Acosta Choclo");
        assertNotNull(account.getTransactions());
    }
}

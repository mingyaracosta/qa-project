package com.mingyaracosta.qa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class AccountTest {

    @Test
    public void createAccountTest() {
        Account account = new Account("1000002345678", 0.0, "Wilton Mingyar", "Acosta Choclo");
        Assert.assertEquals("1000002345678", account.getAccountNumber());
        Assert.assertEquals(0, account.getBalance());
        Assert.assertEquals("Wilton Mingyar", account.getFirstName());
        Assert.assertEquals("Acosta Choclo", account.getLastName());
    }

}

package com.mingyaracosta.qa;

import com.mingyaracosta.qa.entities.Account;
import com.mingyaracosta.qa.services.TransactionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QAProjectApplication {

    public static void main(String[] args) {
        TransactionManager transactionManager = TransactionManager.getInstance();
        transactionManager.setAccount(new Account("100000456789", "Wilton Mingyar Acosta Choclo"));
        SpringApplication.run(QAProjectApplication.class, args);
    }

}

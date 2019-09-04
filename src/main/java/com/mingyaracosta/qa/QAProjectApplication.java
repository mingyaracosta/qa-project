package com.mingyaracosta.qa;

import com.mingyaracosta.qa.entities.Account;
import com.mingyaracosta.qa.entities.Transaction;
import com.mingyaracosta.qa.services.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QAProjectApplication {

    public static void main(String[] args) {
        TransactionService transactionService = TransactionService.getInstance();
        transactionService.setAccount(new Account("100000456789", "Wilton Mingyar Acosta Choclo"));
        SpringApplication.run(QAProjectApplication.class, args);
    }

}

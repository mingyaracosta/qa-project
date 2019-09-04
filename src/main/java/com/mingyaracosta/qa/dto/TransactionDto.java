package com.mingyaracosta.qa.dto;

import com.mingyaracosta.qa.entities.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionDto {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        UNDEFINED
    }

    private double amount;
    private Date transactionDate;
    private Transaction.TransactionType transactionType;

}

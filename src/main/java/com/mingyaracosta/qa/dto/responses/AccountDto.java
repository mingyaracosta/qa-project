package com.mingyaracosta.qa.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    private String accountNumber;
    private String ownerName;
    private double balance;
}

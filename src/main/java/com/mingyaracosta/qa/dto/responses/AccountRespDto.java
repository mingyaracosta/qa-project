package com.mingyaracosta.qa.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountRespDto {
    private String accountNumber;
    private String ownerName;
    private double balance;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TransactionRespDto> transactions;
}

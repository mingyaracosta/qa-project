package com.mingyaracosta.qa.controllers;

import com.mingyaracosta.qa.dto.requests.TransactionReqDto;
import com.mingyaracosta.qa.dto.responses.AccountDto;
import com.mingyaracosta.qa.dto.responses.TransactionRespDto;
import com.mingyaracosta.qa.services.BadTransactionAmountException;
import com.mingyaracosta.qa.services.InsufficientBalanceException;
import com.mingyaracosta.qa.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionsController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping(
            value = "/process-transaction",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AccountDto processTransaction(@RequestBody TransactionReqDto transaction) throws InsufficientBalanceException, BadTransactionAmountException {
        TransactionService service = new TransactionService();
        return service.proccessTransaction(transaction);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<TransactionRespDto> getTransactions() {
        TransactionService service = new TransactionService();
        return service.getTransactions();
    }


}

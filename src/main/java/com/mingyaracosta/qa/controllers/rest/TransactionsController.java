package com.mingyaracosta.qa.controllers.rest;

import com.mingyaracosta.qa.dto.requests.TransactionReqDto;
import com.mingyaracosta.qa.dto.responses.AccountRespDto;
import com.mingyaracosta.qa.dto.responses.TransactionRespDto;
import com.mingyaracosta.qa.services.BadTransactionAmountException;
import com.mingyaracosta.qa.services.InsufficientBalanceException;
import com.mingyaracosta.qa.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionsController {
    private TransactionService service;

    @Autowired
    public TransactionsController(@Qualifier("TransactionService") TransactionService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/process-transaction",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TransactionRespDto processTransaction(@RequestBody TransactionReqDto transaction) throws InsufficientBalanceException, BadTransactionAmountException {
        return service.processTransaction(transaction);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<TransactionRespDto> getTransactions() {
        return service.getTransactions();
    }


}

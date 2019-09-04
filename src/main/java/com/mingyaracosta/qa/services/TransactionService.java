package com.mingyaracosta.qa.services;

import com.mingyaracosta.qa.dto.requests.TransactionReqDto;
import com.mingyaracosta.qa.dto.responses.AccountDto;
import com.mingyaracosta.qa.dto.responses.TransactionRespDto;
import com.mingyaracosta.qa.entities.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionService {
    @Autowired
    private ModelMapper modelMapper;

    private static TransactionManager transactionManager = TransactionManager.getInstance();

    public AccountDto proccessTransaction(TransactionReqDto transactionReqDto)
            throws InsufficientBalanceException, BadTransactionAmountException {
        transactionManager.registerTransaction(new Transaction(transactionReqDto.getAmount()));
        return new ModelMapper().map(transactionManager.getAccount(), AccountDto.class);
    }

    public List<TransactionRespDto> getTransactions() {
        List<Transaction> transactions = transactionManager.getTransactions();
        return transactions
                .stream()
                .map(t -> modelMapper.map(t, TransactionRespDto.class))
                .collect(Collectors.toList());
    }


}

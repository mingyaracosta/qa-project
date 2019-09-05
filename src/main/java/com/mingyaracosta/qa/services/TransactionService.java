package com.mingyaracosta.qa.services;

import com.mingyaracosta.qa.dto.requests.TransactionReqDto;
import com.mingyaracosta.qa.dto.responses.AccountRespDto;
import com.mingyaracosta.qa.dto.responses.TransactionRespDto;
import com.mingyaracosta.qa.entities.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("TransactionService")
public class TransactionService {
    private ModelMapper modelMapper;

    @Autowired
    public TransactionService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private static TransactionManager transactionManager = TransactionManager.getInstance();

    public TransactionRespDto processTransaction(TransactionReqDto transactionReqDto)
            throws InsufficientBalanceException, BadTransactionAmountException {
        Transaction result = transactionManager.registerTransaction(new Transaction(transactionReqDto.getAmount()));
        return modelMapper.map(result, TransactionRespDto.class);
    }

    public List<TransactionRespDto> getTransactions() {
        List<Transaction> transactions = transactionManager.getTransactions();
        return transactions
                .stream()
                .map(transaction -> modelMapper.map(transaction, TransactionRespDto.class))
                .collect(Collectors.toList());
    }

}

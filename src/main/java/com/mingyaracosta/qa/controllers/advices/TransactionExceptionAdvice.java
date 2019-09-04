package com.mingyaracosta.qa.controllers.advices;

import com.mingyaracosta.qa.services.BadTransactionAmountException;
import com.mingyaracosta.qa.services.InsufficientBalanceException;
import com.mingyaracosta.qa.services.TransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TransactionExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InsufficientBalanceException.class, BadTransactionAmountException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public Map<String, Object> handleUserCertificateEntryNotFoundException(TransactionException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return response;
    }


}

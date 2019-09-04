package com.mingyaracosta.qa.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {

    @RequestMapping(
            value = "/process-transaction",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String processTransaction(@RequestParam("amount") Double amount) {
        return String.valueOf(amount);
    }
}

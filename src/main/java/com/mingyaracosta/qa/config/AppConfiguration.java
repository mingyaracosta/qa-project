package com.mingyaracosta.qa.config;

import com.mingyaracosta.qa.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TransactionService getTransactionService() {
        return new TransactionService();
    }
}

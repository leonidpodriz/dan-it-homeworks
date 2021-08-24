package com.danit.springhomeworks.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {
    private final AccountDao accountDao = new AccountDao();
    private final CustomerDao customerDao = new CustomerDao();

    @Bean
    public AccountDao getAccountDao() {
        return accountDao;
    }

    @Bean
    public CustomerDao getCustomerDao() {
        return customerDao;
    }
}

package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.entity.Account;
import com.danit.springhomeworks.entity.Customer;
import com.danit.springhomeworks.storage.InternalStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {

    @Bean
    public AccountDao getAccountDao(InternalStorage<Long, Account> accountInternalStorage) {
        return new AccountDao(accountInternalStorage);
    }
    
    @Bean
    public CustomerDao getCustomerDao(InternalStorage<Long, Customer> customerInternalStorage) {
        return new CustomerDao(customerInternalStorage);
    }
}

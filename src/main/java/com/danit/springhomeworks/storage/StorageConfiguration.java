package com.danit.springhomeworks.storage;

import com.danit.springhomeworks.entity.Account;
import com.danit.springhomeworks.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfiguration {
    private static final InternalStorage<Long, Account> accountStore = new InternalStorage<>();
    private static final InternalStorage<Long, Customer> customerStore = new InternalStorage<>();

    @Bean
    public InternalStorage<Long, Account> getAccountStore() {
        return accountStore;
    }

    @Bean
    public InternalStorage<Long, Customer> getCustomerStore() {
        return customerStore;
    }
}

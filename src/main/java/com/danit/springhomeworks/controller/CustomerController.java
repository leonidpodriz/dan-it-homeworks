package com.danit.springhomeworks.controller;

import com.danit.springhomeworks.dao.AccountDao;
import com.danit.springhomeworks.dao.CustomerDao;
import com.danit.springhomeworks.entity.Account;
import com.danit.springhomeworks.entity.Currency;
import com.danit.springhomeworks.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerController {
    final CustomerDao customerDao;
    final AccountDao accountDao;
    final AccountController accountController;

    public CustomerController(AccountController accountController) {
        this.customerDao = new CustomerDao();
        this.accountDao = new AccountDao();
        this.accountController = accountController;
    }

    public Optional<Customer> getById(Long id) {
        return Optional.ofNullable(customerDao.getOne(id));
    }

    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    public Customer create(Customer customer) {
        customer.setId(null);
        return update(customer);
    }

    public Customer update(Customer customer) {
        return customerDao.save(customer);
    }

    public boolean delete(Customer customer) {
        return customerDao.delete(customer);
    }

    public Account createAccount(Customer customer, Currency currency) {
        Account account = new Account(customer, currency);
        accountDao.save(account);
        customer.getAccounts().add(account);
        return account;
    }

    public boolean deleteAccount(Account account) {
        return accountDao.delete(account);
    }
}

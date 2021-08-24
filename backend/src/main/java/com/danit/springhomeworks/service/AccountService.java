package com.danit.springhomeworks.service;

import com.danit.springhomeworks.HomeworkExceptions;
import com.danit.springhomeworks.dao.AccountDao;
import com.danit.springhomeworks.entity.Account;
import com.danit.springhomeworks.entity.Customer;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AccountService {
    private final AccountDao accountDao;

    public Account createNewAccount(Account account, Customer customer) {
        account.setId(null);
        account.setCustomer(customer);
        customer.getAccounts().add(account);
        return accountDao.save(account);
    }

    public Account updateExistsAccount(Account account) {
        assert account.getId().isPresent();
        return accountDao.save(account);
    }

    public boolean transfer(Account from, Account to, double amount) {
        double newFromAccountBalance = from.getBalance() - amount;
        if (newFromAccountBalance < 0) return false;
        from.setBalance(newFromAccountBalance);
        to.setBalance(to.getBalance() + amount);
        return true;
    }

    public void addAmount(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public boolean withdrawAmount(Account account, Double amount) {
        double newAmount = account.getBalance() - amount;
        if (newAmount < 0) return false;
        account.setBalance(newAmount);
        return true;
    }

    public Optional<Account> getAccountByNumber(String number) {
        return accountDao.getOneByNumber(number);
    }
}

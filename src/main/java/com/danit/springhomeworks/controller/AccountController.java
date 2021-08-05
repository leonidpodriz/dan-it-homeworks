package com.danit.springhomeworks.controller;

import com.danit.springhomeworks.dao.AccountDao;
import com.danit.springhomeworks.entity.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountController {
    private final AccountDao accountDao;

    public AccountController() {
        this.accountDao = new AccountDao();
    }

    public void replenish(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(Account account, Double amount) {
        account.setBalance(account.getBalance() - amount);
    }

    public void transfer(Account accountFrom, Account accountTo, Double amount) {
        withdraw(accountFrom, amount);
        replenish(accountTo, amount);
    }

    public boolean transfer(String accountNumberFrom, String accountNumberTo, Double amount) {
        Optional<Account> accountFrom = accountDao.getOneByNumber(accountNumberFrom);
        Optional<Account> accountTo = accountDao.getOneByNumber(accountNumberTo);

        if (accountFrom.isPresent() && accountTo.isPresent()) {
            transfer(accountFrom.get(), accountTo.get(), amount);

            return true;
        }

        return false;
    }
}

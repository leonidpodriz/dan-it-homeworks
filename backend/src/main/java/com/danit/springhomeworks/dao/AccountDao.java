package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.entity.Account;

import java.util.Optional;

public class AccountDao extends AbstractDao<Account> {
    public Optional<Account> getOneByNumber(String number) {
        return dbInMemory.values().stream().filter(account -> account.getNumber().equals(number)).findFirst();
    }
}

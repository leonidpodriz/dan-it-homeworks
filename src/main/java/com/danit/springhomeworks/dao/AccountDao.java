package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.entity.Account;

import java.util.*;

public class AccountDao extends BaseDao<Account> {
    public static HashMap<Long, Account> accounts = new HashMap<>();


    @Override
    public Account save(Account obj) {
        if (obj.getId().isEmpty()) {
            obj.setId(getNextId());
        }
        accounts.put(obj.getId().get(), obj);
        return obj;
    }


    @Override
    public boolean delete(Account obj) {
        return accounts.remove(obj.getId().orElse(-1L), obj);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public boolean deleteById(long id) {
        return Optional.ofNullable(accounts.remove(id)).isPresent();
    }

    @Override
    public Account getOne(long id) {
        return accounts.get(id);
    }

    public Optional<Account> getOneByNumber(String number) {
        return accounts.values().stream().filter(account -> account.getNumber().equals(number)).findFirst();
    }

    @Override
    Collection<Account> getEntities() {
        return accounts.values();
    }
}

package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.storage.InternalStorage;
import com.danit.springhomeworks.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDao implements Dao<Account> {
    private final InternalStorage<Long, Account> store;
    private long lastId = 0;

    public AccountDao(InternalStorage<Long, Account> store) {
        this.store = store;
    }


    @Override
    public Account save(Account obj) {
        if (obj.getId().isEmpty()) {
            obj.setId(++lastId);
        }
        store.putEntity(obj.getId().get(), obj);
        return obj;
    }


    @Override
    public boolean delete(Account obj) {
        if (obj.getId().isEmpty()) return false;
        return store.removeEntity(obj.getId().get());
    }

    @Override
    public void deleteAll(List<Account> entities) {
        store.flush();
    }

    @Override
    public void saveAll(List<Account> entities) {
        entities.forEach(this::save);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(store.getAllEntities());
    }

    @Override
    public boolean deleteById(long id) {
        return store.removeEntity(id);
    }

    @Override
    public Optional<Account> getOne(long id) {
        return store.getEntity(id);
    }

    public Optional<Account> getOneByNumber(String number) {
        return store.getAllEntities().stream().filter(account -> account.getNumber().equals(number)).findFirst();
    }
}

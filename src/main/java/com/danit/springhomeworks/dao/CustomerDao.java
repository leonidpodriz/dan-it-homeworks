package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.storage.InternalStorage;
import com.danit.springhomeworks.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer> {
    private final InternalStorage<Long, Customer> store;
    private long lastId = 0L;

    public CustomerDao(InternalStorage<Long, Customer> store) {
        this.store = store;
    }

    @Override
    public Customer save(Customer obj) {
        if (obj.getId().isEmpty()) {
            obj.setId(++lastId);
        }
        store.putEntity(obj.getId().get(), obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        if (obj.getId().isEmpty()) return false;
        return store.removeEntity(obj.getId().get());
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        store.flush();
    }

    @Override
    public void saveAll(List<Customer> entities) {
        entities.forEach(this::save);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(store.getAllEntities());
    }

    @Override
    public boolean deleteById(long id) {
        return store.removeEntity(id);
    }

    @Override
    public Optional<Customer> getOne(long id) {
        return store.getEntity(id);
    }
}

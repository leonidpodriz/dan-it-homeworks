package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.entity.Customer;

import java.util.*;

public class CustomerDao extends BaseDao<Customer> {
    public static HashMap<Long, Customer> customers = new HashMap<>();

    @Override
    Collection<Customer> getEntities() {
        return customers.values();
    }

    @Override
    public Customer save(Customer obj) {
        if (obj.getId().isEmpty()) {
            obj.setId(getNextId());
        }
        customers.put(obj.getId().get(), obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        return customers.remove(obj.getId().orElse(-1L), obj);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public boolean deleteById(long id) {
        return Optional.ofNullable(customers.remove(id)).isPresent();
    }

    @Override
    public Customer getOne(long id) {
        return customers.get(id);
    }
}

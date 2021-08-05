package com.danit.springhomeworks.entity;

import java.util.Optional;
import java.util.UUID;

public class Account implements EntityWithLongId {
    private Long id;
    private String number;
    private Currency currency;
    private Double balance;
    private Customer customer;

    public Account(Customer customer, Currency currency) {
        this.customer = customer;
        this.currency = currency;
        this.balance = 0.0;
        this.number = UUID.randomUUID().toString();
    }

    public Currency getCurrency() {
        return currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double getBalance() {
        return balance;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public String getNumber() {
        return number;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
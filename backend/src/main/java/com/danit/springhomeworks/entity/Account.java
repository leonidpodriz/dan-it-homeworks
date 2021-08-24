package com.danit.springhomeworks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;
import java.util.UUID;

public class Account implements EntityWithLongId {
    private Long id;
    private String number;
    private Currency currency;
    private Double balance = 0.0;
    @JsonIgnore
    private Customer customer;

    public Account(Customer customer, Currency currency) {
        this.customer = customer;
        this.currency = currency;
        this.number = getRandomGeneratedNumber();
    }

    static String getRandomGeneratedNumber() {
        return UUID.randomUUID().toString();
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

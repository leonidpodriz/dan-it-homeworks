package com.danit.springhomeworks.entity;

import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer implements EntityWithLongId {
    private Long id;
    @Valid
    @NotNull
    private String name;
    @Valid
    @NotNull
    private String email;
    @Valid
    @NotNull
    private Integer age;
    private List<Account> accounts;

    public Customer(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

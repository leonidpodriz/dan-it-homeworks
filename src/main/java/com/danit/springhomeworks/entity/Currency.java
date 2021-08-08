package com.danit.springhomeworks.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Currency {
    CODE1("USD"),
    CODE2("EUR"),
    CODE3("UAH"),
    CODE4("CHF"),
    CODE5("GBP");

    private final String code;

    private Currency(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static Currency getDepartmentFromCode(String value) {
        return Arrays.stream(Currency.values())
                .filter(currency -> currency.getCode().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

package com.danit.springhomeworks.controller;

import com.danit.springhomeworks.HomeworkExceptions;
import com.danit.springhomeworks.entity.Account;
import com.danit.springhomeworks.entity.RefillRequest;
import com.danit.springhomeworks.entity.TransferRequest;
import com.danit.springhomeworks.service.AccountService;
import com.danit.springhomeworks.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final CustomerService customerService;
    private final AccountService accountService;

    @PostMapping("{id}/accounts")
    public Account createOneCustomerAccounts(@PathVariable Long id, @RequestBody Account account) {
        return customerService.getCustomerById(id)
                .map(customer -> accountService.createNewAccount(account, customer))
                .orElseThrow(HomeworkExceptions::notFound);
    }

    @PostMapping("/accounts/{number}/refill/")
    public Account refill(@PathVariable String number, @RequestBody RefillRequest refillRequest) {
        return accountService.getAccountByNumber(number)
                .map(account -> {
                    accountService.addAmount(account, refillRequest.amount);
                    return account;
                })
                .orElseThrow(HomeworkExceptions::notFound);

    }

    @PostMapping("/accounts/{number}/transfer/")
    public Account transfer(@PathVariable String number, @RequestBody TransferRequest transferRequest) {
        Account fromAccount = accountService.getAccountByNumber(number).orElseThrow(HomeworkExceptions::notFound);
        Account toAccount = accountService.getAccountByNumber(transferRequest.to).orElseThrow(HomeworkExceptions::notFound);
        accountService.transfer(fromAccount, toAccount, transferRequest.amount);
        return fromAccount;
    }

}

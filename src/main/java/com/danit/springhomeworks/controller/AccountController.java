package com.danit.springhomeworks.controller;

import com.danit.springhomeworks.dao.AccountDao;
import org.springframework.stereotype.Service;

@Service
public class AccountController {
//    Пополнить счет (принимает номер счета и сумму)
//    Снять деньги со счета (принимает номер счета и сумму, выполняется только если на счету достаточно денег)
//    Перевести деньги на другой счет (принимает два номера счета и сумму, выполняется только если на счету достаточно денег)

    private final AccountDao accountDao;

    public AccountController() {
        this.accountDao = new AccountDao();
    }

//    public void replenish(String number, Double amount) {
//        Account account = accountDao.getOneByNumber(number);
//        account.setBalance(account.getBalance() + amount);
//    }
//
//    public void withdraw(String number, Double amount) {
//        Account account = accountDao.getOneByNumber(number);
//        account.setBalance(account.getBalance() - amount);
//    }
//
//    public void transfer(String numberSource, String numberTarget, Double amount) {
//        withdraw(numberSource, amount);
//        replenish(numberTarget, amount);
//    }
}

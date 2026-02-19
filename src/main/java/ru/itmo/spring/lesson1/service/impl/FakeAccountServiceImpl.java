package ru.itmo.spring.lesson1.service.impl;

import ru.itmo.spring.lesson1.service.AccountService;
import ru.itmo.spring.lesson2.dto.Account;

import java.math.BigDecimal;

public class FakeAccountServiceImpl implements AccountService {

    @Override
    public Long getId() {
        return -1L;
    }

    @Override
    public void deposit(Account account, BigDecimal value) {
        //noop
    }

    @Override
    public void withdraw(Account account, BigDecimal value) {
        //noop
    }

    @Override
    public boolean equalCalculatorService(AccountServiceImpl accountService) {
        return false;
    }
}

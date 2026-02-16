package ru.itmo.spring.lesson1.service;

import ru.itmo.spring.lesson1.service.impl.AccountServiceImpl;
import ru.itmo.spring.lesson2.dto.Account;

import java.math.BigDecimal;

public interface AccountService {

    Long getId();
    void deposit(Account account, BigDecimal value);
    void withdraw(Account account, BigDecimal value);

    boolean equalCalculatorService(AccountServiceImpl accountService);
}

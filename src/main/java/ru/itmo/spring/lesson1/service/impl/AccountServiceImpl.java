package ru.itmo.spring.lesson1.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.itmo.spring.lesson1.service.AccountService;
import ru.itmo.spring.lesson1.service.CalculatorService;
import ru.itmo.spring.lesson2.dto.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@Primary
//@Scope("prototype")
public class AccountServiceImpl implements AccountService {

    private Long id = new Random().nextLong();

    private CalculatorService calculatorService;
//    private AccountService fakeAccountService;

    @PostConstruct
    public void postInitializaton() {
        System.out.println("Account Service is ready to USE!!!");
    }

    @PreDestroy
    public void clean() {
        System.out.println("Account Service is destroyed!!!");
    }

    @Autowired
    public AccountServiceImpl(Map<String, CalculatorService> calculatorService) {
        this.calculatorService = calculatorService.values().stream().findFirst().get();
//        this.fakeAccountService = fakeAccountServiceImpl;
    }

    public AccountServiceImpl() {
        this.calculatorService = new CalculatorServiceImpl();
    }

    @Override
    public void deposit(Account account, BigDecimal value) {
        account.setBalance(calculatorService.sum(account.getBalance(), value));
    }

    @Override
    public void withdraw(Account account, BigDecimal value) {
//        deposit(account, new BigDecimal(-1).multiply(value));
        account.setBalance(calculatorService.minus(account.getBalance(), value));
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equalCalculatorService(AccountServiceImpl accountService) {
        return calculatorService.getId().equals(accountService.calculatorService.getId());
    }
}

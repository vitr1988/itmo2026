package ru.itmo.spring.lesson1.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.itmo.spring.lesson1.dao.PrintDao;
import ru.itmo.spring.lesson1.service.AccountService;
import ru.itmo.spring.lesson1.service.CalculatorService;
import ru.itmo.spring.lesson2.dto.Account;

import java.math.BigDecimal;
import java.util.Random;

@Service
@Primary
//@Scope("prototype")
public class AccountServiceImpl implements AccountService {

    private Long id = new Random().nextLong();

    private CalculatorService calculatorService;
    private PrintDao printDao;
//    private AccountService fakeAccountService;
//    private ApplicationContext applicationContext;

    public AccountServiceImpl(CalculatorService calculatorService, PrintDao printDao) {
        this.calculatorService = calculatorService;
        this.printDao = printDao;
    }

    @PostConstruct
    public void postInitializaton() {
        System.out.println("Account Service is ready to USE!!!");
    }

    @PreDestroy
    public void clean() {
        System.out.println("Account Service is destroyed!!!");
    }

//    @Autowired
//    public AccountServiceImpl(Map<String, CalculatorService> calculatorService) {
//        this.calculatorService = calculatorService.values().stream().findFirst().get();
////        this.fakeAccountService = fakeAccountServiceImpl;
//    }

//    public AccountServiceImpl() {
//        this.calculatorService = new CalculatorServiceImpl();
//    }

    @Override
    public void deposit(Account account, BigDecimal value) {
        account.setBalance(getCalculatorService().sum(account.getBalance(), value));
        printDao.save(account);
    }

    @Override
    public void withdraw(Account account, BigDecimal value) {
//        deposit(account, new BigDecimal(-1).multiply(value));
        account.setBalance(getCalculatorService().minus(account.getBalance(), value));
        printDao.save(account);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equalCalculatorService(AccountServiceImpl accountService) {
        return getCalculatorService().getId().equals(accountService.getCalculatorService().getId());
    }

    private CalculatorService getCalculatorService() {
        return calculatorService;
//        return applicationContext.getBean(CalculatorService.class);
    }
}

package ru.itmo.spring.lesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.itmo.spring.lesson1.config.ApplicationProperties;
import ru.itmo.spring.lesson1.service.AccountService;
import ru.itmo.spring.lesson1.service.impl.AccountServiceImpl;
import ru.itmo.spring.lesson2.dto.Account;

import java.math.BigDecimal;

@EnableConfigurationProperties({ApplicationProperties.class})
@ComponentScan("ru.itmo.spring.lesson1")
@SpringBootApplication
public class SpringApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringApplicationRunner.class);
//        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);
//        AccountService accountService = applicationContext.getBean("fakeAccountServiceImpl", AccountService.class);
//        AccountService accountService = applicationContext.getBean("fakeAccountServiceImpl", AccountService.class);
//        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
        AccountServiceImpl accountService = applicationContext.getBean(AccountServiceImpl.class);
        AccountService accountService2 = applicationContext.getBean(AccountService.class);
        System.out.println("Singleton: " + accountService2.equals(accountService));
        System.out.println("ID: " + accountService.getId());
        System.out.println("ID: " + accountService2.getId());
        System.out.println("Singleton: " + accountService2.getId().equals(accountService.getId()));

        System.out.println("Singleton of calculator service: " + accountService2.equalCalculatorService(accountService));

        Account account = new Account();
        account.setId(12344);
        account.setOwner("Vitalii Ivanov");
        account.setBalance(BigDecimal.ZERO);
        accountService.deposit(account, BigDecimal.TEN);
        accountService.withdraw(account, new BigDecimal(5));
        System.out.println(account.getBalance());
    }
}

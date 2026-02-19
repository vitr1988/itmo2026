package ru.itmo.spring.lesson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itmo.spring.lesson1.service.AccountService;

@SpringBootApplication
public class SpringBootApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootApplicationRunner.class);
        AccountService fakeAccountServiceImpl = applicationContext.getBean("fakeAccountServiceImpl", AccountService.class);
        fakeAccountServiceImpl.getId();
    }
}

package ru.itmo.spring.lesson3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.spring.lesson1.service.AccountService;
import ru.itmo.spring.lesson1.service.impl.FakeAccountServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    AccountService fakeAccountServiceImpl() {
        return new FakeAccountServiceImpl();
    }
}

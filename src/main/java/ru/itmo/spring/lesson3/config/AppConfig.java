package ru.itmo.spring.lesson3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import ru.itmo.spring.lesson1.service.AccountService;
import ru.itmo.spring.lesson1.service.impl.FakeAccountServiceImpl;

@Configuration
public class AppConfig {

    @Value("${application.file}")
    Resource testTxt;

    @Bean
    AccountService fakeAccountServiceImpl() {
        return new FakeAccountServiceImpl();
    }
}

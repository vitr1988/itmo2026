package ru.itmo.spring.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.itmo.spring.lesson6.config.SecurityConfiguration;

//@Import(SecurityConfiguration.class)
@SpringBootApplication
public class KafkaRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaRunner.class, args);
    }
}

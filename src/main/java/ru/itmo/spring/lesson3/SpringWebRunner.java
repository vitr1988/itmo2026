package ru.itmo.spring.lesson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication//(exclude = JdbcRepositoriesAutoConfiguration.class)
public class SpringWebRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringWebRunner.class);
//        JdbcTemplate bean = run.getBean(JdbcTemplate.class);
    }
}

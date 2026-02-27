package ru.itmo.spring.lesson4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.itmo.spring.lesson4.dao.GroupDao;

@SpringBootApplication
public class DatabaseJDBCRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DatabaseJDBCRunner.class);
        GroupDao groupDao = applicationContext.getBean(GroupDao.class);
        System.out.println(groupDao.findAll());
        String newGroupName = "From IDEA";
        groupDao.deleteByName(newGroupName);
        groupDao.insert(newGroupName);
        System.out.println(groupDao.findAll());
        groupDao.update(2, "IT");
        System.out.println(groupDao.findAll());
    }
}

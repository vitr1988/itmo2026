package ru.itmo.spring.lesson1.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.itmo.spring.lesson1.config.ApplicationProperties;
import ru.itmo.spring.lesson1.dao.PrintDao;

@Repository
public class PrintDaoImpl implements PrintDao {

    @Value("${spring.application.name}")
    private String applicationName;
//
//    @Value("${application.value}")
//    private Long value;

    private ApplicationProperties applicationProperties;

    public PrintDaoImpl(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void save(Object object) {
        System.out.println(applicationName + ": " + applicationProperties.getValue() + ": " +  object);
    }
}

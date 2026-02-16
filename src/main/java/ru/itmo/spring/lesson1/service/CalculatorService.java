package ru.itmo.spring.lesson1.service;

import java.math.BigDecimal;

public interface CalculatorService {
    Long getId();
    BigDecimal sum(BigDecimal value1, BigDecimal value2);
    BigDecimal minus(BigDecimal value1, BigDecimal value2);
}

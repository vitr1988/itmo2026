package ru.itmo.spring.lesson1.service.impl;

import org.springframework.stereotype.Component;
import ru.itmo.spring.lesson1.service.CalculatorService;

import java.math.BigDecimal;

//@Component
public class SimpleCalculatorServiceImpl implements CalculatorService {
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public BigDecimal sum(BigDecimal value1, BigDecimal value2) {
        return new BigDecimal(value1.intValue() + value2.intValue());
    }

    @Override
    public BigDecimal minus(BigDecimal value1, BigDecimal value2) {
        return new BigDecimal(value1.intValue() - value2.intValue());
    }
}

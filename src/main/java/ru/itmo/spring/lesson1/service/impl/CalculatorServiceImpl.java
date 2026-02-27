package ru.itmo.spring.lesson1.service.impl;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.itmo.spring.lesson1.service.CalculatorService;

import java.math.BigDecimal;
import java.util.Random;

@Component("defaultCalculatorService")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CalculatorServiceImpl implements CalculatorService {

    @Getter
    private Long id = new Random().nextLong();

    @Override
    public BigDecimal sum(BigDecimal value1, BigDecimal value2) {
        return value1.add(value2);
    }

    @Override
    public BigDecimal minus(BigDecimal value1, BigDecimal value2) {
        return value1.subtract(value2);
    }
}

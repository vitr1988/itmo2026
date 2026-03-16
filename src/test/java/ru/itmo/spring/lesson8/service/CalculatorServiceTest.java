package ru.itmo.spring.lesson8.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    @DisplayName("Корректно расчитывает сумма значений")
    public void shouldServiceCorrectlyCalculateSummaOfValues() {
        CalculatorService calculatorService = new CalculatorService();
        Assertions.assertEquals(3, calculatorService.summa(1, 2));
        Assertions.assertEquals(1, calculatorService.summa(-1, 2));
        Assertions.assertEquals(2, calculatorService.summa(0, 2));
        Assertions.assertEquals(10, calculatorService.summa(-5, 15));
    }
}

package ru.itmo.spring.lesson6.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {

    private String owner;
    private BigDecimal balance;
}

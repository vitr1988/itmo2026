package ru.itmo.spring.lesson6.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
public class AccountDto {

    private String accountNumber;


    @NotEmpty
    @Length(min = 3, max = 255)
    private String owner;

//    @Positive
    private BigDecimal balance;
}

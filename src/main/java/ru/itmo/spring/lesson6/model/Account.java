package ru.itmo.spring.lesson6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private String accountNumber;

    private String owner;

    private BigDecimal balance;
}

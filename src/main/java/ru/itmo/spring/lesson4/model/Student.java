package ru.itmo.spring.lesson4.model;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Group group;
}

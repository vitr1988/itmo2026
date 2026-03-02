package ru.itmo.spring.lesson4.dao;

import ru.itmo.spring.lesson4.model.Student;

import java.util.Optional;

public interface StudentDao {

    Optional<Student> findById(Long id);
    void insert(String firstName, String lastName);
    void assignToGroup(Long id, Long groupId);
}

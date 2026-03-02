package ru.itmo.spring.lesson5.dao;

import ru.itmo.spring.lesson5.model.Group;
import ru.itmo.spring.lesson5.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Long create(String firstName, String lastName);
    void assignToGroup(Long id, Group group);
}

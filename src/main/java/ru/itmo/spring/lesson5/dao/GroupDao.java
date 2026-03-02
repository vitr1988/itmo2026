package ru.itmo.spring.lesson5.dao;

import ru.itmo.spring.lesson5.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupDao {

    List<Group> findAll();
    Optional<Group> findById(Long id);
    Long insert(String name);
    void update(Long id, String name);
    void deleteById(Long id);
    void deleteByName(String name);
}

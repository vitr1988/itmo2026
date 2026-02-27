package ru.itmo.spring.lesson4.dao;

import ru.itmo.spring.lesson4.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupDao {
    List<Group> findAll();
    Optional<Group> findById(Integer id);
    void insert(String name);
    void update(Integer id, String name);
    void deleteById(Integer id);
    void deleteByName(String name);
}

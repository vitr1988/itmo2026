package ru.itmo.spring.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.spring.lesson5.model.Group;
import ru.itmo.spring.lesson5.model.Student;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query("""
        update Student set group = :group
        where id = :id
    """)
    void assignToGroup(Long id, Group group);
}

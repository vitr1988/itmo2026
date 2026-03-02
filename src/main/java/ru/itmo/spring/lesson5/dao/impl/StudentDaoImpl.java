package ru.itmo.spring.lesson5.dao.impl;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.spring.lesson5.dao.StudentDao;
import ru.itmo.spring.lesson5.model.Group;
import ru.itmo.spring.lesson5.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {

    private final EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return entityManager.createQuery("""
                    select student from Student student
                    join fetch student.group
                """, Student.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return entityManager.createQuery("""
                            select student from Student student
                            join fetch student.group
                            where student.id = :id
                        """, Student.class)
                .setParameter("id", id)
                .getResultList()
                .stream().findFirst();
    }

    @Override
    @Transactional
    public Long create(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        entityManager.persist(student);
        return student.getId();
    }

    @Override
    @Transactional
    public void assignToGroup(Long id, Group group) {
        entityManager.createNativeQuery("""
                            update students set group_id = :groupId
                """)
                .setParameter("groupId", group.getId())
                .executeUpdate();
    }
}

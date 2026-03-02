package ru.itmo.spring.lesson5.dao.impl;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.spring.lesson5.dao.GroupDao;
import ru.itmo.spring.lesson5.model.Group;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GroupDaoImpl implements GroupDao {

    private final EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Group> findAll() {
        return entityManager.createQuery("""
                    select group from Group group
                """, Group.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Group> findById(Long id) {
        return Optional.of(entityManager.find(Group.class, id));
    }

    @Override
    @Transactional(rollbackFor = IOException.class, noRollbackFor = RuntimeException.class)
    public Long insert(String name) {
//        entityManager.getTransaction().begin();
        Group group = new Group();
        group.setGroupName(name);
        entityManager.persist(group);
        Long result = group.getId();
//        entityManager.getTransaction().commit();
        return result;
    }

    @Override
    @Transactional
    public void update(Long id, String name) {
        entityManager.createQuery("""
                            update Group set groupName = :name
                            where id = :id
                        """)
                .setParameter("id", id)
                .setParameter("name", name)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        entityManager.createQuery("""
                            delete from Group group
                            where group.groupName = :name
                        """)
                .setParameter("name", name)
                .executeUpdate();
    }
}

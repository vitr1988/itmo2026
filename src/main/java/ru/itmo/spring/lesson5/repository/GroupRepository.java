package ru.itmo.spring.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.spring.lesson5.model.Group;

@Transactional
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Modifying
    void deleteByGroupName(String name);

    @Modifying
    @NativeQuery("""
            insert into groups(name)
            values (:name)
            """)
    void insert(String name);

    @Modifying
    @Query("""
        update Group set groupName = :name
        where id = :id
    """)
    void update(Long id, String name);
}

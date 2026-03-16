package ru.itmo.spring.lesson6.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.spring.lesson6.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //
//    @Query("""
//    SELECT u FROM User u
//        join fetch u.roles r
//            where u.login = :login
//    """)
    @EntityGraph(value = "User.role")
    Optional<User> findByLogin(String login);
}

package ru.itmo.spring.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.spring.lesson6.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}

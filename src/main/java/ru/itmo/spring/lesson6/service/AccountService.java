package ru.itmo.spring.lesson6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.spring.lesson6.dto.AccountDto;
import ru.itmo.spring.lesson6.mapper.AccountMapper;
import ru.itmo.spring.lesson6.model.Account;
import ru.itmo.spring.lesson6.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Transactional
    public String register(AccountDto accountDto) {
        Account result = accountRepository.save(accountMapper.toEntity(accountDto));
        return result.getAccountNumber();
    }

    @Transactional(readOnly = true)
    public AccountDto findById(String accountNumber) {
        return accountRepository.findById(accountNumber)
                .map(accountMapper::toDto)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public List<AccountDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toDto)
                .toList();
    }

    @Transactional
    public boolean deleteById(String accountNumber) {
        accountRepository.deleteById(accountNumber);
        return true;
    }

    @Transactional
    public AccountDto add(String accountNumber, BigDecimal balance) {
        return accountRepository.findById(accountNumber).map(it -> {
            it.setBalance(it.getBalance().add(balance));
            return it;
        }).map(accountMapper::toDto).orElse(null);
    }
}
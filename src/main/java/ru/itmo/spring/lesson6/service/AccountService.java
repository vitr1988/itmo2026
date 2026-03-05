package ru.itmo.spring.lesson6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.spring.lesson6.dto.AccountDto;
import ru.itmo.spring.lesson6.model.Account;
import ru.itmo.spring.lesson6.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public String register(AccountDto accountDto) {
        Account result = accountRepository.save(convert(accountDto));
        return result.getAccountNumber();
    }

    @Transactional(readOnly = true)
    public AccountDto findById(String accountNumber) {
        return accountRepository.findById(accountNumber)
                .map(AccountService::convertAsDto)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public List<AccountDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountService::convertAsDto)
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
        }).map(AccountService::convertAsDto).orElse(null);
    }

    private static Account convert(AccountDto accountDto) {
        Account account = new Account();
        account.setOwner(accountDto.getOwner());
        account.setBalance(accountDto.getBalance());
        account.setAccountNumber(UUID.randomUUID().toString());
        return account;
    }

    private static AccountDto convertAsDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setOwner(account.getOwner());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }
}

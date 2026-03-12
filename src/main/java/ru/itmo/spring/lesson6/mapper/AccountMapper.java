package ru.itmo.spring.lesson6.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.spring.lesson6.dto.AccountDto;
import ru.itmo.spring.lesson6.model.Account;

import java.util.UUID;

@Mapper(imports = UUID.class)
public interface AccountMapper {
    AccountDto toDto(Account account);

    @Mapping(target = "accountNumber", expression = "java(UUID.randomUUID().toString())")
    Account toEntity(AccountDto account);
}

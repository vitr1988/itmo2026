package ru.itmo.spring.lesson6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.spring.lesson6.dto.AccountDto;
import ru.itmo.spring.lesson6.service.AccountService;

import java.math.BigDecimal;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
    public static final BigDecimal MINUS_ONE = new BigDecimal(-1);

//    private static final Map<String, AccountDto> ACCOUNT_MAP = new HashMap<>();

    private final AccountService accountService;

    @PostMapping("/register")
    public String register(@RequestBody AccountDto accountDto) {
//        final String accountNumber = UUID.randomUUID().toString();
//        ACCOUNT_MAP.put(accountNumber, accountDto);
//        return accountNumber;
        return accountService.register(accountDto);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestParam String accountNumber, @RequestParam BigDecimal balance) {
//        if (!ACCOUNT_MAP.containsKey(accountNumber)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        ACCOUNT_MAP.computeIfPresent(accountNumber, (accountNum, it) -> {
//            it.setBalance(it.getBalance().subtract(balance));
//            return it;
//        });

//        return ResponseEntity.ok(ACCOUNT_MAP.get(accountNumber));

        return ResponseEntity.ok(accountService.add(accountNumber, MINUS_ONE.multiply(balance)));
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestParam String accountNumber, @RequestParam BigDecimal balance) {
        return withdraw(accountNumber, balance.multiply(MINUS_ONE));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getByNumber(@PathVariable String id) {
//        return ACCOUNT_MAP.containsKey(id)
//                ? ResponseEntity.ok(ACCOUNT_MAP.get(id))
//                : ResponseEntity.notFound().build();

        return ResponseEntity.ok(accountService.findById(id));
    }

    @GetMapping
    public Collection<AccountDto> findAll() {
//        return ACCOUNT_MAP.values();
        return accountService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByNumber(@PathVariable String id) {
//        if (ACCOUNT_MAP.remove(id) != null) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
        if (accountService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

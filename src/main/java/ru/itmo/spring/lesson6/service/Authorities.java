package ru.itmo.spring.lesson6.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static ru.itmo.spring.lesson6.security.UserPrincipal.ROLE_PREFIX;

@Component
public class Authorities {

    public static final String ROLE_ADMIN = ROLE_PREFIX + "ADMIN";

    public boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).anyMatch(ROLE_ADMIN::equals);
    }
}

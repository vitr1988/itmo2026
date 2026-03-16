package ru.itmo.spring.lesson8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PushSecurityConfiguration {

//
//    @Bean
//    public SecurityFilterChain pushFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                                .requestMatchers(HttpMethod.POST, "/jwt").permitAll()
//                                .requestMatchers("/v3/**", "/swagger-ui/**", "/swagger-ui.html", "/index.html", "/", "/ex").permitAll()
////                                .requestMatchers("/api/accounts").permitAll()
////                                .requestMatchers("/api/accounts/**").hasRole("ADMIN")
////                                .requestMatchers("/api/accounts/**").hasAuthority("ROLE_ADMIN")
//                                .anyRequest().permitAll()
//                )
//        ;
//
//        return http.build();
//    }
}

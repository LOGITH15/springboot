package com.startpanla.jute.config;

//import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf ->csrf.disable())
        .authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.GET,"/api/***").permitAll()
        .requestMatchers(HttpMethod.POST,"/api/***").permitAll()
        .requestMatchers(HttpMethod.DELETE,"/api/***").permitAll()
        .anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults());
        return http.build();
    }

}

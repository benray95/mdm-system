package com.mdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Désactive la protection CSRF pour les API REST (stateless)
            .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()  // Permet l'accès sans authentification aux endpoints d'authentification
                .antMatchers("/api/devices/enroll").permitAll()  // Permet l'accès sans authentification à l'enrôlement des appareils
                .anyRequest().authenticated()  // Exige une authentification pour toute autre requête
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Utilisation de sessions stateless (pas de session côté serveur)
            .and()
            .httpBasic();  // Utilisation de l'authentification de base HTTP
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Définition d'un encodeur de mot de passe BCrypt
    }
}

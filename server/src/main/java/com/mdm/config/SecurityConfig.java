package com.mdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/login", "/signup", "/enroll", "/frontend/**").permitAll() // Permettre l'accès à /frontend
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login") // URL de la page de connexion
                .defaultSuccessUrl("/frontend/index.html") // Rediriger après connexion réussie
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // Rediriger après déconnexion
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Exemple : configuration d'un utilisateur en mémoire (remplace-le par ton UserDetailsService)
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}password") // Remplace {noop} par un encodeur comme BCrypt pour un projet en production
            .roles("USER");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

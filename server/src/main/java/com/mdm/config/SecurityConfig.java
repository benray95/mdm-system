package com.mdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/frontend/**").authenticated() // Autoriser l'accès à /frontend uniquement si authentifié
                .antMatchers("/login", "/signup", "/public/**").permitAll() // Autoriser les pages publiques
                .anyRequest().authenticated() // Toute autre page nécessite une authentification
            .and()
            .formLogin()
                .loginPage("/login") // Page de connexion personnalisée
                .permitAll() // Autoriser l'accès à la page de connexion
                .defaultSuccessUrl("/frontend", true) // Rediriger vers /frontend après une connexion réussie
            .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        // Créer un utilisateur en mémoire (modifie cette partie pour un user service si nécessaire)
        return new InMemoryUserDetailsManager(
            User.withUsername("admin")
                .password("{noop}password") // Le préfixe {noop} indique que le mot de passe est en texte clair
                .roles("USER")
                .build()
        );
    }
}

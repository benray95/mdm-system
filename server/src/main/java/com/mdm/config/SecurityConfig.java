package com.mdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Autoriser l'accès aux ressources statiques (fichiers HTML, CSS, JS)
                .antMatchers("/frontend/**").permitAll()  // Permet l'accès à /frontend/ sans authentification
                .antMatchers("/login", "/signup").permitAll()  // Autorise l'accès à la page de connexion et d'inscription
                .anyRequest().authenticated()  // Toute autre demande nécessite une authentification
            .and()
            .formLogin()
                .loginPage("/login")  // Page de login personnalisée
                .permitAll()  // Permet l'accès à la page de login sans authentification
            .and()
            .logout()
                .permitAll()  // Permet l'accès à la page de logout
            .and()
            .csrf().disable();  // Désactive la protection CSRF (si nécessaire pour les APIs)
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Ignore la sécurité pour les fichiers dans le répertoire frontend
        web.ignoring().antMatchers("/frontend/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Utilise BCrypt pour encoder les mots de passe
        return new BCryptPasswordEncoder();
    }
}

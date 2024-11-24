package com.mdm.repository;

import com.mdm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Recherche d'un utilisateur par son nom d'utilisateur
    Optional<User> findByUsername(String username);
    
    // Recherche d'un utilisateur par son email
    Optional<User> findByEmail(String email);
}

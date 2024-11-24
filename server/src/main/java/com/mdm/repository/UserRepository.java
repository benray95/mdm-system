package com.mdm.repository;

import com.mdm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Méthode pour rechercher un utilisateur par son nom d'utilisateur
    User findByUsername(String username);

    // Méthode pour rechercher un utilisateur par son email
    User findByEmail(String email);
}

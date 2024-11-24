package com.mdm.service;

import com.mdm.model.User;
import com.mdm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Créer un nouvel utilisateur
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Sécuriser le mot de passe
        return userRepository.save(user);
    }

    // Trouver un utilisateur par son nom d'utilisateur
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }
}

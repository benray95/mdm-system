package com.mdm.api;

import com.mdm.model.User;
import com.mdm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Log avant l'appel à createUser
        logger.info("Tentative d'inscription pour l'utilisateur : {}", user.getUsername());
        
        try {
            // Appel au service pour créer l'utilisateur
            User createdUser = userService.createUser(user);
            
            // Log après un succès
            logger.info("Inscription réussie pour l'utilisateur : {}", createdUser.getUsername());
            
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            // Log en cas d'erreur
            logger.error("Erreur lors de l'inscription de l'utilisateur : {}", user.getUsername(), e);
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'inscription");
        }
    }

    // La méthode de login sera gérée par Spring Security
}
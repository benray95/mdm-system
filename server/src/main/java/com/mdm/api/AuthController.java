package com.mdm.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        // Logique pour enregistrer l'utilisateur
        System.out.println("Received signup request: " + signupRequest);

        // Simuler une sauvegarde réussie
        return ResponseEntity.ok("User registered successfully!");
    }
}

// DTO pour recevoir les données du formulaire
class SignupRequest {
    private String username;
    private String password;

    // Getters et setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

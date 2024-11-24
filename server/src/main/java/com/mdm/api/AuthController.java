package com.mdm.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestParam Map<String, String> params) {
        // Récupérer les données envoyées par le formulaire
        String username = params.get("username");
        String password = params.get("password");

        // Ajouter votre logique de validation et de sauvegarde ici
        System.out.println("Signup Request - Username: " + username + ", Password: " + password);

        // Simuler une sauvegarde réussie
        return ResponseEntity.ok("User registered successfully!");
    }
}

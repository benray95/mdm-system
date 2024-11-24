package com.mdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Méthode pour afficher la page d'accueil
    @GetMapping("/")
    public String index() {
        return "index"; // Nom de la vue HTML à afficher
    }

    // Méthode pour afficher la page de connexion
    @GetMapping("/login")
    public String login() {
        return "login"; // Nom de la vue HTML pour la page de connexion
    }

    // Méthode pour afficher la page d'inscription
    @GetMapping("/signup")
    public String signup() {
        return "signup"; // Nom de la vue HTML pour la page d'inscription
    }

    // Méthode pour afficher la page d'enrôlement des appareils
    @GetMapping("/enroll")
    public String enroll() {
        return "enroll"; // Nom de la vue HTML pour la page d'enrôlement des appareils
    }
}

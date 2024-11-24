package com.mdm.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Redirection vers la page statique de login
    @GetMapping("/login")
    public String login() {
        return "redirect:/frontend/login.html";
    }

    // Redirection vers la page signup
    @GetMapping("/signup")
    public String signup() {
        return "redirect:/frontend/signup.html";
    }

    // Ajoute d'autres endpoints si nécessaire
}

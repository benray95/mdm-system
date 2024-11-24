package com.mdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Page d'accueil
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Page de connexion
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Page d'inscription
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    // Page d'enrôlement
    @GetMapping("/enroll")
    public String enroll() {
        return "enroll";
    }
}

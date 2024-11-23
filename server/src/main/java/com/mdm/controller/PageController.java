package com.mdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "frontend/login"; // Renvoie login.html situé dans static/frontend
    }

    @GetMapping("/index")
    public String index() {
        return "frontend/index"; // Renvoie index.html situé dans static/frontend
    }

    @GetMapping("/signup")
    public String signup() {
        return "frontend/signup"; // Renvoie signup.html situé dans static/frontend
    }
}
package com.mdm.model;

public class AuthRequest {
    private String username;
    private String password;

    // Getters and setters
}

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter
}
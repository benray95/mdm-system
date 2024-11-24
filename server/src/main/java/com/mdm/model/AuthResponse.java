package com.mdm.model;

public class AuthResponse {

    private String token;

    // Constructeur par défaut
    public AuthResponse() {}

    // Constructeur avec paramètres
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter pour token
    public String getToken() {
        return token;
    }

    // Setter pour token
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}

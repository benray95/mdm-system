package com.mdm.model;

public class AuthRequest {

    private String username;
    private String password;

    // Constructeur par défaut
    public AuthRequest() {}

    // Constructeur avec paramètres
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter pour username
    public String getUsername() {
        return username;
    }

    // Setter pour username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter pour password
    public String getPassword() {
        return password;
    }

    // Setter pour password
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

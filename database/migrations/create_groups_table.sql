-- SQL Script for Groups Table 
CREATE TABLE groups (
    id INT AUTO_INCREMENT PRIMARY KEY,           -- Identifiant unique du groupe
    name VARCHAR(100) NOT NULL UNIQUE,            -- Nom du groupe (ex. : "Ventes", "IT", etc.)
    description TEXT,                            -- Description du groupe
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Date de création du groupe
);

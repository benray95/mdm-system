-- SQL Script for Contacts Table 
CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,           -- Identifiant unique
    name VARCHAR(100) NOT NULL,                  -- Nom du contact
    phone_number VARCHAR(20) NOT NULL,           -- Numéro de téléphone du contact
    email VARCHAR(100),                          -- Adresse e-mail du contact
    group_id INT,                                -- Lien avec le groupe auquel appartient le contact
    FOREIGN KEY (group_id) REFERENCES groups(id) -- Clé étrangère vers la table groups
);

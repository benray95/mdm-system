-- SQL Script for Devices Table 
CREATE TABLE devices (
    id INT AUTO_INCREMENT PRIMARY KEY,           -- Identifiant unique
    imei VARCHAR(15) NOT NULL UNIQUE,            -- IMEI de l'appareil (unique)
    model VARCHAR(100) NOT NULL,                 -- Modèle de l'appareil
    brand VARCHAR(100) NOT NULL,                 -- Marque de l'appareil
	serial VARCHAR(100) NOT NULL,                -- Numéro de série de l'appareil
    os_version VARCHAR(50) NOT NULL,             -- Version de l'OS
    geo_location VARCHAR(255),                   -- Localisation géographique (latitude, longitude)
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Date d'enregistrement
    user_id INT,                                 -- Lien avec l'utilisateur ayant enregistré l'appareil
    FOREIGN KEY (user_id) REFERENCES users(id)  -- Clé étrangère vers la table users
);

-- SQL Script for Actions Log Table 
CREATE TABLE actions_log (
    id INT AUTO_INCREMENT PRIMARY KEY,           -- Identifiant unique
    device_id INT,                               -- Lien avec l'appareil concerné
    action VARCHAR(255) NOT NULL,                -- Action réalisée (ex. : géolocalisation, application installée)
    action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Date de l'action
    FOREIGN KEY (device_id) REFERENCES devices(id) -- Clé étrangère vers la table devices
);

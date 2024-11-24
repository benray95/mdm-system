-- Création de la base de données MDM
CREATE DATABASE IF NOT EXISTS mdm_db;
USE mdm_db;

-- Table des appareils
CREATE TABLE IF NOT EXISTS devices (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Identifiant unique pour chaque appareil
    device_id VARCHAR(255) NOT NULL UNIQUE,  -- Identifiant unique de l'appareil
    imei VARCHAR(15) UNIQUE NOT NULL,  -- IMEI unique de l'appareil
    brand VARCHAR(100) NOT NULL,  -- Marque de l'appareil
    model VARCHAR(100) NOT NULL,  -- Modèle de l'appareil
    os_version VARCHAR(50) NOT NULL,  -- Version du système d'exploitation
    last_checkin DATETIME NOT NULL,  -- Dernière connexion de l'appareil
    status ENUM('active', 'inactive', 'lost') NOT NULL DEFAULT 'active'  -- Statut de l'appareil
);

-- Table des utilisateurs
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Identifiant unique pour chaque utilisateur
    username VARCHAR(50) NOT NULL UNIQUE,  -- Nom d'utilisateur unique
    password VARCHAR(255) NOT NULL,  -- Mot de passe de l'utilisateur
    email VARCHAR(100) NOT NULL UNIQUE,  -- Email unique de l'utilisateur
    role ENUM('admin', 'user') NOT NULL DEFAULT 'user',  -- Rôle de l'utilisateur
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP  -- Date de création de l'utilisateur
);

-- Table des groupes d'appareils
CREATE TABLE IF NOT EXISTS device_groups (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Identifiant unique pour chaque groupe
    name VARCHAR(100) NOT NULL UNIQUE,  -- Nom du groupe d'appareils unique
    description TEXT  -- Description du groupe
);

-- Table de liaison entre appareils et groupes
CREATE TABLE IF NOT EXISTS device_group_assignments (
    device_id BIGINT,  -- Référence à l'appareil
    group_id BIGINT,  -- Référence au groupe
    PRIMARY KEY (device_id, group_id),  -- Clé primaire composée de device_id et group_id
    FOREIGN KEY (device_id) REFERENCES devices(id) ON DELETE CASCADE,  -- Clé étrangère vers devices
    FOREIGN KEY (group_id) REFERENCES device_groups(id) ON DELETE CASCADE  -- Clé étrangère vers device_groups
);

-- Table des applications
CREATE TABLE IF NOT EXISTS applications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Identifiant unique pour chaque application
    package_name VARCHAR(255) NOT NULL UNIQUE,  -- Nom du package de l'application
    app_name VARCHAR(100) NOT NULL,  -- Nom de l'application
    version VARCHAR(50) NOT NULL,  -- Version de l'application
    is_system_app BOOLEAN NOT NULL DEFAULT FALSE  -- Si l'application est une application système
);

-- Table de la liste blanche/noire des applications
CREATE TABLE IF NOT EXISTS app_whitelist_blacklist (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Identifiant unique
    app_id BIGINT,  -- Référence à l'application
    list_type ENUM('whitelist', 'blacklist') NOT NULL,  -- Type de liste (blanche ou noire)
    group_id BIGINT,  -- Référence au groupe d'appareils
    FOREIGN KEY (app_id) REFERENCES applications(id) ON DELETE CASCADE,  -- Clé étrangère vers applications
    FOREIGN KEY (group_id) REFERENCES device_groups(id) ON DELETE CASCADE  -- Clé étrangère vers device_groups
);

-- Table des événements de géolocalisation
CREATE TABLE IF NOT EXISTS geolocation_events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Identifiant unique pour chaque événement
    device_id BIGINT,  -- Référence à l'appareil
    latitude DECIMAL(10, 8) NOT NULL,  -- Latitude de l'événement de géolocalisation
    longitude DECIMAL(11, 8) NOT NULL,  -- Longitude de l'événement de géolocalisation
    timestamp DATETIME NOT NULL,  -- Date et heure de l'événement
    FOREIGN KEY (device_id) REFERENCES devices(id) ON DELETE CASCADE  -- Clé étrangère vers devices
);

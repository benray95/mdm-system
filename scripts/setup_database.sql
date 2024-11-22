-- Création de la base de données MDM
CREATE DATABASE IF NOT EXISTS mdm_db;
USE mdm_db;

-- Table des appareils
CREATE TABLE IF NOT EXISTS devices (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    device_id VARCHAR(255) NOT NULL UNIQUE,
    imei VARCHAR(15) UNIQUE NOT NULL,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    os_version VARCHAR(50) NOT NULL,
    last_checkin DATETIME NOT NULL,
    status ENUM('active', 'inactive', 'lost') NOT NULL DEFAULT 'active'
);

-- Table des utilisateurs
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role ENUM('admin', 'user') NOT NULL DEFAULT 'user',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table des groupes d'appareils
CREATE TABLE IF NOT EXISTS device_groups (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

-- Table de liaison entre appareils et groupes
CREATE TABLE IF NOT EXISTS device_group_assignments (
    device_id BIGINT,
    group_id BIGINT,
    PRIMARY KEY (device_id, group_id),
    FOREIGN KEY (device_id) REFERENCES devices(id) ON DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES device_groups(id) ON DELETE CASCADE
);

-- Table des applications
CREATE TABLE IF NOT EXISTS applications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    package_name VARCHAR(255) NOT NULL UNIQUE,
    app_name VARCHAR(100) NOT NULL,
    version VARCHAR(50) NOT NULL,
    is_system_app BOOLEAN NOT NULL DEFAULT FALSE
);

-- Table de la liste blanche/noire des applications
CREATE TABLE IF NOT EXISTS app_whitelist_blacklist (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    app_id BIGINT,
    list_type ENUM('whitelist', 'blacklist') NOT NULL,
    group_id BIGINT,
    FOREIGN KEY (app_id) REFERENCES applications(id) ON DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES device_groups(id) ON DELETE CASCADE
);

-- Table des événements de géolocalisation
CREATE TABLE IF NOT EXISTS geolocation_events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    device_id BIGINT,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    timestamp DATETIME NOT NULL,
    FOREIGN KEY (device_id) REFERENCES devices(id) ON DELETE CASCADE
);
#!/bin/bash

# Script de configuration du serveur pour le projet MDM

# Mise à jour des packages
echo "Mise à jour des packages système..."
sudo apt-get update -y
sudo apt-get upgrade -y

# Installation de Java (OpenJDK)
echo "Installation de Java OpenJDK 11..."
sudo apt-get install openjdk-11-jdk -y

# Vérification de l'installation de Java
java -version

# Installation de MariaDB
echo "Installation de MariaDB..."
sudo apt-get install mariadb-server mariadb-client -y

# Démarrage du service MariaDB
echo "Démarrage du service MariaDB..."
sudo systemctl start mariadb
sudo systemctl enable mariadb

# Sécurisation de MariaDB
echo "Sécurisation de MariaDB..."
sudo mysql_secure_installation

# Création de l'utilisateur et de la base de données
echo "Création de la base de données et de l'utilisateur pour MDM..."
mysql -u root -p <<EOF
CREATE DATABASE IF NOT EXISTS mdm_db;
CREATE USER 'mdm_user'@'localhost' IDENTIFIED BY 'votre_mot_de_passe';
GRANT ALL PRIVILEGES ON mdm_db.* TO 'mdm_user'@'localhost';
FLUSH PRIVILEGES;
EOF

# Téléchargement et configuration de l'application Spring Boot
echo "Téléchargement de l'application Spring Boot..."
# Remplacez par le lien de votre application si nécessaire
wget https://url.de.votre.application/spring-boot-app.jar -P /opt/mdm

# Lancement de l'application Spring Boot
echo "Démarrage de l'application Spring Boot..."
nohup java -jar /opt/mdm/spring-boot-app.jar &

# Affichage des logs
tail -f /opt/mdm/application.log

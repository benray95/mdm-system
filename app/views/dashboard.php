<?php
// app/views/dashboard.php

session_start();
require_once 'config/db.php';

// Vérification de la session utilisateur
if (!isset($_SESSION['user_id'])) {
    header("Location: /login");
    exit();
}

// Récupération des informations utilisateur
$user_name = htmlspecialchars($_SESSION['username'], ENT_QUOTES, 'UTF-8');
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - MDM-System</title>
    <link rel="stylesheet" href="/public/css/styles.css">
    <style>
        /* Bandeau supérieur */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
        }
        .header .app-name {
            font-size: 24px;
            font-weight: bold;
        }
        .header .user-info {
            display: flex;
            align-items: center;
        }
        .header .user-info .date-time {
            margin-right: 15px;
        }
        .header .user-info .profile {
            margin-left: 15px;
            position: relative;
        }
        .header .user-info .profile-menu {
            display: none;
            position: absolute;
            right: 0;
            top: 30px;
            background-color: white;
            border: 1px solid #ddd;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            z-index: 1000;
        }
        .header .user-info .profile-menu a {
            display: block;
            padding: 10px;
            color: #333;
            text-decoration: none;
        }
        .header .user-info .profile-menu a:hover {
            background-color: #f4f4f4;
        }
        .header .user-info .profile:hover .profile-menu {
            display: block;
        }

        /* Barre de menu */
        .navbar {
            display: flex;
            background-color: #333;
            padding: 10px;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            padding: 10px 15px;
        }
        .navbar a:hover {
            background-color: #575757;
        }

        /* Contenu principal */
        .content {
            padding: 20px;
        }
    </style>
</head>
<body>
    <!-- Bandeau supérieur -->
    <div class="header">
        <div class="app-name">MDM-System</div>
        <div class="user-info">
            <div class="date-time" id="dateTime"></div>
            <div class="profile">
                <?= $user_name; ?>
                <div class="profile-menu">
                    <a href="/profile">Mon profil</a>
                    <a href="/auth/logout">Se déconnecter</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Barre de menu -->
    <div class="navbar">
        <a href="/inventory">Inventaire</a>
        <a href="/admin">Administration</a>
        <a href="/about">À propos</a>
    </div>

    <!-- Contenu principal -->
    <div class="content">
        <h2>Bienvenue sur MDM-System</h2>
        <p>Sélectionnez une section dans le menu ci-dessus pour commencer.</p>
    </div>

    <!-- Script JavaScript pour l'heure dynamique -->
    <script>
        function updateDateTime() {
            const now = new Date();
            const formattedDateTime = now.toLocaleString('fr-FR', {
                weekday: 'long',
                year: 'numeric',
                month: 'long',
                day: 'numeric',
                hour: '2-digit',
                minute: '2-digit',
                second: '2-digit'
            });
            document.getElementById('dateTime').textContent = formattedDateTime;
        }

        // Mise à jour de la date et de l'heure toutes les secondes
        setInterval(updateDateTime, 1000);
        // Initialisation au chargement
        updateDateTime();
    </script>
</body>
</html>

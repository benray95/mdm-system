<!-- app/views/login.php -->

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - MDM</title>
    <link rel="stylesheet" href="/public/css/styles.css">
</head>
<body>
    <div class="login-container">
        <h2>Se connecter à l'interface MDM</h2>
        <form method="POST" action="/login">
            <label for="username">Nom d'utilisateur:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Mot de passe:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Se connecter</button>
        </form>
        <?php if (isset($error_message)): ?>
            <div class="error"><?= $error_message ?></div>
        <?php endif; ?>
    </div>
</body>
</html>

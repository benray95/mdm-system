<!-- app/views/device.php -->

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Détails Appareil - MDM</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="device-details-container">
        <h2>Détails de l'appareil - <?= $device['model'] ?></h2>
        <p><strong>IMEI:</strong> <?= $device['imei'] ?></p>
        <p><strong>Modèle:</strong> <?= $device['model'] ?></p>
        <p><strong>Marque:</strong> <?= $device['brand'] ?></p>
        <p><strong>Version de l'OS:</strong> <?= $device['os_version'] ?></p>
        <p><strong>Géolocalisation:</strong> <?= $device['geo_location'] ?></p>
        
        <h3>Applications installées:</h3>
        <ul>
            <?php foreach ($device['apps'] as $app): ?>
                <li><?= $app['name'] ?></li>
            <?php endforeach; ?>
        </ul>

        <a href="/devices">Retour à la liste des appareils</a>
    </div>
</body>
</html>

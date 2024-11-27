<!-- app/views/devices.php -->

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appareils - MDM</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="devices-container">
        <h2>Liste des appareils enregistrés</h2>
        <a href="/device/register">Enrôler un nouvel appareil</a>
        <table>
            <thead>
                <tr>
                    <th>IMEI</th>
                    <th>Modèle</th>
                    <th>Marque</th>
                    <th>OS</th>
                    <th>Géolocalisation</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($devices as $device): ?>
                    <tr>
                        <td><?= $device['imei'] ?></td>
                        <td><?= $device['model'] ?></td>
                        <td><?= $device['brand'] ?></td>
                        <td><?= $device['os_version'] ?></td>
                        <td><?= $device['geo_location'] ?></td>
                        <td>
                            <a href="/device/<?= $device['id'] ?>">Voir</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</body>
</html>

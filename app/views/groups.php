<!-- app/views/groups.php -->

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Groupes - MDM</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="groups-container">
        <h2>Gestion des groupes d'appareils</h2>
        <a href="/group/create">Créer un nouveau groupe</a>
        <table>
            <thead>
                <tr>
                    <th>Nom du groupe</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($groups as $group): ?>
                    <tr>
                        <td><?= $group['name'] ?></td>
                        <td><?= $group['description'] ?></td>
                        <td>
                            <a href="/group/<?= $group['id'] ?>">Voir</a>
                            <a href="/group/edit/<?= $group['id'] ?>">Modifier</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</body>
</html>

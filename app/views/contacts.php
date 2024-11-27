<!-- app/views/contacts.php -->

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacts - MDM</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="contacts-container">
        <h2>Gestion des contacts</h2>
        <table>
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Téléphone</th>
                    <th>E-mail</th>
                    <th>Groupe</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($contacts as $contact): ?>
                    <tr>
                        <td><?= $contact['name'] ?></td>
                        <td><?= $contact['phone_number'] ?></td>
                        <td><?= $contact['email'] ?></td>
                        <td><?= $contact['group_name'] ?></td>
                        <td>
                            <a href="/contact/<?= $contact['id'] ?>">Voir</a>
                            <a href="/contact/edit/<?= $contact['id']

<?php
// app/views/inventory.php

session_start();
require_once 'config/db.php';

// Vérification de la session utilisateur
if (!isset($_SESSION['user_id'])) {
    header("Location: /login");
    exit();
}

// Récupération des critères de recherche depuis le formulaire
$searchBrand = $_GET['brand'] ?? '';
$searchGroup = $_GET['group'] ?? '';
$searchIMEI = $_GET['imei'] ?? '';
$itemsPerPage = $_GET['items_per_page'] ?? 10;
$currentPage = $_GET['page'] ?? 1;

// Calcul des limites pour la pagination
$offset = ($currentPage - 1) * $itemsPerPage;

// Requête pour récupérer les données des appareils avec filtrage
$query = "SELECT devices.id, devices.imei, devices.model, devices.brand, groups.name AS group_name 
          FROM devices 
          LEFT JOIN groups ON devices.group_id = groups.id 
          WHERE 1=1";

if ($searchBrand) {
    $query .= " AND devices.brand LIKE ?";
}
if ($searchGroup) {
    $query .= " AND groups.name LIKE ?";
}
if ($searchIMEI) {
    $query .= " AND devices.imei LIKE ?";
}

$query .= " LIMIT ? OFFSET ?";

// Préparer et exécuter la requête
$stmt = $conn->prepare($query);
$params = [];
if ($searchBrand) $params[] = "%$searchBrand%";
if ($searchGroup) $params[] = "%$searchGroup%";
if ($searchIMEI) $params[] = "%$searchIMEI%";
$params[] = (int)$itemsPerPage;
$params[] = (int)$offset;

$stmt->execute($params);
$devices = $stmt->fetchAll(PDO::FETCH_ASSOC);

// Récupérer le nombre total de résultats (pour la pagination)
$countQuery = "SELECT COUNT(*) 
               FROM devices 
               LEFT JOIN groups ON devices.group_id = groups.id 
               WHERE 1=1";

if ($searchBrand) {
    $countQuery .= " AND devices.brand LIKE ?";
}
if ($searchGroup) {
    $countQuery .= " AND groups.name LIKE ?";
}
if ($searchIMEI) {
    $countQuery .= " AND devices.imei LIKE ?";
}

$countStmt = $conn->prepare($countQuery);
$countStmt->execute(array_slice($params, 0, -2)); // Exclure LIMIT et OFFSET
$totalItems = $countStmt->fetchColumn();

// Calcul du nombre total de pages
$totalPages = ceil($totalItems / $itemsPerPage);
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventaire - MDM-System</title>
    <link rel="stylesheet" href="/public/css/styles.css">
</head>
<body>
    <!-- Bandeau supérieur -->
    <?php include 'partials/header.php'; ?>

    <!-- Barre de menu -->
    <?php include 'partials/navbar.php'; ?>

    <div class="content">
        <h2>Inventaire des appareils</h2>

        <!-- Formulaire de recherche -->
        <form method="GET" action="/inventory" class="search-form">
            <label for="brand">Marque :</label>
            <input type="text" id="brand" name="brand" value="<?= htmlspecialchars($searchBrand); ?>">

            <label for="group">Groupe :</label>
            <input type="text" id="group" name="group" value="<?= htmlspecialchars($searchGroup); ?>">

            <label for="imei">IMEI :</label>
            <input type="text" id="imei" name="imei" value="<?= htmlspecialchars($searchIMEI); ?>">

            <label for="items_per_page">Appareils par page :</label>
            <select id="items_per_page" name="items_per_page">
                <option value="10" <?= $itemsPerPage == 10 ? 'selected' : ''; ?>>10</option>
                <option value="20" <?= $itemsPerPage == 20 ? 'selected' : ''; ?>>20</option>
                <option value="50" <?= $itemsPerPage == 50 ? 'selected' : ''; ?>>50</option>
            </select>

            <button type="submit">Rechercher</button>
        </form>

        <!-- Tableau des appareils -->
        <table class="devices-table">
            <thead>
                <tr>
                    <th>IMEI</th>
                    <th>Modèle</th>
                    <th>Marque</th>
                    <th>Groupe</th>
                </tr>
            </thead>
            <tbody>
                <?php if (count($devices) > 0): ?>
                    <?php foreach ($devices as $device): ?>
                        <tr>
                            <td><?= htmlspecialchars($device['imei']); ?></td>
                            <td><?= htmlspecialchars($device['model']); ?></td>
                            <td><?= htmlspecialchars($device['brand']); ?></td>
                            <td><?= htmlspecialchars($device['group_name'] ?? 'Non assigné'); ?></td>
                        </tr>
                    <?php endforeach; ?>
                <?php else: ?>
                    <tr>
                        <td colspan="4">Aucun appareil trouvé.</td>
                    </tr>
                <?php endif; ?>
            </tbody>
        </table>

        <!-- Pagination -->
        <div class="pagination">
            <?php if ($currentPage > 1): ?>
                <a href="/inventory?page=<?= $currentPage - 1; ?>&<?= http_build_query($_GET); ?>">Précédent</a>
            <?php endif; ?>

            <?php for ($i = 1; $i <= $totalPages; $i++): ?>
                <a href="/inventory?page=<?= $i; ?>&<?= http_build_query($_GET); ?>" class="<?= $i == $currentPage ? 'active' : ''; ?>"><?= $i; ?></a>
            <?php endfor; ?>

            <?php if ($currentPage < $totalPages): ?>
                <a href="/inventory?page=<?= $currentPage + 1; ?>&<?= http_build_query($_GET); ?>">Suivant</a>
            <?php endif; ?>
        </div>
    </div>
</body>
</html>

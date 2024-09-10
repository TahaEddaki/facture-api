# Facture API

Cette API permet de gérer des factures, offrant des fonctionnalités de création, mise à jour, suppression et consultation des factures. Elle est développée en utilisant Node.js, Express, et MongoDB.

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés :

- [Node.js](https://nodejs.org/)
- [MongoDB](https://www.mongodb.com/)
- [Postman](https://www.postman.com/) (optionnel pour tester l'API)

## Installation

1. Clonez ce dépôt sur votre machine locale :
   git clone https://github.com/TahaEddaki/facture-api.git
   
2. Accédez au répertoire du projet :
   cd facture-api
   
3. Installez les dépendances nécessaires :
   npm install
   
4. Configurez les variables d'environnement en créant un fichier .env à la racine du projet avec le contenu suivant :

   PORT=3000
   MONGO_URI=mongodb://localhost:27017/factureDB
   JWT_SECRET=your_jwt_secret_key

## Utilisation

1. Démarrez le serveur :
    npm start
3. Le serveur sera accessible à l'adresse suivante :
    http://localhost:3000.
5. Vous pouvez interagir avec l'API via un client comme Postman ou cURL.

## Route de l'API

1. Authentification :
    POST /api/auth/register : Inscription d'un nouvel utilisateur.
    POST /api/auth/login : Connexion d'un utilisateur.
3. Factures :
    GET /api/factures : Récupérer toutes les factures.
    POST /api/factures : Créer une nouvelle facture.
    GET /api/factures/ : Récupérer une facture spécifique par son ID.
    PUT /api/factures/ : Mettre à jour une facture existante par son ID.
    DELETE /api/factures/ : Supprimer une facture par son ID.

### Résumé
Ce fichier regroupe toutes les étapes importantes : installation, configuration, utilisation, exemples de requêtes et contribution. Vous pouvez simplement copier-coller ce texte dans le fichier `README.md` de votre projet.

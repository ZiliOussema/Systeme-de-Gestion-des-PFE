# Système de Gestion des PFE (Projet de Fin d'Études)

## Description

Application JavaFX de gestion des Projets de Fin d'Études (PFE) permettant aux administrateurs, enseignants et étudiants de gérer l'ensemble du processus des projets de fin d'études.

## Fonctionnalités

### Pour les Administrateurs
- Gestion des enseignants (ajout, modification, suppression)
- Gestion des étudiants (ajout, modification, suppression)
- Gestion des PFE (création, suivi, validation)

### Pour les Étudiants
- Dépôt de sujets de PFE
- Dépôt de rapports
- Consultation de l'état des PFE
- Consultation des PFE disponibles

## Technologies Utilisées

- **Java 11**
- **JavaFX 13** - Interface graphique
- **Maven** - Gestion de projet et dépendances
- **JDBC** - Connexion à la base de données (DM JDBC 8)
- **FXML** - Design des interfaces

## Prérequis

- Java JDK 11 ou supérieur
- Apache Maven 3.6+
- Base de données compatible (DaMeng Database)

## Installation

1. Cloner le repository :
```bash
git clone https://github.com/ZiliOussema/Systeme-de-Gestion-des-PFE.git
cd javaproject-main
```

2. Compiler le projet :
```bash
mvn clean install
```

3. Exécuter l'application :
```bash
mvn javafx:run
```

## Structure du Projet

```
src/main/java/com/mycompany/testmaven/
├── App.java                          # Point d'entrée de l'application
├── ConnectionDB.java                 # Gestion de la connexion BD
├── enseignant.java                   # Modèle Enseignant
├── etudiant.java                     # Modèle Étudiant
└── [Contrôleurs et FXML]             # Interfaces et logique métier
```

## Configuration

Configurez la connexion à la base de données dans le fichier `ConnectionDB.java` :
- URL de la base de données
- Nom d'utilisateur
- Mot de passe

## Modules de l'Application

### Module Connexion
- Interface de connexion sécurisée
- Authentification des utilisateurs

### Module Administrateur
- Tableau de bord administrateur
- CRUD complet pour enseignants et étudiants
- Gestion centralisée des PFE

### Module Étudiant
- Page d'accueil étudiant
- Dépôt et suivi des projets
- Consultation des informations

## Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :
1. Fork le projet
2. Créer une branche pour votre fonctionnalité
3. Commit vos changements
4. Push vers la branche
5. Ouvrir une Pull Request

## Licence

Ce projet est sous licence [à définir].

## Contact

Pour toute question ou suggestion, n'hésitez pas à nous contacter.

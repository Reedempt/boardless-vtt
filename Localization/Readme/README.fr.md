# Table de jeu virtuelle multiplateforme (TV)

Une table de jeu virtuelle (TV) légère, puissante et multiplateforme, conçue pour les jeux de rôle (JDR), des systèmes grand public comme D&D et Pathfinder aux jeux indépendants de niche. Développée avec un accent particulier sur la haute performance, la maîtrise totale des données et une compatibilité matérielle optimale.

---

## 🚀 Présentation et vision du projet

L'objectif de cette TV est de combler le fossé entre les environnements de bureau haut de gamme et les appareils mobiles d'entrée de gamme. Le logiciel est conçu pour fonctionner de manière fluide sur l'ensemble du spectre matériel :

* **Cible mobile** : Optimisé pour fonctionner parfaitement sur les appareils Android d'entrée de gamme (smartphones et tablettes à moins de 200 €), ainsi que sur les appareils Apple iOS/iPadOS haut de gamme.
* **Écosystèmes de bureau** : Compatibilité native complète avec Windows, macOS et Linux (toutes distributions).

### 🛠️ Technologies utilisées

* **Langage et framework** : Kotlin Multiplatform (KMP) + Compose Multiplatform pour une interface utilisateur et une logique métier 100 % partagées entre mobile et ordinateur.
* **Stockage local** : SQLDelight pour une gestion de bases de données embarquées multiplateformes rapide, sécurisée et basée sur les types.
* **Environnement de développement** : JetBrains Suite (IntelliJ IDEA + DataGrip).

---

## 🔒 Politique de confidentialité, de sécurité des données et de monétisation

Ce logiciel est conçu autour des principes fondamentaux suivants : respect de la vie privée des utilisateurs, pleine propriété des données et transparence absolue :

* **Architecture 100 % hors ligne et locale** : Le système fonctionne entièrement hors ligne. Toutes les données, les recueils, les campagnes et les fiches de personnage sont enregistrés exclusivement dans une base de données locale sécurisée sur votre appareil.
* **Aucune synchronisation cloud ni suivi par des tiers** : Le logiciel ne télécharge pas vos données personnelles sur un serveur externe et ne les distribue ni ne les vend à des tiers. * **Avis d'authentification** : Vos données personnelles sont utilisées uniquement pour générer votre identifiant et votre mot de passe de connexion à votre profil local. En l'absence de base de données centralisée dans le cloud, **la perte de votre mot de passe ou de votre adresse e-mail enregistrée entraîne la perte définitive de l'accès à votre compte et à vos données**. Il n'existe pas de fonction de réinitialisation du mot de passe.
* **Aucune publicité, télémétrie ni logiciel superflu** : Le code source est public et accessible à tous sur GitHub, garantissant ainsi l'absence totale de logiciels publicitaires, de logiciels superflus, de scripts de suivi, de télémétrie cachée et de publicités trompeuses.
* **Aucune microtransaction** : Le logiciel ne propose aucune microtransaction, aucun achat intégré, aucun contenu payant ni aucune mécanique de jeu à débloquer.

---

## 🏗️ Écrans de jeu et rôles

#### 🔐 Authentification

* Écran de connexion universel pour les sessions de campagne locales.

#### 👑 Écran du Maître du Donjon (MD)

* **Compendium universel** : Navigateur de documentation intégré et ultra-rapide chargeant automatiquement les manuels en fonction du système de jeu actif.

* **Gestion des manuels** : Prise en charge du stockage local des manuels, lecture des données directement depuis la mémoire interne, les disques durs externes USB ou les cartes microSD.

* **Tableau de bord de campagne** : Vue d’ensemble de la campagne, lanceur de dés numérique, fiches de PNJ et créateurs d’objets personnalisés qui ajoutent du contenu à la base de données sans modifier la base de données des règles principales.

* **Centre d’approbation** : Centre de notifications en temps réel pour approuver ou refuser les modifications de fiches de personnage demandées par les joueurs.

#### ⚔️ Écran du joueur

* **Fiche de personnage interactive** : Fiches de personnage entièrement interactives et modifiables avec lanceur de dés intégré. * **Accès ciblé aux règles** : Accès direct aux manuels de jeu, filtrés exclusivement pour les mécaniques destinées aux joueurs (Capacités, Sorts, Dons, États, Races et Classes).

* **Système de synchronisation et d'alerte** : Toute modification structurelle apportée à la fiche de personnage déclenche automatiquement une alerte auprès du MJ, en attente d'approbation avant d'être définitive.

---

## 📄 Licence

Ce projet est protégé et distribué sous la **Licence stricte PolyForm 1.0.0**.

### ⚠️ Usage non commercial et restreint uniquement

* **Autorisé** : Vous pouvez utiliser ce logiciel librement pour vos loisirs personnels, vos recherches universitaires, vos études ou vos campagnes à but non lucratif.
* **Interdit** : Vous **ne pouvez pas** utiliser ce logiciel ou son code source à des fins commerciales, de monétisation ou au sein d'une entreprise.
* **Interdit** : La modification et la redistribution de ce code par des tiers sont **strictement interdites**. Seul l'auteur original détient les droits de distribution et de modification.

Pour plus de détails juridiques, veuillez consulter le fichier [LICENSE.md](./LICENSE.md) officiel situé à la racine du projet.

### 🌐 Localisations de la licence / Traductions de la licence

Pour aider les développeurs du monde entier à comprendre ces restrictions, des traductions de courtoisie sont disponibles dans le dossier [<./Localization/License/>](<./Localization/License/>) :

* 🇮🇹 [Italiano (Italien)](<./Localization/License/LICENSE.it.md>)
* 🇺🇸 [Anglais (Copie de référence)](<./Localization/License/LICENSE.en.md>)
* 🇫🇷 [Français (Français)](<./Localization/License/LICENSE.fr.md>)
* 🇪🇸 [Español (Espagnol)](<./Localization/License/LICENSE.es.md>)
* 🇩🇪 [Deutsch (allemand)](<./Localization/License/LICENSE.de.md>)
* 🇨🇳 [简体中文 (chinois)](<./Localization/License/LICENSE.zh-Hans.md>)
* 🇹🇼🇭🇰 [簡體中文 (chinois)](<./Localization/License/LICENSE.zh-Hant.md>)
* 🇯🇵 [日本語 (japonais)](<./Localization/License/LICENSE.ja.md>)
* ...et [de nombreuses autres langues](./LICENSE.md).

*Remarque : Seule la version anglaise officielle, située à la racine du site, fait foi.*

<h1>📦 Application Java de gestion des produits (POO)</h1>
<p><h3>Stock Manager est une application console Java utilisant les concepts de programmation orientée objet pour gérer l'inventaire d'une petite boutique.</h3></p>
<br/>
<h2>🎯 Objectifs du Projet</h2>
<p><h3>Cette application a été développée dans le cadre d'un projet académique pour démontrer la maîtrise des concepts fondamentaux de la programmation orientée objet (POO) en Java, notamment :</h3></p>
<ul>
<li><strong>Encapsulation :</strong>Utilisation d'attributs privés et de méthodes d'accès contrôlé</li>
<li><strong>Abstraction :</strong>Séparation des responsabilités entre les classes</li>
<li><strong>Modularité :</strong>Code structuré et réutilisable</li>
<li><strong>Gestion de tableaux d'objets :</strong>Manipulation efficace de collections de données</li>
</ul>
<br/>
<h2>✨ Fonctionnalités</h2>
<ul>
<li><strong>➕ Ajouter un produit - </strong> Création de nouveaux produits avec validation</li>
<li><strong>✏️ Modifier un produit - </strong> Mise à jour des informations existantes</li>
<li><strong>🗑️ Supprimer un produit - </strong> Suppression sécurisée avec réorganisation</li>
<li><strong>📋 Afficher la liste - </strong> Vue d'ensemble formatée de tous les produits</li>
</ul>
<br/>
<h2>🔍 Recherche et Analyse</h2>
<ul>
<li><strong>➕ Ajouter un produit - </strong> Création de nouveaux produits avec validation</li>
<li><strong>✏️ Modifier un produit - </strong> Mise à jour des informations existantes</li>
<li><strong>🗑️ Supprimer un produit - </strong> Suppression sécurisée avec réorganisation</li>
<li><strong>📋 Afficher la liste - </strong> Vue d'ensemble formatée de tous les produits</li>
</ul>
<br/>
<h2>🛡️ Sécurité et Validation</h2>
<ul>
<li>Codes produits uniques obligatoires</li>
<li>Validation des données (prix et quantités positifs)</li>
<li>Gestion des erreurs avec messages informatifs</li>
<li>Protection contre les débordements de tableau</li>
</ul>
<br/>
<h2>🏗️ Architecture</h2>
<strong><span>Classe Produit</span></strong>
<br/>
<img src="Captures/Classe-Produit.png">
<br/>
Caractéristiques :
<ul>
<li>Encapsulation complète avec getters/setters</li>
<li>Constructeurs (avec paramétres et par défaut)</li>
<li>Méthode calculerValeurTotale() pour la logique métier</li>
<li>Redéfinition de toString() pour un affichage optimisé</li>
</ul>
<br/>
<strong><span>Classe StockManager</span></strong>
<img src="Captures/stockmanager.png">
<br/>
Fonctionnalités :
<ul>
<li>Gestion statique du tableau de produits</li>
<li>Méthodes CRUD (Create, Read, Update, Delete)</li>
<li>Interface utilisateur interactive avec menuValidation et gestion d'erreurs robustes</li>
</ul>
<br/>
<h2>📱 Interface Utilisateur</h2>
<img src="Captures/ecran-principal.png">
<br/>
<h2>Scénarios de Test</h2>
<br/>
<img src="Captures/ajout-produit.png">
<br/>
<img src="Captures/liste-produits.png">
<br>
<img src="Captures/produits.png">







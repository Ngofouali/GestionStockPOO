package com.icodi;

import java.util.Scanner;

public class StockManager {
    /**
     * Classe principale pour la gestion du stock
     * Contient toutes les méthodes statiques pour manipuler le tableau de produits
     */
    // Constante pour la taille maximale du tableau
    private static final int TAILLE_MAX = 100;

    // Tableau statique de produits
    private static Produit[] produits = new Produit[TAILLE_MAX];

    // Compteur du nombre de produits actuellement en stock
    private static int nombreProduits = 0;

    // Scanner pour la saisie utilisateur
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Affiche le menu principal de l'application
     */
    public static void printMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        APPLICATION DE GESTION DE STOCK");
        System.out.println("=".repeat(50));
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher la liste des produits");
        System.out.println("5. Rechercher un produit");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("7. Quitter");
        System.out.println("=".repeat(50));
        System.out.print("Votre choix: ");
    }

    /**
     * Vérifie si un code produit existe déjà
     *
     * @param : code le code à vérifier
     * @return : true si le code existe, false sinon
     */
    private static boolean codeExiste(int code) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i] != null && produits[i].getCode() == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * Trouve l'index d'un produit par son code
     *
     * @param : code le code du produit recherché
     * @return : l'index du produit ou -1 si non trouvé
     */
    private static int trouverIndexParCode(int code) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i] != null && produits[i].getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Ajoute un nouveau produit au tableau
     *
     * @param : produit le produit à ajouter
     */
    public static void ajouterProduit(Produit produit) {
        // Vérifier si le tableau est plein
        if (nombreProduits >= TAILLE_MAX) {
            System.out.println("❌ Erreur: Le stock est plein! Impossible d'ajouter plus de produits.");
            return;
        }

        // Vérifier l'unicité du code
        if (codeExiste(produit.getCode())) {
            System.out.println("❌ Erreur: Un produit avec ce code existe déjà!");
            return;
        }

        // Ajouter le produit
        produits[nombreProduits] = produit;
        nombreProduits++;
        System.out.println("✅ Produit ajouté avec succès!");
    }

    /**
     * Modifie un produit existant
     *
     * @param : code             le code du produit à modifier
     * @param : nouveauNom       le nouveau nom
     * @param : nouvelleQuantite la nouvelle quantité
     * @param : nouveauPrix      le nouveau prix
     */
    public static void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        int index = trouverIndexParCode(code);

        if (index == -1) {
            System.out.println("❌ Produit non trouvé!");
            return;
        }

        // Validation des données
        if (nouvelleQuantite < 0 || nouveauPrix < 0) {
            System.out.println("❌ Erreur: La quantité et le prix doivent être positifs!");
            return;
        }

        // Modification du produit
        produits[index].setNom(nouveauNom);
        produits[index].setQuantite(nouvelleQuantite);
        produits[index].setPrix(nouveauPrix);

        System.out.println("✅ Produit modifié avec succès!");
    }

    /**
     * Supprime un produit du tableau
     *
     * @param code le code du produit à supprimer
     */
    public static void supprimerProduit(int code) {
        int index = trouverIndexParCode(code);

        if (index == -1) {
            System.out.println("❌ Produit non trouvé!");
            return;
        }

        // Décaler tous les éléments suivants vers la gauche
        for (int i = index; i < nombreProduits - 1; i++) {
            produits[i] = produits[i + 1];
        }

        // Nettoyer la dernière position
        produits[nombreProduits - 1] = null;
        nombreProduits--;

        System.out.println("✅ Produit supprimé avec succès!");
    }

    /**
     * Affiche la liste complète des produits
     */
    public static void afficherProduits() {
        if (nombreProduits == 0) {
            System.out.println("📦 Le stock est vide.");
            return;
        }

        System.out.println("\n📋 LISTE DES PRODUITS EN STOCK (" + nombreProduits + " produit(s)):");
        System.out.println("-".repeat(80));

        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i] != null) {
                System.out.println((i + 1) + ". " + produits[i].toString());
            }
        }
        System.out.println("-".repeat(80));
    }

    /**
     * Recherche un produit par son nom
     *
     * @param nom le nom du produit recherché
     */
    public static void rechercherProduit(String nom) {
        boolean trouve = false;
        System.out.println("\n🔍 RÉSULTATS DE RECHERCHE pour '" + nom + "':");
        System.out.println("-".repeat(60));

        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i] != null &&
                    produits[i].getNom().toLowerCase().contains(nom.toLowerCase())) {
                System.out.println("➤ " + produits[i].toString());
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("❌ Aucun produit trouvé avec ce nom.");
        }
        System.out.println("-".repeat(60));
    }

    /**
     * Calcule la valeur totale du stock
     */
    public static void calculerValeurStock() {
        if (nombreProduits == 0) {
            System.out.println("📦 Le stock est vide. Valeur totale: 0.00€");
            return;
        }

        double valeurTotale = 0.0;

        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i] != null) {
                valeurTotale += produits[i].calculerValeurTotale();
            }
        }

        System.out.println("\n💰 VALEUR TOTALE DU STOCK:");
        System.out.println("-".repeat(40));
        System.out.printf("Nombre de produits différents: %d%n", nombreProduits);
        System.out.printf("Valeur totale du stock: %.2f€%n", valeurTotale);
        System.out.println("-".repeat(40));
    }

    /**
     * Saisie sécurisée d'un entier
     */
    public static int saisirEntier(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Veuillez entrer un nombre entier valide!");
            }
        }
    }

    /**
     * Saisie sécurisée d'un double
     */
    public static double saisirDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Veuillez entrer un nombre décimal valide!");
            }
        }
    }
}
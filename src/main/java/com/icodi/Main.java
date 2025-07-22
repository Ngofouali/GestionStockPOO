package com.icodi;


import static com.icodi.StockManager.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("🚀 Démarrage de l'application de gestion de stock...\n");

        // Ajout de quelques produits de démonstration
        ajouterProduit(new Produit(1001, "Ordinateur Portable", 5, 300000.00));
        ajouterProduit(new Produit(1002, "Souris Sans Fil", 25, 10000.00));
        ajouterProduit(new Produit(1003, "Clavier Mécanique", 10, 7000.00));

        // Scanner pour la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        int choix;


        do {
            printMenu();
            choix = saisirEntier("");

            switch (choix) {
                case 1: // Ajouter un produit
                    System.out.println("\n➕ AJOUTER UN NOUVEAU PRODUIT");
                    System.out.println("-".repeat(35));

                    int code = saisirEntier("Code du produit: ");
                    System.out.print("Nom du produit: ");
                    String nom = scanner.nextLine();
                    int quantite = saisirEntier("Quantité en stock: ");
                    double prix = saisirDouble("Prix unitaire (FCFA): ");

                    if (quantite < 0 || prix < 0) {
                        System.out.println("❌ La quantité et le prix doivent être positifs!");
                    } else {
                        ajouterProduit(new Produit(code, nom, quantite, prix));
                    }
                    break;

                case 2: // Modifier un produit
                    System.out.println("\n✏️ MODIFIER UN PRODUIT");
                    System.out.println("-".repeat(25));

                    int codeModif = saisirEntier("Code du produit à modifier: ");
                    System.out.print("Nouveau nom: ");
                    String nouveauNom = scanner.nextLine();
                    int nouvelleQuantite = saisirEntier("Nouvelle quantité: ");
                    double nouveauPrix = saisirDouble("Nouveau prix (FCFA): ");

                    modifierProduit(codeModif, nouveauNom, nouvelleQuantite, nouveauPrix);
                    break;

                case 3: // Supprimer un produit
                    System.out.println("\n🗑️ SUPPRIMER UN PRODUIT");
                    System.out.println("-".repeat(25));

                    int codeSuppr = saisirEntier("Code du produit à supprimer: ");
                    supprimerProduit(codeSuppr);
                    break;

                case 4: // Afficher les produits
                    afficherProduits();
                    break;

                case 5: // Rechercher un produit
                    System.out.print("\n🔍 Nom du produit à rechercher: ");
                    String nomRecherche = scanner.nextLine();
                    rechercherProduit(nomRecherche);
                    break;

                case 6: // Calculer la valeur du stock
                    calculerValeurStock();
                    break;

                case 7: // Quitter
                    System.out.println("\n👋 Merci d'avoir utilisé l'application de gestion de stock!");
                    break;

                default:
                    System.out.println("❌ Choix invalide! Veuillez choisir entre 1 et 7.");
            }

            if (choix != 7) {
                System.out.println("\nAppuyez sur Entrée pour continuer...");
                scanner.nextLine();
            }

        } while (choix != 7);

        scanner.close();
    }
}
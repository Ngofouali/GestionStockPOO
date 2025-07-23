package com.icodi;

/**
 * Classe représentant un produit dans le stock
 * Cette classe encapsule les données d'un produit avec des attributs privés
 * et fournit des méthodes d'accès contrôlé (getters/setters)
 */

class Produit {

    private int code;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur avec tous les paramètres
    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur par défaut
    public Produit() {
        this.code = 0;
        this.nom = "";
        this.quantite = 0;
        this.prix = 0.0;
    }

    // Getters
    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    // Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        if (quantite >= 0) {
            this.quantite = quantite;
        }
    }

    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        }
    }

    /**
     * Méthode pour calculer la valeur totale du produit en stock
     * @return : valeur totale (quantité * prix unitaire)
     */
    public double calculerValeurTotale() {

        return quantite * prix;
    }

    /**
     * Redéfinition de toString pour un affichage formaté du produit
     * @return : représentation textuelle du produit
     */
    @Override
    public String toString() {
        return String.format("Code: %d | Nom: %s | Quantité: %d | Prix: %.2f FCFA | Valeur: %.2f FCFA",
                code, nom, quantite, prix, calculerValeurTotale());
    }
}

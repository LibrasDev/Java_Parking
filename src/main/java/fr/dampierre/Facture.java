package fr.dampierre;

import java.util.HashMap;
import java.util.Map;

public class Facture {

    private int id;
    private Map<Produit, Integer> produitCommandes = new HashMap<>();
    private String date;
    private Client client;

    public Facture(int id, String date, Client client) {
        this.id = id;
        this.date = date;
        this.client = client;
    }

    public double calculerPrixTTC() {
        double prixTTC = 0;
        for (Map.Entry<Produit, Integer> produitTTC : produitCommandes.entrySet()) {
            prixTTC += (produitTTC.getValue() * produitTTC.getKey().getPrixTTC());
        }
        return prixTTC;
    }

    public double calculerPrixTotalHT() {
        double prixHT = 0;
        for (Map.Entry<Produit, Integer> produitHT : produitCommandes.entrySet()) {
            prixHT += produitHT.getValue() * produitHT.getKey().getPrixHT();
        }
        return prixHT;
    }

    public void ajouterOuModifierProduit(Produit produit, int quantiteDuProduit) {
        for (Map.Entry<Produit, Integer> modifierproduit : produitCommandes.entrySet()) {
            if (produit.equals(modifierproduit.getKey())) {
                        modifierproduit.setValue(quantiteDuProduit);
                            if (modifierproduit.getValue() <= 0) {
                                produitCommandes.remove(produit);
            } else {
                produitCommandes.put(produit, quantiteDuProduit);
                }
            }
        }
    }

    public void retirerProduit(Produit produit) {
        produitCommandes.remove(produit);
    }

    public int nombreProduit() {
        return produitCommandes.size();
    }

    // Pour les tests
    public Map<Produit, Integer> getProduitCommandes() {
        return produitCommandes;
    }

    public void ajouterProduit(Produit produit, int quantiteDuProduit) {
                produitCommandes.put(produit, quantiteDuProduit);
    }
}
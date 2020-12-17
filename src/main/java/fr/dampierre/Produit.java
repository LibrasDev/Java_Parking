package fr.dampierre;

public class Produit {

    private String nom;
    private double prixHT;
    private String code;
    private Categ_Produit TVA;

    public Produit(String nom, double prixHT, String code, Categ_Produit TVA) {
        this.nom = nom;
        this.prixHT = prixHT;
        this.code = code;
        this.TVA = TVA;
    }

    public double getPrixTTC() {
        double prixTTC = (prixHT * TVA.getTVA() / 100) + prixHT;
        return prixTTC;
    }

    public double getPrixHT() {
        return prixHT;
    }
}

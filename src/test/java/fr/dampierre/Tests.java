package fr.dampierre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    void aucunProduit_ajouterPlusieursFoisMemeProduitAvecQuantiteDifferente_unProduitSurLaFacture() {
        // Arrange

        Client client = new Client("unMail@gmail.com");
        Facture facture = new Facture(1, "10-12-2020", client);

        Categ_Produit pasDeTVA = new Categ_Produit(0);
        double prixHT = 100.0;
        Produit produit = new Produit("Pomme", prixHT, "123456789", pasDeTVA);

        // Agis

        facture.ajouterProduit(produit, 1);
        facture.ajouterProduit(produit, 8);

        // Assert

        assertEquals(facture.nombreProduit(), 1, "Nombre de Produit");
    }

    @Test
    void aucunProduit_ajouter2Produit_deuxProduitsSurLaFacture() {
        // Arrange

        Client client = new Client("unMail@gmail.com");
        Facture facture = new Facture(1, "10-12-2020", client);

        Categ_Produit pasDeTVA = new Categ_Produit(0);
        double prixHT = 100.0;
        Produit produit = new Produit("Pomme", prixHT, "123456789", pasDeTVA);
        Produit produit2 = new Produit("Kiwi", prixHT, "987654321", pasDeTVA);

        // Agis

        facture.ajouterProduit(produit, 1);
        facture.ajouterProduit(produit2, 1);

        // Assert

        assertEquals(facture.nombreProduit(), 2, "Nombres de Produits");
    }

    @Test
    void unProduit_retirerUnProduit_aucunProduitSurLaFacture() {
        // Arrange

        Client client = new Client("unMail@gmail.com");
        Facture facture = new Facture(1, "10-12-2020", client);

        Categ_Produit pasDeTVA = new Categ_Produit(0);
        double prixHT = 100.0;
        Produit produit = new Produit("Pomme", prixHT, "123456789", pasDeTVA);
        facture.ajouterProduit(produit, 1);

        // Agis

        facture.retirerProduit(produit);

        // Assert

        assertEquals(facture.nombreProduit(), 0, "Nombre de Produit");
    }

    @Test
    void troisProduit_retirerDeuxMemeProduits_unProduitSurLaFacture() {
        // Arrange

        Client client = new Client("unMail@gmail.com");
        Facture facture = new Facture(1, "10-12-2020", client);

        Categ_Produit pasDeTVA = new Categ_Produit(0);
        double prixHT = 100.0;
        Produit produit = new Produit("Pomme", prixHT, "123456789", pasDeTVA);
        Produit produit2 = new Produit("Kiwi", prixHT, "987654321", pasDeTVA);
        Produit produit3 = new Produit("Banane", prixHT, "123789456", pasDeTVA);
        facture.ajouterProduit(produit, 1);
        facture.ajouterProduit(produit2, 1);
        facture.ajouterProduit(produit3, 1);

        // Agis

        facture.retirerProduit(produit);
        facture.retirerProduit(produit2);
        facture.retirerProduit(produit2);

        // Assert

        assertEquals(facture.nombreProduit(), 1, "Nombre de Produit");
    }

    @Test
    void produitSansTVA_getPrixTTC_renvoiePrixHT() {
        // Arrange

        Categ_Produit pasDeTVA = new Categ_Produit(0);
        double prixHT = 100.0;
        Produit p = new Produit("produit", prixHT, "123456789", pasDeTVA);

        // Agis

        double res = p.getPrixTTC();

        // Assert

        assertEquals(prixHT, res, "Devrait renvoyer le prix HT");
    }

    @Test
    void produitAvecTVA_getPrixTTC_renvoiePrixTTC() {
        // Arrange

        Categ_Produit pasDeTVA = new Categ_Produit(20);
        double prixTTC = 100.0;
        Produit p = new Produit("produit", prixTTC, "123456789", pasDeTVA);

        // Agis

        double res = p.getPrixTTC();

        // Assert

        assertEquals(120, res, "Devrait renvoyer le prix HT");
    }
}

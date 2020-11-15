package fr.dampierre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Cette classe permet de tester si toutes les fonctionnalités en rapport avec la classe Parc fonctionne correctement.
 */
public class ParcTest 
{

  /**
   * Cette méthode teste si la méthode <code>creerParking(capacite);</code> crée bien le
   * parking.
   */
  @Test
  void creationDeUnParking_creerParking_ParcGereUnParking() 
  {

    // Mise en place

    Parc parc = new Parc();

    // Test

    parc.creerParking(100);

    // Vérification

    assertEquals(1, parc.nbParkings());
  }

  /**
   * Cette méthode vérifie si la méthode <code>creerParking(capacite);</code> définis
   * correctement la capacité du parking que l'on crée.
   */
  @Test
  void creationDeUnParking100places_creerParking_ParcGereUnParkingDe100places() 
  {

    // Mise en place

    Parc parc = new Parc();
    int capacite = 100;

    // Test

    parc.creerParking(capacite);

    // Vérification

    assertEquals(capacite, parc.getParkings().get(0).getCapacite());
  }

  /**
   * Cette méthode teste la méthode <code>enregistrerEntree(vehicule, parking);</code>
   * de pouvoir rentrer un véhicule dans un parking du parc
   */
  @Test
  void vehiculeInscrit_jeSaisPasQuoi_devraitPouvoirEntrerDansTousLesParkings() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking2 = parc.creerParking(5);
    Vehicule vehicule = new Vehicule("1");

    parc.creerParking(5);
    parc.inscrire(vehicule.getImmatriculation());

    // Test

    boolean rentre = parc.enregistrerEntree(vehicule, parking2);

    // Vérification

    assertEquals(true, rentre);
  }

  /**
   * Cette méthode vérifie que l'inscription d'une immatriculation a un parc fonctionne correctement.
   */
  @Test
  void avecUneImmatriculation_inscrire_devraitPeuplerTableauAvecUneImmatriculation() 
  {

    Parc parc = new Parc();
    String immatriculation = "478-EF-561";
    boolean ok = parc.inscrire(immatriculation);

    assertEquals(true, ok);
    assertEquals(immatriculation, parc.getImmatriculationsAutorisees().get(0));
  }

  /**
   * Cette méthode vérifie si la méthode <code>enregistrerEntree(vehicule,parking);</code> fonctionne correctement.
   */
  @Test
  void vehiculeAutorise_enregistrerEntree_devraitRetournerTrue() 
  {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    Vehicule vehicule = new Vehicule("123-AB-456");
    parc.inscrire(vehicule.getImmatriculation());

    boolean ok = parc.enregistrerEntree(vehicule, parking);

    assertEquals(true, ok);
  }

  @Test
  void vehiculeNonAutoriseEtImmatriculationsAutoriseesNonVide_enregistrerEntree_devraitRetournerFaux() 
  {

    Parc parc = new Parc();

    Parking parking = parc.creerParking(100);
    Vehicule vehicule = new Vehicule("123-AB-456");
    String immatriculationBateau = "123456789";

    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);

    boolean ok = parc.enregistrerEntree(vehicule, parking);

    assertEquals(false, ok);
  }

  @Test
  void vehiculeAutoriseEtImmatriculationsAutoriseesNonVide_enregistrerEntree_devraitRetournerTrue() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    Vehicule vehicule = new Vehicule("123-AB-456");
    String immatriculationBateau = "123456789";
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);
    parc.inscrire(vehicule.getImmatriculation());
    parc.inscrire(immatriculationBateau);
    parc.inscrire(immatriculationBateau);

    // Test

    boolean ok = parc.enregistrerEntree(vehicule, parking);

    // Vérification

    assertEquals(true, ok);
  }

  @Test
  void parkingNonPleinVehiculeNonAutorise_enregistrerEntree_DevraitRetournerFaux() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    Vehicule vehicule1 = new Vehicule("1");
    Vehicule vehicule2 = new Vehicule("2");
    Vehicule vehiculeNonInscrite = new Vehicule("123456789");
    parc.inscrire(vehicule1.getImmatriculation());
    parc.inscrire(vehicule2.getImmatriculation());
    parking.enregistrerEntree(vehicule1);
    parking.enregistrerEntree(vehicule2);

    // Test

    boolean peutEntrer = parc.enregistrerEntree(vehiculeNonInscrite, parking);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void vehiculeNonAutorise_enregistrerEntree_devraitRetournerFaux() 
  {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    Vehicule vehicule = new Vehicule("123-AB-456");

    boolean ok = parc.enregistrerEntree(vehicule, parking);

    assertEquals(false, ok);
  }
}

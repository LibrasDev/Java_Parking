package fr.dampierre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Cette classe permet de tester si toutes les fonctionnalités en rapport avec la classe Parking fonctionne correctement.
 */
class ParkingTest 
{

  /**
   * Cette méthode
   */
  @Test
  void parkingPleinVehiculeAutorise_enregistrerEntree_DevraitRetournerFaux() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    Vehicule voiture = new Vehicule("123-AB-456");
    parc.inscrire(voiture.getImmatriculation());
    parking.enregistrerEntree(voiture);
    parking.enregistrerEntree(voiture);
    parking.enregistrerEntree(voiture);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(voiture);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void parkingPleinVehiculeNonAutorise_enregistrerEntree_DevraitRetournerFaux() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    Vehicule vehicule1 = new Vehicule("1");
    Vehicule vehicule2 = new Vehicule("2");
    Vehicule vehicule3 = new Vehicule("3");
    Vehicule voitureNonInscrite = new Vehicule("123456789");
    parc.inscrire(vehicule1.getImmatriculation());
    parc.inscrire(vehicule2.getImmatriculation());
    parc.inscrire(vehicule3.getImmatriculation());
    parking.enregistrerEntree(vehicule1);
    parking.enregistrerEntree(vehicule2);
    parking.enregistrerEntree(vehicule3);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(voitureNonInscrite);

    // Validation

    assertEquals(false, peutEntrer);
  }

  @Test
  void parkingNonPleinVehiculeAutorise_enregistrerEntree_DevraitRetournerTrue() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(3);
    Vehicule vehicule1 = new Vehicule("123");
    Vehicule vehicule2 = new Vehicule("456");
    Vehicule vehicule3 = new Vehicule("789");
    parc.inscrire(vehicule1.getImmatriculation());
    parc.inscrire(vehicule2.getImmatriculation());
    parc.inscrire(vehicule3.getImmatriculation());
    parking.enregistrerEntree(vehicule1);
    parking.enregistrerEntree(vehicule2);

    // Test

    boolean peutEntrer = parking.enregistrerEntree(vehicule3);

    // Validation

    assertEquals(true, peutEntrer);
  }


  @Test
  void avecUnVehiculeDansParking_enregistrerSortie_devraitLaisserParkingVide() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    Vehicule vehicule = new Vehicule("123-AB-456");
    parc.inscrire(vehicule.getImmatriculation());
    parking.enregistrerEntree(vehicule);

    // Test

    parking.enregistrerSortie(vehicule);

    // Validation

    assertEquals(true, parking.estVide());
  }

  @Test
  void deuxImmatriculationsIdentiques_enregistrerEntree_devraitRetournerFalse() 
  {

    // Mise en place

    Parc parc = new Parc();
    Parking parking = parc.creerParking(100);
    Vehicule vehicule = new Vehicule("123");
    parc.inscrire(vehicule.getImmatriculation());
    parking.enregistrerEntree(vehicule);

    // Test

    boolean rentre = parking.enregistrerEntree(vehicule);

    // Vérification

    assertEquals(false, rentre);
  }

  @Test
  void parkingVide_tauxDOccupation_devraitRetourner0() 
  {
    Parking parking = new Parking(100);

    double taux = parking.tauxDOccupation();

    assertEquals(0.0, taux);
  }

  @Test
  void parkingPlein_tauxDOccupation_devraitRetourner100() 
  {


    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    Vehicule vehicule1 = new Vehicule("1");
    Vehicule vehicule2 = new Vehicule("2");
    parc.inscrire(vehicule1.getImmatriculation());
    parc.inscrire(vehicule2.getImmatriculation());
    parking.enregistrerEntree(vehicule1);
    parking.enregistrerEntree(vehicule2);

    double taux = parking.tauxDOccupation();

    assertEquals(100.0, taux);
  }

  @Test
  void parkingAMoitiePlein_tauxDOccupation_devraitRetourner50() 
  {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    Vehicule vehicule = new Vehicule("1");
    parc.inscrire(vehicule.getImmatriculation());
    parking.enregistrerEntree(vehicule);

    double taux = parking.tauxDOccupation();

    assertEquals(50.0, taux);
  }

  @Test
  void avecUnVehicule_estPresente_devraitRenvoyerVraiPourCeVehicule() 
  {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    Vehicule vehicule = new Vehicule("1");
    parc.inscrire(vehicule.getImmatriculation());
    parking.enregistrerEntree(vehicule);

    boolean present = parking.estPresente(vehicule);

    assertEquals(true, present);
  }

  @Test
  void avecParkingVide_estPresente_devraitRenvoyerFaux() 
  {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);
    Vehicule vehicule = new Vehicule("1");
    parc.inscrire(vehicule.getImmatriculation());

    boolean present = parking.estPresente(vehicule);

    assertEquals(false, present);
  }

  @Test
  void avecUnVehicule_estPresente_devraitRenvoyerFauxPourUnAutreVehicule() 
  {

    Parc parc = new Parc();
    Parking parking = parc.creerParking(2);

    Vehicule vehicule1 = new Vehicule("1");
    parc.inscrire(vehicule1.getImmatriculation());
    parking.enregistrerEntree(vehicule1);

    Vehicule vehicule2 = new Vehicule("2");
    parc.inscrire(vehicule2.getImmatriculation());

    boolean present = parking.estPresente(vehicule2);

    assertEquals(false, present);
  }
}

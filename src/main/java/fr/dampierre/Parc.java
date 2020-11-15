package fr.dampierre;

import java.util.ArrayList;
import java.util.List;

public class Parc 
{

  private List<Parking> parkings;
  private List<String> immatriculationsAutorisees;

  /**
   * Initialisation d'un objet Parc, cet objet a deux listes, une liste avec des parkings,
   * et une liste avec les immatriculations autorisées.
   */
  public Parc() 
  {
    parkings = new ArrayList<>();
    immatriculationsAutorisees = new ArrayList<>();
  }

  /**
   * Cette méthode permet d'obtenir la liste des immatriculations autorisées.
   * @return <b>List<String></b>
   */
  public List<String> getImmatriculationsAutorisees() 
  {
    return immatriculationsAutorisees;
  }

  /**
   * Cette méthode permet de créer un objet de la classe Parking avec la quantité de place que vous lui donner en paramètre.
   * @param int capacite
   * @return <b>Parking</b>
   */
  public Parking creerParking(int capacite) 
  {
    Parking parking = new Parking(capacite);
    parkings.add(parking);
    return parking;
  }

  /**
   * Cette méthode permet d'obtenir le nombre de places du parking.
   * @return <b>int</b>
   */
  public int nbParkings() 
  {
    return parkings.size();
  }

  /**
   * Cette méthode permet d'obtenir la liste des parkings.
   * @return <b>List<Parking></b>
   */
  public List<Parking> getParkings() 
  {
    return parkings;
  }

  /**
   * Cette méthode permet d'ajouter une immatriculation de type chaine de caractères a la liste des immatriculations autorisées.
   * La méthode retourne vrai si l'opération a réussi a ajouter l'immatriculation sinon elle retourne faux.
   * @return <b>boolean</b>
   */
  public boolean inscrire(String immatriculation) 
  {
    return immatriculationsAutorisees.add(immatriculation);
  }

  /**
   * Cette méthode permet d'enregistrer un véhicule dans ce parking.
   * @param Voiture
   * @param Parking
   * @return <b>boolean</b>
   */
  public boolean enregistrerEntree(Vehicule vehicule, Parking parking) 
  {
    if (estAutorisee(vehicule)) 
    {
      if (parking.enregistrerEntree(vehicule)) 
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Cette méthode permet de savoir si l'immatriculation donné se trouve dans la liste des immatriculation autorisées.
   * Si la méthode renvoie vraie c'est que le véhicule figure dans la liste des véhicules inscrits au parc.
   * @param String immatriculation
   * @return <b>boolean</b>
   */
  private boolean estAutorisee(Vehicule vehicule) 
  {
    return immatriculationsAutorisees.contains(vehicule.getImmatriculation());
  }

  /**
   * Cette méthode permet d'afficher les immatriculations autorisées de la liste des immatriculation autorisées.
   */
  public void afficherImmatriculationsAutorisees() 
  {
    for (String imm : immatriculationsAutorisees) 
    {
      System.out.println(imm);
    }
  }

  /**
   * Cette méthode
   */
  public void afficherImmatriculationsPresentes() 
  {
    System.out.println("Nombre de parkings : " + parkings.size());
    System.out.println("Liste des immatriculations :");

    for (Parking parking : parkings) 
    {
      parking.affichervehiculesPresents();
    }
  }
}

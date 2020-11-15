package fr.dampierre;

import java.util.ArrayList;
import java.util.List;

public class Parking 
{

  private int capacite;
  private List<Vehicule> vehiculesPresents = new ArrayList<Vehicule>();

  public Parking(int capacite) 
  {
    this.capacite = capacite;
  }

  /**
   * Cette méthode permet de retourner le nombre de véhicules présents dans ce parking.
   * @return <b>int</b>
   */
  public int getNbVehiculesPresents() 
  {
    return vehiculesPresents.size();
  }

  /**
   * Cette méthode permet d'enregistrer un véhicule dans ce parking.
   * <p>La méthode renvoie faux si ce parking est plein ou si un autre véhicule qui est
   *  déjà dans la liste des véhicules présents sur ce parking est éxactement le même
   *  que celui entré en paramètre de cette méthode.</p>
   * @param vehicule
   * @return <b>boolean</b>
   */
  public boolean enregistrerEntree(Vehicule vehicule) 
  {
    if (estPlein() == false && estPresente(vehicule) == false) 
    {
      vehiculesPresents.add(vehicule);
      return true;
    }
    return false;
  }

  /**
   * Cette méthode vérifie que le véhicule n'est pas le même d'un des véhicules présents sur le parking.
   * <p>La méthode renvoie une valeur booléenne, si la valeur est faux c'est que le véhicule n'aura pas été trouvé dans la liste des véhicules présents.</p>
   * @param voiture
   * @return <b>boolean</b>
   */
  public boolean estPresente(Vehicule vehicule) 
  {
    return vehiculesPresents.contains(vehicule);
  }

  /**
   * Cette méthode permet d'enlever le véhicule envoyé en paramètre de la liste des véhicules présents sur ce parking.
   * <p>La méthode renvoie une valeur booléenne, si la valeur est fausse c'est que le véhicule n'aura pas été trouvé dans la liste des véhicules présents.</p>
   * @param vehicule
   * @return <b>boolean</b>
   */
  public boolean enregistrerSortie(Vehicule vehicule) 
  {
    return vehiculesPresents.remove(vehicule);
  }

  /**
   * Cette méthode vérifie si le parking peut acceuillir le véhicule, la méthode renvoie vraie si le parking est plein.
   * @return <b>boolean</b>
   */
  private boolean estPlein() 
  {
    return vehiculesPresents.size() >= capacite;
  }

  /**
   * Cette méthode renvoie vraie si aucune voiture est présente sur la parking.
   * @return <b>boolean</b>
   */
  public boolean estVide() 
  {
    return vehiculesPresents.isEmpty();
  }

  /**
   * Cette méthode permet d'afficher chaque véhicule sur un terminal avec la plaque d'immatriculation.
   */
  public void affichervehiculesPresents() 
  {
    for (Vehicule vehicule : vehiculesPresents) 
    {
      System.out.println("Le véhicule avec sa plaque d'immatriculation " + vehicule.getImmatriculation() + " est présent.");
    }
  }

  /**
   * Cette méthode permet de savoir a combien de pourcent le parking est rempli
   * <p>Exemple : </p>
   * <p>0% = parking vide</p>
   * <p>100% = parking plein</p>
   * @return <b>double</b>
   */
  public double tauxDOccupation() 
  {
    return (double) vehiculesPresents.size() / capacite * 100.0;
  }

  /**
   * Cette méthode permet d'obtenir le nombre de place de véhicules que la parking peut contenir au maximum.
   * @return <b>int</b>
   */
  public int getCapacite() 
  {
    return capacite;
  }
}

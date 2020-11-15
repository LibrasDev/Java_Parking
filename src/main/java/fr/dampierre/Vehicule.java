package fr.dampierre;

/**
 * Cette classe permet d'instancier des véhicules de n'importe quel type, les véhicules ne comporte que l'immatriculation et le nombre de passager.
 * @since 1.0
 * @author Maxime
 */
public class Vehicule
{
    private String immatriculation;
    private int nombreDePassager;

    /**
     * Ce constructeur permet d'initialiser un objet de la classe Voiture avec comme seul paramètre son immatriculation.
     * @param immatriculation
     * @since 1.0
     * @author Maxime
     */
    public Vehicule(String immatriculation)
    {
        this.immatriculation = immatriculation;
    }

    /**
     * Ce constructeur permet d'initialiser un objet de la classe Voiture
     * avec comme paramètre l'immatriculation de la voiture et le nombre de passager.
     * @param immatriculation
     * @param nombreDePassager
     * @since 1.0
     * @author Maxime
     */
    public Vehicule(String immatriculation, int nombreDePassager)
    {
        this.immatriculation = immatriculation;
        this.nombreDePassager = nombreDePassager;
    }

    /**
     * Cette méthode permet d'obtenir l'immatriculation du véhicule.
     * @return <b>String</b>
     * @since 1.0
     * @author Maxime
     */
    public String getImmatriculation() 
    {
        return immatriculation;
    }

    /**
     * Cette méthode permet d'obtenir le nombre de passager de la voiture.
     * @return <b>int</b>
     * @since 1.0
     * @author Maxime
     */
    public int getNombrePassager() 
    {
        return nombreDePassager;
    }

}

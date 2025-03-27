package src.attaque;

import src.canard.Canard;

/**
 * Représente un boost d'attaque d'une certaine quantitée.
 * Le boost peut-être ajouté ou multiplié avec la valeur d'attaque de base du canard.
 * Il est ajouté dans le cas des canards de feu et multiplié pour les canards de vent.
 */
public class BoostAttaque extends AttaqueSpeciale{
    private int quantite;
    // True pour additionner le boost et false pour multiplier le boost
    private boolean addition;

    public BoostAttaque(Canard utilisateur, int qt, boolean addition) {
        super(utilisateur);
        this.addition = addition;
        this.quantite = qt;
    }

    @Override
    /**
     * On ajoute ou multiplie l'attaque actuelle avec la quantité du boost.
     */
    public void utiliserAttaque(Canard cible) {
        int attaqueActuelle = this.utilisateur.getPointsAttaque();

        if(this.addition){
            this.utilisateur.setPointsAttaque(attaqueActuelle + this.quantite);
        } else{
            this.utilisateur.setPointsAttaque(attaqueActuelle * this.quantite);
        }

        this.utilisee = true;
    }
}

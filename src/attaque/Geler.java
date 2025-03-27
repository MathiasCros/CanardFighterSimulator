package src.attaque;

import src.canard.Canard;
import src.statut.Gel;

/**
 * Représente une attaque spéciale qui inflige un statut Gel au canard adverse.
 */
public class Geler extends AttaqueSpeciale {

    public Geler(Canard utilisateur) {
        super(utilisateur);
    }

    @Override
    public void utiliserAttaque(Canard cible) {
        cible.addStatut(new Gel(1, cible));
        this.utilisee = true;
    }
}

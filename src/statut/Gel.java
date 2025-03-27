package src.statut;

import src.canard.Canard;

/**
 * Représente l'état Gel. Un canard gelé passe son tour actuel.
 */
public class Gel extends Statut{
    public Gel(int tours, Canard hote) {
        super(tours, hote);
    }

    @Override
    public void activerEffet() {
        this.getHote().setPasserTour(true);
        this.setToursActifs(this.getToursActifs() - 1);
    }
}

package src.statut;

import src.canard.Canard;

/**
 * Représente un statut qui peut être appliqué sur un canard, "l'hôte" dans les attributs.
 */
public abstract class Statut {
    private int toursActifs;
    private Canard hote;

    public Statut(int tours, Canard hote){
        this.toursActifs = tours;
        this.hote = hote;
    }

    public abstract void activerEffet();

    public int getToursActifs() {
        return toursActifs;
    }

    public void setToursActifs(int toursActifs) {
        this.toursActifs = toursActifs;
    }

    public Canard getHote() {
        return hote;
    }

    public void setHote(Canard hote) {
        this.hote = hote;
    }
}

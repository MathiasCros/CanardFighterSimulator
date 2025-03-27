package src.canard;

import src.attaque.Geler;

public class CanardGlace extends Canard {
    public CanardGlace(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.GLACE);
        this.setAttaqueSpeciale(new Geler(this));
    }
}

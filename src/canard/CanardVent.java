package src.canard;

import src.attaque.BoostAttaque;

public class CanardVent extends Canard {
    public CanardVent(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.VENT);
        this.setAttaqueSpeciale(new BoostAttaque(this, 2, false));
    }

    @Override
    public void reinitAttaque(){
        int attaqueActuelle = this.getPointsAttaque();
        // L'attaque était multipliée par deux donc on la divise par deux
        this.setPointsAttaque(attaqueActuelle / 2);
    }
}
package src.canard;

import src.attaque.Soin;

public class CanardEau extends Canard {
    public CanardEau(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.EAU);
        this.setAttaqueSpeciale(new Soin(this,20));
    }
}

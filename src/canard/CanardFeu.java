package src.canard;

import src.attaque.BoostAttaque;

public class CanardFeu extends Canard {
    public CanardFeu(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.FEU);
        this.setAttaqueSpeciale(new BoostAttaque(this, 10, true));
    }

    @Override
    public void reinitAttaque(){
        int attaqueActuelle = this.getPointsAttaque();
        // On a ajouté 10 à l'attaque donc on soustrait 10
        this.setPointsAttaque(attaqueActuelle - 10);
    }
}

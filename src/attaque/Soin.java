package src.attaque;

import src.canard.Canard;

public class Soin extends AttaqueSpeciale{
    private int quantite;

    public Soin(Canard utilisateur, int qt) {
        super(utilisateur);
        this.quantite = qt;
    }

    @Override
    public void utiliserAttaque(Canard cible) {
        int pv = this.utilisateur.getPointsVie();
        this.utilisateur.setPointsVie(pv + this.quantite);
        this.utilisee = true;
    }
}

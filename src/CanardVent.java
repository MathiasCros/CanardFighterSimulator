package src;

public class CanardVent extends Canard {
    public CanardVent(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.VENT);
    }

    @Override
    public void activerAttaqueSpeciale(Canard adversaire) {
        // augment sa vitesse d'attaque x2 x3
    }

}

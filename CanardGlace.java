package projet;

public class CanardGlace extends Canard {
    public CanardGlace(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.GLACE);
    }

    @Override
    public void activerAttaqueSpeciale(Canard adversaire) {
        // fait perdre un tour à l'adversaire
    }
}

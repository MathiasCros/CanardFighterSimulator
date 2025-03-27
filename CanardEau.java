package projet;

public class CanardEau extends Canard {
    public CanardEau(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.EAU);
    }

    @Override
    public void activerAttaqueSpeciale(Canard adversaire) {
        this.setPointsVie(this.getPointsVie() + 20);
    }
}

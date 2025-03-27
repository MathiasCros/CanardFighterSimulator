package src;

public class CanardFeu extends Canard {


    public CanardFeu(String nom, int pointsVie, int pointsAttaque) {
        super(nom, pointsVie, pointsAttaque);
        this.setType(TypeCanard.FEU);
    }

    @Override
    public void activerAttaqueSpeciale(Canard adversaire) {
        // inflige plus de dégâts pdt un tour
    }
}

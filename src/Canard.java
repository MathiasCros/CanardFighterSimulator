package src;

public abstract class Canard {
    private final String nom;
    private TypeCanard type;
    private int pointsVie;
    private int pointsAttaque;

    public Canard(String nom, int pointsVie, int pointsAttaque){
        this.nom = nom;
        this.pointsVie = pointsVie;
        this.pointsAttaque = pointsAttaque;
    }

    public void attaquer(Canard c){
        double multiplicateur = TypeCanard.getMultiplicateur(this.type, c.getType());
        c.subirDegats((int)(this.pointsAttaque * multiplicateur));
    }

    public abstract void activerAttaqueSpeciale(Canard adversaire);

    public void subirDegats(int degats){
        this.pointsVie -= degats;

        if(this.pointsVie < 0) {
            this.pointsVie = 0;
        }
    }

    public boolean estKO(){
        return this.pointsVie == 0;
    }

    public void setPointsVie(int pdv){
        this.pointsVie = pdv;
    }

    public void setType(TypeCanard type) {
        this.type = type;
    }

    public String getNom(){
        return this.nom;
    }

    public int getPointsVie(){
        return this.pointsVie;
    }

    public int getPointsAttaque(){
        return this.pointsAttaque;
    }

    public TypeCanard getType(){
        return this.type;
    }
}

package src.canard;

import src.attaque.AttaqueSpeciale;
import src.statut.Statut;

import java.util.ArrayList;
import java.util.List;

public abstract class Canard {
    private final String nom;
    private TypeCanard type;
    private int pointsVie;
    private int pointsAttaque;
    private List<Statut> status;
    private boolean passerTour;
    private AttaqueSpeciale attaqueSpeciale;

    public Canard(String nom, int pointsVie, int pointsAttaque) {
        this.nom = nom;
        this.pointsVie = pointsVie;

        // Les points d'attaque sont un nombre positif ou zéro.
        this.pointsAttaque = Math.max(pointsAttaque, 0);

        this.passerTour = false;
        this.status = new ArrayList<>();
    }

    public void attaquer(Canard c) {
        if(this.estKO()){
            throw new RuntimeException("Le canard est KO !");
        }

        if (c == this) {
            throw new IllegalArgumentException("Un canard ne peut pas s'attaquer lui-même !!");
        }

        // On active les effets des statuts du canard avant d'attaquer.

        // On fait une deuxième liste pour éviter les accès concurrents,
        // à savoir supprimer un statut pendant qu'on parcours la liste des statuts.
        List<Statut> statutsASupprimer = new ArrayList<>();

        for (Statut s : this.status) {
            s.activerEffet();
            // Le statut réduit ses tours restants dès l'activation.
            if (s.getToursActifs() <= 0) {
                statutsASupprimer.add(s);
            }
        }

        for (Statut s : statutsASupprimer) {
            this.status.remove(s);
        }

        if (!this.passerTour) {
            double multiplicateur = TypeCanard.getMultiplicateur(this.type, c.getType());
            c.subirDegats((int) (this.pointsAttaque * multiplicateur));

        } else {
            this.passerTour = false;
        }

        // Utilisé dans le cas où l'attaque a été boostée.
        if (this.attaqueSpeciale.utilisee()) {
            this.reinitAttaque();
        }
    }

    public void activerAttaqueSpeciale(Canard adversaire) {
        if(this.estKO()){
            throw new RuntimeException("Le canard est KO !");
        }

        if (!this.attaqueSpeciale.utilisee()) {
            this.attaqueSpeciale.utiliserAttaque(adversaire);
        }
    }

    public void reinitAttaque() {
    }

    public void subirDegats(int degats) {
        this.pointsVie -= degats;

        if (this.pointsVie < 0) {
            this.pointsVie = 0;
        }
    }

    public boolean estKO() {
        return this.pointsVie == 0;
    }

    public void setPointsVie(int pdv) {
        this.pointsVie = pdv;
    }

    public void setType(TypeCanard type) {
        this.type = type;
    }

    public void setPointsAttaque(int pointsAttaque) {
        this.pointsAttaque = pointsAttaque;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPointsVie() {
        return this.pointsVie;
    }

    public int getPointsAttaque() {
        return this.pointsAttaque;
    }

    public TypeCanard getType() {
        return this.type;
    }

    public void addStatut(Statut s) {
        this.status.add(s);
    }

    public void removeStatut(Statut s) {
        this.status.remove(s);
    }

    public boolean passerTour() {
        return passerTour;
    }

    public void setPasserTour(boolean passerTour) {
        this.passerTour = passerTour;
    }

    public void setAttaqueSpeciale(AttaqueSpeciale attaqueSpeciale) {
        this.attaqueSpeciale = attaqueSpeciale;
    }

    public List<Statut> getStatus() {
        return status;
    }
}

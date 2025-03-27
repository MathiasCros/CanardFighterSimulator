package src.attaque;

import src.canard.Canard;

/**
 * Représente une attaque spéciale utilisable par un canard.
 * L'attaque ne pouvant être utilisée qu'une fois par bataille, on utilise un attribut booléen "utilisee".
 */
public abstract class AttaqueSpeciale {
    // Les attributs sont protected pour pouvoir manipuler plus facilement le canard et ses attributs.
    protected boolean utilisee;
    protected Canard utilisateur;

    public AttaqueSpeciale(Canard utilisateur) {
        this.utilisateur = utilisateur;
        this.utilisee = false;
    }

    public abstract void utiliserAttaque(Canard cible);

    public boolean utilisee() {
        return utilisee;
    }
}

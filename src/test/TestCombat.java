package src.test;

import org.junit.Test;
import src.canard.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCombat {
    @Test
    public void testAttaqueSansMultiplicateur(){
        Canard eau1 = new CanardEau("Eau 1", 30, 10);
        Canard eau2 = new CanardEau("Eau 2", 30, 10);

        Canard feu1 = new CanardFeu("Feu 1", 30, 10);

        Canard glace1 = new CanardGlace("Glace 1", 30, 0);
        Canard glace2 = new CanardGlace("Glace 2", 30, 10);

        Canard vent1 = new CanardVent("Vent 1", 30, 30);
        Canard vent2 = new CanardVent("Vent 2", 30, 10);

        eau1.attaquer(eau2);
        eau2.attaquer(eau1);
        assertEquals(20, eau1.getPointsVie());
        assertEquals(20, eau2.getPointsVie());

        // Ce n'est pas terrible si on veut changer un jour le message de l'exception
        // mais je n'ai pas trouvé mieux.
        try {
            feu1.attaquer(feu1);
        } catch (IllegalArgumentException e){
            assertEquals("Un canard ne peut pas s'attaquer lui-même !!", e.getMessage());
        }

        glace1.attaquer(glace2);
        glace2.attaquer(glace1);
        assertEquals(20, glace1.getPointsVie());
        assertEquals(30, glace2.getPointsVie());

        vent1.attaquer(vent2);
        assertTrue(vent2.estKO());
    }

    @Test
    public void testAttaqueAvecMultiplicateur(){
        Canard eau1 = new CanardEau("Eau 1", 30, 10);
        Canard feu1 = new CanardFeu("Feu 1", 30, 10);
        Canard vent1 = new CanardVent("Vent 1", 30, 30);

        Canard feu2 = new CanardFeu("Feu 2", 30, 10);
        Canard glace2 = new CanardGlace("Glace 2", 30, 10);
        Canard eau2 = new CanardEau("Eau 2", 30, 10);

        Canard glace3 = new CanardGlace("Glace 1", 30, 10);
        Canard vent3 = new CanardVent("Vent 2", 30, 10);
        Canard feu3 = new CanardFeu("Feu 2", 30, 10);

        Canard glace4 = new CanardGlace("Glace 1", 30, 10);
        Canard vent4 = new CanardVent("Vent 2", 30, 10);
        Canard eau4 = new CanardEau("Eau 2", 30, 10);

        eau1.attaquer(feu1);
        assertEquals((int)(30 - 1.5 * 10), feu1.getPointsVie());
        eau1.attaquer(vent1);
        assertEquals((int)(30 - 0.5 * 10), vent1.getPointsVie());

        feu2.attaquer(eau2);
        assertEquals((int)(30 - 0.5 * 10), eau2.getPointsVie());
        feu2.attaquer(glace2);
        assertEquals((int)(30 - 1.5 * 10), glace2.getPointsVie());

        glace3.attaquer(vent3);
        assertEquals((int)(30 - 1.5 * 10), vent3.getPointsVie());
        glace3.attaquer(feu3);
        assertEquals((int)(30 - 0.5 * 10), feu3.getPointsVie());

        vent4.attaquer(eau4);
        assertEquals((int)(30 - 1.5 * 10), eau4.getPointsVie());
        vent4.attaquer(glace4);
        assertEquals((int)(30 - 0.5 * 10), glace4.getPointsVie());
    }


    @Test
    public void testAttaqueSpeciale(){
        Canard eau1 = new CanardEau("Eau 1", 50, 40);
        Canard eau2 = new CanardEau("Eau 2", 50, 40);

        Canard feu1 = new CanardFeu("Feu 1", 50, 10);
        Canard feu2 = new CanardFeu("Feu2", 50, 10);

        Canard vent1 = new CanardVent("Vent 1", 50, 10);
        Canard vent2 = new CanardVent("Vent 1", 50, 10);

        Canard glace1 = new CanardGlace("Glace 1", 50, 10);
        Canard glace2 = new CanardGlace("Glace 1", 50, 10);

        feu1.activerAttaqueSpeciale(null);
        feu1.attaquer(feu2);
        assertEquals(30, feu2.getPointsVie());
        feu1.attaquer(feu2);
        // Le bonus d'attaque est épuisé
        assertEquals(20, feu2.getPointsVie());

        eau1.attaquer(eau2);
        assertEquals(10, eau2.getPointsVie());
        eau2.activerAttaqueSpeciale(null);
        assertEquals(30, eau2.getPointsVie());

        vent1.activerAttaqueSpeciale(null);
        vent1.attaquer(vent2);
        assertEquals(30, vent2.getPointsVie());
        vent1.attaquer(vent2);
        // Le bonus d'attaque est épuisé
        assertEquals(20, vent2.getPointsVie());

        glace1.activerAttaqueSpeciale(glace2);
        glace2.attaquer(glace1);
        // Aucune attaque réalisée
        assertEquals(50, glace1.getPointsVie());

        glace2.attaquer(glace1);
        assertEquals(40, glace1.getPointsVie());
        // La statut a été enlevé
        assertTrue(glace2.getStatus().isEmpty());
    }
}
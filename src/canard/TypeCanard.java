package src.canard;

public enum TypeCanard {
    EAU, FEU, GLACE, VENT;

    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible){
        // 1.5 - 1 - 0.5

        // TODO : à remplacer
        // TODO : faire des enum pour les multiplicateurs ??

        if(attaquant.equals(TypeCanard.EAU) && cible.equals(TypeCanard.FEU)){
            return 1.5;
        }

        if(attaquant.equals(TypeCanard.FEU) && cible.equals(TypeCanard.EAU)){
            return 0.5;
        }

        if(attaquant.equals(TypeCanard.FEU) && cible.equals(TypeCanard.GLACE)){
            return 1.5;
        }

        if(attaquant.equals(TypeCanard.GLACE) && cible.equals(TypeCanard.FEU)){
            return 0.5;
        }

        if(attaquant.equals(TypeCanard.GLACE) && cible.equals(TypeCanard.VENT)){
            return 1.5;
        }

        if(attaquant.equals(TypeCanard.VENT) && cible.equals(TypeCanard.GLACE)){
            return 0.5;
        }

        if(attaquant.equals(TypeCanard.VENT) && cible.equals(TypeCanard.EAU)){
            return 1.5;
        }
        if(attaquant.equals(TypeCanard.EAU) && cible.equals(TypeCanard.VENT)){
            return 0.5;
        }

        return 1;
    }
}

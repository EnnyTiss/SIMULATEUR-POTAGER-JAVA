package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.*;

public class CaseCultivable extends Case {

    private Legume legume;
    public CaseCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }

    @Override
    public void actionUtilisateur() {
        if (legume == null) {
            legume = new Salade();
        } else {
            legume = null;
        }
    }

    @Override
    public void actionUtilisateur(String choix) {
        if (legume == null) {
            switch(choix) {
                case "salade":
                    legume = new Salade();
                    break;
                case "carotte":
                    legume = new Carotte();
                    break;
                case "tomate":
                    legume = new Tomate();
                    break;
                case "radis":
                    legume = new Radis();
                    break;
            }
        } else {
            legume = null;
        }
    }

    public Legume getLegume() {
        return legume;
    }

    @Override
    public void run() {
        if (legume != null) {
            legume.nextStep();
        }
    }
}

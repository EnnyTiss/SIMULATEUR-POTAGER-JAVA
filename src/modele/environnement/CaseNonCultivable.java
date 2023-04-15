package modele.environnement;

import modele.SimulateurPotager;

public class CaseNonCultivable extends Case {
    public CaseNonCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }

    @Override
    public void actionUtilisateur() {
        // TODO
    }

    public void actionUtilisateur(String choix) {
        // à laisser vide sinon erreur
    }
    @Override
    public void run() {
        // TODO
    }
}

package modele;

import modele.Ordonnanceur;
import modele.SimulateurPotager;

public class SimulateurMeteo implements Runnable {
    private SimulateurPotager simPot;
    public SimulateurMeteo(SimulateurPotager _simPot) {
        Ordonnanceur.getOrdonnanceur().add(this);
        simPot = _simPot;
    }



    @Override
    public void run() {
        //print ensoleillement et précipitations de la case 0,0
        System.out.println("Ensoleillement: " + simPot.getEnsoleillement(0, 0) + " Précipitations: " + simPot.getPrécipitations(0, 0));
        // pour chaque case set précipitations et ensolleillement
        int rand = (int) (Math.random() * 20);
        for (int x = 0; x < simPot.SIZE_X; x++) {
            for (int y = 0; y < simPot.SIZE_Y; y++) {
                // affiche x et y
                //System.out.println("x: " + x + " y: " + y);
                if (rand < 10) {
                    try {
                        simPot.setEnsoleillement(x, y, (int) (rand + (simPot.getEnsoleillement(x, y)/1.1)));
                        simPot.setPrécipitations(x, y, (int) (simPot.getPrécipitations(x, y)/1.2));

                    } catch (Exception e) {
                    }
                } else {
                    try {
                        simPot.setPrécipitations(x, y, (int) ((rand - 10) + (simPot.getPrécipitations(x, y))/1.1));
                        simPot.setEnsoleillement(x, y, (int) (simPot.getEnsoleillement(x, y)/1.2));
                    } catch (Exception e) {
                    }

                }
            }
        }
    }
}

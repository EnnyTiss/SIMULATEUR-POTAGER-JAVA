/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import modele.environnement.Case;
import modele.environnement.CaseCultivable;
import modele.environnement.CaseNonCultivable;

import java.awt.Point;
import java.util.Random;


public class SimulateurPotager {

    public static final int SIZE_X = 20;
    public static final int SIZE_Y = 10;

    private SimulateurMeteo simMet;

    // private HashMap<Case, Point> map = new  HashMap<Case, Point>(); // permet de récupérer la position d'une entité à partir de sa référence
    private Case[][] grilleCases = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une entité à partir de ses coordonnées

    public SimulateurPotager() {

        initialisationDesEntites();

        simMet = new SimulateurMeteo(this);

    }

    public int getPrécipitations(int x, int y) {
        return grilleCases[x][y].getPrécipitations();
    }

    public int getEnsoleillement(int x, int y) {
        return grilleCases[x][y].getEnsoleillement();
    }

    public void setPrécipitations(int x, int y, int précipitations) {
        grilleCases[x][y].setPrécipitations(précipitations);
    }

    public void setEnsoleillement(int x, int y, int ensolleillement) {
        grilleCases[x][y].setEnsoleillement(ensolleillement);
    }



    
    public Case[][] getPlateau() {
        return grilleCases;
    }
    
    private void initialisationDesEntites() {

        // murs extérieurs horizontaux
        for (int x = 0; x < SIZE_X; x++) {
            addEntite(new CaseNonCultivable(this), x, 0);
            addEntite(new CaseNonCultivable(this), x, SIZE_Y - 1);
        }

        // murs extérieurs verticaux
        for (int y = 1; y < SIZE_Y; y++) {
            addEntite(new CaseNonCultivable(this), 0, y);
            addEntite(new CaseNonCultivable(this), SIZE_X - 1, y);
        }


        Random rnd = new Random();


        //set le type de champ aleatoirement
        String choix;
        int randChoix = rnd.nextInt(4);
        if (randChoix == 0) {
            choix = "salade";
        } else if (randChoix == 1) {
            choix = "tomate";
        } else if (randChoix == 2) {
            choix = "carotte";
        } else if (randChoix == 3) {
            choix = "radis";
        }
        else {
            choix = "salade";
        }

        for (int x = 1; x < SIZE_X - 1; x++) {
            for (int y = 1; y < SIZE_Y - 1; y++) {
                CaseCultivable cc = new CaseCultivable(this);
                CaseCultivable cc2 = new CaseCultivable(this);
                CaseCultivable cc3 = new CaseCultivable(this);
                addEntite(cc , x, y);

                //70% de chance d'avoir un legume
                if (rnd.nextInt(100) < 5) {
                    cc.actionUtilisateur(choix);
                }


                Ordonnanceur.getOrdonnanceur().add(cc);
                Ordonnanceur.getOrdonnanceur().add(cc2);



            }
        }

    }

    public void actionUtilisateur(int x, int y, String choix) {
        if (grilleCases[x][y] != null) {
            grilleCases[x][y].actionUtilisateur(choix);
        }
    }

    private void addEntite(Case e, int x, int y) {
        grilleCases[x][y] = e;
        //map.put(e, new Point(x, y));
    }


    private Case objetALaPosition(Point p) {
        Case retour = null;
        return grilleCases[p.x][p.y];
    }

}

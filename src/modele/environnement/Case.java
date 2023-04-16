/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.environnement;

import modele.SimulateurPotager;

public abstract class Case implements Runnable {
    protected SimulateurPotager simulateurPotager;

    private int précipitations = 0;
    private int ensolleillement = 0;

    
    public Case(SimulateurPotager _simulateurPotager) {
        simulateurPotager = _simulateurPotager;
        précipitations = 0;
        ensolleillement = 0;
    }

    public int getPrécipitations() {
        return précipitations;
    }

    public void setPrécipitations(int précipitations) {
        this.précipitations = précipitations;
    }

    public int getEnsoleillement() {
        return ensolleillement;
    }

    public void setEnsoleillement(int ensolleillement) {
        this.ensolleillement = ensolleillement;
    }

    public abstract void actionUtilisateur();
    public abstract void actionUtilisateur(String choix);

  }

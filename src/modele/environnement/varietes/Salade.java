package modele.environnement.varietes;

public class Salade extends Legume {

    //constructeur pour initialiser le temps de croissance
    public Salade() {
        super();
        this.setTemps_croissanceMax(45);
        this.setEnsoleillementIdeal(12);
        this.setPrecipitationIdeal(10);
        this.setVariete(Varietes.salade);
        this.setResistance(6);
    }
}

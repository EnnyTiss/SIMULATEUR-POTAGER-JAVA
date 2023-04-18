package modele.environnement.varietes;

public class Salade extends Legume {

    //constructeur pour initialiser le temps de croissance
    public Salade() {
        super();
        this.setTempsCroissance(10);
        this.setEnsoleillementIdeal(6);
        this.setPrecipitationIdeal(5);
        this.setVariete(Varietes.salade);
    }
}

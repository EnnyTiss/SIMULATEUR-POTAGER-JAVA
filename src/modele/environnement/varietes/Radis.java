package modele.environnement.varietes;

public class Radis extends Legume{

    //constructeur pour initialiser le temps de croissance
    public Radis() {
        super();
        this.setTempsCroissance(10);
        this.setEnsoleillementIdeal(6);
        this.setPrecipitationIdeal(2);
        this.setVariete(Varietes.radis);

    }

}

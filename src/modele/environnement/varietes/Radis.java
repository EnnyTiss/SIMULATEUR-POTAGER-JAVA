package modele.environnement.varietes;

public class Radis extends Legume{

    //constructeur pour initialiser le temps de croissance
    public Radis() {
        super();
        this.setTempsCroissance(18);
        this.setEnsoleillementIdeal(12);
        this.setPrecipitationIdeal(4);
        this.setVariete(Varietes.radis);
        this.setResistance(12);

    }

}

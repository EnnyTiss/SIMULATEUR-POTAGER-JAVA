package modele.environnement.varietes;

public class Carotte extends Legume {

    //constructeur pour initialiser le temps de croissance
    public Carotte() {
        super();
        this.setTempsCroissance(10);
        this.setEnsoleillementIdeal(8);
        this.setPrecipitationIdeal(3);
        this.setVariete(Varietes.carotte);
    }
}

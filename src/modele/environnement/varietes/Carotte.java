package modele.environnement.varietes;

public class Carotte extends Legume {

    //constructeur pour initialiser le temps de croissance
    public Carotte() {
        super();
        this.setTempsCroissance(75);
        this.setEnsoleillementIdeal(16);
        this.setPrecipitationIdeal(6);
        this.setVariete(Varietes.carotte);
        this.setResistance(10);

    }
}

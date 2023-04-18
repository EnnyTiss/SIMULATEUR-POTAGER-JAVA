package modele.environnement.varietes;

public class Tomate extends Legume{

    //constructeur pour initialiser le temps de croissance
    public Tomate() {
        super();
        this.setTempsCroissance(10);
        this.setEnsoleillementIdeal(10);
        this.setPrecipitationIdeal(8);
        this.setVariete(Varietes.tomate);
    }
}

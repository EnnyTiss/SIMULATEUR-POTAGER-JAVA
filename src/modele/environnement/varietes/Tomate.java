package modele.environnement.varietes;

public class Tomate extends Legume{

    //constructeur pour initialiser le temps de croissance
    public Tomate() {
        super();
        this.setTempsCroissance(120);
        this.setEnsoleillementIdeal(20);
        this.setPrecipitationIdeal(16);
        this.setVariete(Varietes.tomate);
        this.setResistance(100);
    }
}

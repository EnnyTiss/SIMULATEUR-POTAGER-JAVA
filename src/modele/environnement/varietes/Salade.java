package modele.environnement.varietes;

public class Salade extends Legume {

    //constructeur pour initialiser le temps de croissance
    public Salade() {
        super();
        this.setTempsCroissance(10);
    }

    @Override
    public Varietes getVariete() {
        return Varietes.salade;
    }


    @Override
    protected void croissance() {
        //System.out.println("Une salade pousse !!");

    }
}

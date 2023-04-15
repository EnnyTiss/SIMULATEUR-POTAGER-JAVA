package modele.environnement.varietes;

public class Carotte extends Legume {

    //constructeur pour initialiser le temps de croissance
    public Carotte() {
        super();
        this.setTempsCroissance(10);
    }
    @Override
    public Varietes getVariete() {
        return Varietes.carotte;
    }

    @Override
    protected void croissance() {
        System.out.println("Une salade pousse !!");
    }
}

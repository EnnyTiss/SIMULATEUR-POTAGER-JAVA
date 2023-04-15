package modele.environnement.varietes;

public class Radis extends Legume{

    //constructeur pour initialiser le temps de croissance
    public Radis() {
        super();
        this.setTempsCroissance(10);
    }
    @Override
    public Varietes getVariete() {
        return Varietes.radis;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une radis pousse !!");
    }
}

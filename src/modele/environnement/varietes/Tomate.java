package modele.environnement.varietes;

public class Tomate extends Legume{

    //constructeur pour initialiser le temps de croissance
    public Tomate() {
        super();
        this.setTempsCroissance(10);
    }
    @Override
    public Varietes getVariete() {
        return Varietes.tomate;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une tomate pousse !!");
    }
}

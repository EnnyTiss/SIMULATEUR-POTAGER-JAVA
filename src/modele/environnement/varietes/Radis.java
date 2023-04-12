package modele.environnement.varietes;

public class Radis extends Legume{
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

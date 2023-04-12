package modele.environnement.varietes;

public class Salade extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.salade;
    }

    @Override
    protected void croissance() {
        System.out.println("Une salade pousse !!");
    }
}

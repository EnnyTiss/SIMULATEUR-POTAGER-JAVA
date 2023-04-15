package modele.environnement.varietes;

public abstract class Legume {

    //données membres
    private int temps_croissance;

    public void setTempsCroissance(int temps_croissance) {
        this.temps_croissance = temps_croissance;
    }

    public abstract Varietes getVariete();

   // public abstract Varietes setVariete(String choix); //modifier la variété selon le choix de l'utilisateur
    public void nextStep() {
        croissance();
    }

    protected abstract void croissance(); // définir selon les conditions
}

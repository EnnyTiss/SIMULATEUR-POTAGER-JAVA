package modele.environnement.varietes;

public abstract class Legume {

    //données membres
    private int temps_croissance;

    private int precipitationIdeal;

    private int ensoleillementIdeal;

    private Varietes variete;



    public void setTempsCroissance(int temps_croissance) {
        this.temps_croissance = temps_croissance;
    }

    public int getTempsCroissance() {
        return temps_croissance;
    }

    public int getPrecipitationIdeal() {
        return precipitationIdeal;
    }

    public void setPrecipitationIdeal(int precipitationIdeal) {
        this.precipitationIdeal = precipitationIdeal;
    }

    public int getEnsoleillementIdeal() {
        return ensoleillementIdeal;
    }

    public void setEnsoleillementIdeal(int ensoleillementIdeal) {
        this.ensoleillementIdeal = ensoleillementIdeal;
    }




    public void setVariete(Varietes variete) {
        this.variete = variete;
    }
    public Varietes getVariete() {
        return variete;
    }



   // public abstract Varietes setVariete(String choix); //modifier la variété selon le choix de l'utilisateur
    public void nextStep() {
        croissance();
    }

    protected void croissance(){
        System.out.println("Une " + getVariete() + " pousse !!");
    } // définir selon les conditions
}

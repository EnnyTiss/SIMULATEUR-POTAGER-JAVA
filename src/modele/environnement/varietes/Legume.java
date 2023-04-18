package modele.environnement.varietes;

public abstract class Legume {

    //données membres
    private int temps_croissance;

    private int tempsRestant;

    private int precipitationIdeal;

    private int ensoleillementIdeal;
    private int resistance;

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

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }




    public void setVariete(Varietes variete) {
        this.variete = variete;
    }
    public Varietes getVariete() {
        return variete;
    }



   // public abstract Varietes setVariete(String choix); //modifier la variété selon le choix de l'utilisateur
    public void nextStep(int precipitation, int ensoleillement) {
        croissance(precipitation, ensoleillement);
    }

    protected void croissance(int precipitation, int ensoleillement){
        if ( Math.abs(precipitation - precipitationIdeal) < resistance && Math.abs(ensoleillement - ensoleillementIdeal) < resistance && tempsRestant > 0) {
            tempsRestant=-1;
        }
        if (tempsRestant <= 0) {
             tempsRestant = this.temps_croissance;
             System.out.println("Le " + variete + " est prêt à être récolté");

        }


    } // définir selon les conditions
}

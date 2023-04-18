package modele.environnement.varietes;

public abstract class Legume {

    //données membres
    private int temps_croissanceMax;
    private int croissance;

    private int precipitationIdeal;

    private int ensoleillementIdeal;
    private int resistance;

    private boolean mure = false;

    private Varietes variete;







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


    public boolean getMure() {
        return mure;
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

    public int getCroissance() {
        return croissance;
    }

    public void setCroissance(int croissance) {
        this.croissance = croissance;
    }

    public int getTemps_croissanceMax() {
        return temps_croissanceMax;
    }

    public void setTemps_croissanceMax(int temps_croissanceMax) {
        this.temps_croissanceMax = temps_croissanceMax;
    }





   // public abstract Varietes setVariete(String choix); //modifier la variété selon le choix de l'utilisateur
    public void nextStep(int precipitation, int ensoleillement) {
        croissance(precipitation, ensoleillement);
    }

    protected void croissance(int precipitation, int ensoleillement){
        if ( Math.abs(precipitation - precipitationIdeal) < resistance && Math.abs(ensoleillement - ensoleillementIdeal) < resistance && croissance < temps_croissanceMax) {
            croissance++;
            System.out.println("Votre " + variete + " a encore " + (temps_croissanceMax-croissance) + " jours à attendre");
        }
        if (croissance >= temps_croissanceMax) {
            if (!mure){
                if (variete == Varietes.radis) {
                    System.out.println("Un " + variete + " est prête à être récoltée");
                }
                else
                    System.out.println("Une " + variete + " est prêt à être récolté");
                mure = true;
            }
        }


    } // définir selon les conditions

    public void recolte(){
        if (mure){
            System.out.println("Vous avez récolté une " + variete);
            mure = false;
            croissance = 0;
        }
        else
            System.out.println("Votre " + variete + " n'est pas encore mûre");
    }
}

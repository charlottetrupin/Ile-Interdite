package Model;

/**
 * Represente une case de la grille
 * Une Case a une position (x,y) sur la grille
 */
public class Case {

    /// ATTRIBUTS ///
    private int x;
    private int y;
    private Etat etat;
    private ZoneSpe zoneSpe;


    /// CONSTRUCTEURS ///

    /**
     * Constructeur d'une case avec ZoneSpe normal et Etat normale
     * @param x l'abscisse de la case
     * @param y l'ordonnée de la case
     */
    public Case(int x, int y){
        this.x = x ;
        this.y = y ;
        this.etat = Etat.normale;
        this.zoneSpe = ZoneSpe.normal;
    }


    /// METHODES ///


    /**
     * Renvoie la coordonnee x de la case de la grille
     * @return l'abscisse de la case
     */
    public int getX(){
        return this.x;
    }

    /**
     * Renvoie la coordonnee y de la case de la grille
     * @return l'ordonnée de la case
     */
    public int getY(){
        return this.y;
    }

    /**
     * Renvoie l'etat d'une case
     * @return  un état
     */
    public Etat getEtat(){
        return this.etat;
    }

    /**
     * Renvoir la ZoneSpe de la case
     * @return une ZoneSpe
     */
    public ZoneSpe getZoneSpe() {
        return this.zoneSpe;
    }


    /**
     * Change l'attribut zoneSpe de la case avec le paramètre donné
     * @param zoneSpe la nouvelle ZoneSpe de la case
     */
    public void setZoneSpe(ZoneSpe zoneSpe) {
        this.zoneSpe = zoneSpe;
    }

    /**
     * Asseche une case : Si une case est dans l'état inondée, elle redevient etat normale
     */
    public void assecheCase(){
        if (this.etat == Etat.inondee){
            this.etat = Etat.normale;
        }
    }

    /**
     * Inonde la case. Si elle est déjà inondée, elle est submergée.
     */
    public void inonde(){
        switch (this.etat){
            case normale:
                this.etat = Etat.inondee ;
                break;
            case inondee:
                this.etat = Etat.submergee;
                break;
        }
    }

    /**
     * Renvoie un string qui nous donne, les paramètres x et y de la case et son Etat.
     * @return (x,y)-etat-zoneSpe
     */
    public String toString(){
            return String.format("(%d, %d) - Etat Case: %s - Zone Spe : %s", x, y, this.etat,this.zoneSpe);
    }

}

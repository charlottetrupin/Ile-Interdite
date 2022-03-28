package Model;

import java.awt.*;

/**
 * Represente un joueur
 */
public class Joueur {

    // ATTRIBUTS //
    private Ile modele;
    private Case posJ;
    private int numJoueur;
    private Color couleur;
    private int[] clefpossedees;
    private boolean[] artefactpossedes;
    private Role role;


    // CONSTRUCTEUR //

    /**
     * Initialise un joueur sur une ile avec les clefs et les artefacts qu'il possède (aucuns au début)
     * @param modele l'ile où il sera initialisé
     * @param num le numéro du joueur
     * @param couleur la couleur du joueur
     * @param role le rôle du joueur
     */
    public Joueur(Ile modele, int num, Color couleur,Role role){
        this.modele = modele;
        this.posJ = modele.getCases(this.modele.getHeliport().getX(), this.modele.getHeliport().getY());
        this.numJoueur = num;
        this.couleur = couleur;
        this.role = role;
        this.artefactpossedes = new boolean[4];
        this.clefpossedees = new int[4];
        initialiseClef();
        initialiseArtefact();
    }

    /**
     * Renvoie le role du joueur
     * @return l'attribut role
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * Renvoie la clef d'indice i
     * @param i l'indice de la clef que l'on veut renvoyer
     * @return une clef
     */
    public int getClefpossedees(int i) {
        return this.clefpossedees[i];
    }

    /**
     * Renvoie un booléan sur si on a l'artefact d'indice i ou non
     * @param i l'indice de l'artefact que l'on veut renvoyer
     * @return true si on a l'artefact d'indice i, false sinon
     */
    public boolean getArtefactpossedees(int i ){
        return this.artefactpossedes[i];
    }

    /**
     * Renvoie la case du joueur
     * @return renvoie les coordonnées (x,y) du joueur
     */
    public Case getCoordonnees() {
        return this.posJ;
    }

    /**
     * Renvoie le numero du Joueur
     * @return l'attribut numJoueur
     */
    public int getNumJoueur() {
        return this.numJoueur;
    }

    /**
     * Renvoie la couleur du joueur
     * @return l'attribut couleur
     */
    public Color getCouleur() {
        return this.couleur;
    }

    /**
     * Change la position du joueur avec la case donnée en paramètre
     * @param c la case qui va être la nouvelle position du joueur
     */
    public void setCoordonnees(Case c){
        this.posJ = c;
    }


    /**
     * Modifie le nombre de clef posséder par le joueur
     * @param clef le type de clef dont on va modifer le nombre
     * @param i le nombre de clef possedé qu'on va ajouter ou retirer
     */
    public void setClefpossedees(Clef clef,int i){
        if (clef == Clef.clefEau){
            this.clefpossedees[0]+=i;
        }
        if (clef == Clef.clefTerre){
            this.clefpossedees[1]+=i;
        }
        if (clef == Clef.clefFeu){
            this.clefpossedees[2]+=i;
        }
        if (clef == Clef.clefAir){
            this.clefpossedees[3]+=i;
        }
    }

    /**
     * Initialise le tableau de int des clefs possédées pour chaque type de clef (tout est à 0)
     */
    public void initialiseClef(){
        for (int i = 0; i < 4; i ++){
            this.clefpossedees[i] = 0;
        }
    }

    /**
     * Initialise le tableau de boolean des artefacts possédés pour chaque type d'artefact (tout est à false)
     */
    public void initialiseArtefact(){
        for (int i = 0; i < 4; i ++){
            this.artefactpossedes[i] = false;
        }
    }

    /**
     * Renvoie une clef au hasard
     * @return une clef
     */
    public Clef auHasard(){
        int a = (int)(Math.random() * 4);
        switch(a) {
            case 1:
                return Clef.clefEau;
            case 2:
                return Clef.clefTerre;
            case 3:
                return Clef.clefFeu;
        }
        return Clef.clefAir;
    }

    /**
     * Rajoute une clef possédée pour une clef renvoyée au hasard en fonction d'un seuil
     */
    public void clefAleatoire(){
        float i = (float) Math.random() ;
        if (i < 0.4){
            setClefpossedees(auHasard(),1);
        }
    }

    /**
     * Renvoie le nombre de clef possédées en fonction de l'indice i (dans le tableau de clefpossedees) qui correspond à un type de clef
     * @param i l'indice pour avoir le type de clef
     * @return le nombre de clef possédées
     */
    public int possedeClef(int i){
        return this.clefpossedees[i];
    }

    /**
     * Renvoie un boolean sur si un joueur possède des clefs du même type que la clef donnée en paramètre
     * @param c la clef dont on veut savoir si le joueur en possède
     * @return true si le joueur possède des clefs du même type que c, false sinon
     */
    public boolean joueurPossedeClef(Clef c){
        if(c == Clef.clefEau && clefpossedees[0] >= 1){
            return true;
        }else if(c == Clef.clefTerre && clefpossedees[1] >= 1){
            return true;
        }else if(c == Clef.clefFeu && clefpossedees[2] >= 1){
            return true;
        }else return c == Clef.clefAir && clefpossedees[3] >= 1;
    }

    /**
     * Renvoie un boolean sur si dans un tableau de cases, au moins une n'est pas dans un etat submergé ou non
     * @param adj un tableau de case (le plus souvent ça sera les cases adjacentes à un joueur)
     * @return true si une case n'est pas dans un etat submergee, false sinon
     */
    public boolean estDispo(Case[] adj){
        for (Case aCase : adj) {
            if (aCase.getEtat() != Etat.submergee) {
                return true;
            }
        }
        return false;
    }

    /**
     * Renvoie un boolean sur si le joueur a réussi à récuperer un artefact ou non
     * @return true si le joueur a recupéré l'artefact, false sinon
     */
    public boolean recupArtefact(){
        if(this.posJ.getZoneSpe() == ZoneSpe.eau && (clefpossedees[0] >= 4) && this.modele.artefactPasPossede(0)){
            this.clefpossedees[0]= this.clefpossedees[0]-4;
            this.artefactpossedes[0] = true;
            return true;
        }
        if(this.posJ.getZoneSpe() == ZoneSpe.terre && (clefpossedees[1] >= 4) && this.modele.artefactPasPossede(1)){
            this.clefpossedees[1]= this.clefpossedees[1]-4;
            this.artefactpossedes[1] = true;
            return true;
        }
        if(this.posJ.getZoneSpe() == ZoneSpe.feu && (clefpossedees[2] >= 4) && this.modele.artefactPasPossede(2)){
            this.clefpossedees[2]= this.clefpossedees[2]-4;
            this.artefactpossedes[2] = true;
            return true;
        }
        if(this.posJ.getZoneSpe() == ZoneSpe.air && (clefpossedees[3] >= 4) && this.modele.artefactPasPossede(3)){
            this.clefpossedees[3]= this.clefpossedees[3]-4;
            this.artefactpossedes[3] = true;
            return true;
        }
        return false;
    }

    /**
     * Renvoie un chiffre sur si le joueur possède un artefact ayant pour indice i dans le tableau des artefacts possédés ou non
     * @param i l'indice de l'artefact par rapport au tableau
     * @return 1 si le joueur possède l'artefact, 0 sinon
     */
    public int artefact(int i){
        if(getArtefactpossedees(i)){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * Renvoie un boolean sur si le joueur se noie ou pas
     * Le joueur se noie si il est sur une case submergee et si toutes des cases adjacentes à lui sont submergées
     * @return true si le joueur se noit, false sinon
     */
    public boolean seNoie(){
        if(this.role == Role.Explorateur) {
            return this.posJ.getEtat() == Etat.submergee && !estDispo(this.modele.caseAdjacenteExplorateur(this.posJ));
        }
        if(this.role == Role.Plongeur) {
            return false;
        }
        if(this.role == Role.Pilote) {
            return this.modele.toutEstSubmergee();
        }
        return this.posJ.getEtat() == Etat.submergee && !estDispo(this.modele.caseAdjacente(this.posJ));
    }

    public String toString() {
        return String.format(this.posJ.toString() + "\nJoueur: %d - Role: %s", this.numJoueur, this.role);
    }

}
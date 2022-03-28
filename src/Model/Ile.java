package Model;

import Observer.Observable;
import java.awt.*;

/**
 * Represente l'Ile comme une grille
 */
public class Ile extends Observable {

    /// ATTRIBUTS ///
    private int largeur;
    private int hauteur;
    private Case[][] cases;
    private Case heliport;
    private Joueur[] joueurs;
    private int nbAction;
    private int tourJoueur;
    private Case[] zoneArtefact;
    private String message;


    /// CONSTRUCTEUR ///

    /**
     * Initialise la grille de l'Ile avec la case heliport, les joueurs et les zones speciales
     * @param largeur l'axe des abscisses
     * @param hauteur l'axe des ordonnées
     */
    public Ile(int largeur, int hauteur) {

        // Creation de la grille :
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.cases = new Case[this.largeur][this.hauteur];
        for (int i = 0; i < this.largeur; i++) {
            for (int j = 0; j < this.hauteur; j++) {
                    this.cases[i][j] = new Case(i,j);
            }
        }

        // Creation des Zones Speciales :
        this.heliport = this.renvoieCase(ZoneSpe.heliport);
        this.zoneArtefact = new Case[4];
        this.zoneArtefact[0] = renvoieCase(ZoneSpe.eau) ;
        this.zoneArtefact[1] = renvoieCase(ZoneSpe.terre);
        this.zoneArtefact[2] = renvoieCase(ZoneSpe.feu);
        this.zoneArtefact[3] = renvoieCase(ZoneSpe.air);

        // Creation des Joueurs :
        this.joueurs = new Joueur[4];
        joueurs[0] = new Joueur(this, 1, Color.red,Role.Explorateur);
        joueurs[1] = new Joueur(this,2,new Color(0, 127, 1),Role.Plongeur);
        joueurs[2] = new Joueur(this,3,new Color(0,40,255),Role.Pilote);
        joueurs[3] = new Joueur(this,4,new Color(240, 197, 11),Role.Messager);


        this.nbAction = 3;
        this.tourJoueur = 0;
        this.message ="";

    }


    /// METHODES ///

    /**
     * Renvoie le double tableau des cases de la grille
     * @return le double tableau cases
     */
    public Case[][] getCases() {
        return this.cases;
    }

    /**
     * Renvoie un string
     * @return l'attribut message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Renvoie la case avec la zone speciale Heliport
     * @return la case heliport
     */
    public Case getHeliport(){
        return this.heliport;
    }

    /**
     * Renvoie le tableau des cases qui sont des zones speciales Artefact
     * @return le tableau ZoneArtefact
     */
    public Case[] getZoneArtefact () {
        return this.zoneArtefact;
    }

    /**
     * Renvoie un int correspondant au tour du Joueur qui doit jouer
     * @return le tour du Joueur
     */
    public int getTourJoueur() {
        return this.tourJoueur;
    }

    /**
     * Renvoie un int correspondant aux nombres d'actions restantes
     * @return le nombre d'action restantes
     */
    public int getNbAction(){
        return this.nbAction;
    }

    /**
     * Renvoie le joueur ayant l'indide donné en paramètre
     * @param i un int compris entre 0 (inclus) et 4 (non inclus)
     * @return le joueur avec l'indice i
     */
    public Joueur getJoueur(int i) {
        return this.joueurs[i];
    }


    /**
     * Renvoie la largeur de la grille
     * @return la largeur
     */
    public int getLargeur(){
        return this.largeur;
    }

    /**
     * Renvoie la hauteur de la grille
     * @return la hauteur
     */
    public int getHauteur(){
        return  this.hauteur;
    }

    /**
     * Renvoie une case la grille ayant les coordonnées données en paramètre
     * @param x l'abscisse de la case
     * @param y l'ordonnée de la case
     * @return la case ayant les coordonnées (x,y)
     */
    public Case getCases(int x, int y) {
        return this.cases[x][y];
    }

    /**
     * Modifie l'attribut message avec le string donné en paramètre
     * @param message le nouveau contenu de l'attribut message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Change le tour du Joueur qui doit jouer
     * @param i le nouveau tour du joueur qui doit jouer
     */
    public void setTourJoueur(int i){
        this.tourJoueur = i;
    }

    /**
     * Créé un tableau de case avec les cases adjacentes d'une case donnée en paramètre (haut,bas,droite,gauche)
     * @param c une case dont on cherche les cases adjacentes
     * @return le tableau de cases adjacentes à c
     */
    public Case[] caseAdjacente(Case c) {
        if(c.getY() == 0 && c.getX() == 0 ){
            Case[] adj = new Case[2];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            return adj;
        }
        else if(c.getX() == 0 && c.getY() == this.hauteur - 1){
            Case[] adj = new Case[2];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() - 1];
            return adj;
        }
        else if(c.getX() == this.largeur -1 && c.getY() == 0 ) {
            Case[] adj = new Case[2];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            return adj;
        }
        else if(c.getX() == this.largeur -1 && c.getY() == this.hauteur -1){
            Case[] adj = new Case[2];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() - 1];
            return adj;
        }
        else if(c.getX() == 0){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            adj[2] = this.cases[c.getX()][c.getY() - 1];
            return adj;
        }
        else if(c.getX() == this.largeur -1){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            adj[2] = this.cases[c.getX()][c.getY() - 1];
            return adj;
        }
        else if(c.getY() == 0){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX() + 1][c.getY()];
            adj[2] = this.cases[c.getX()][c.getY() + 1];
            return adj;
        }
        else if(c.getY() == this.hauteur -1){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX() + 1][c.getY()];
            adj[2] = this.cases[c.getX()][c.getY() - 1];
            return adj;
        }
        else {
            Case[] adj = new Case[4];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX() - 1][c.getY()];
            adj[2] = this.cases[c.getX()][c.getY() + 1];
            adj[3] = this.cases[c.getX()][c.getY() - 1];
            return adj;
        }
    }

    /**
     * Créé un tableau de case avec les cases adjacentes d'une case donnée en paramètre (haut,bas,droite,gauche et les diagonales)
     * @param c c une case dont on cherche les cases adjacentes
     * @return le tableau de cases adjacentes à c
     */
    public Case[] caseAdjacenteExplorateur(Case c){
        if(c.getY() == 0 && c.getX() == 0 ){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            adj[2] = this.cases[c.getX()+1][c.getY() + 1];
            return adj;
        }
        else if(c.getX() == 0 && c.getY() == this.hauteur - 1){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() - 1];
            adj[1] = this.cases[c.getX()+1][c.getY() - 1];
            return adj;
        }
        else if(c.getX() == this.largeur -1 && c.getY() == 0 ) {
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            adj[1] = this.cases[c.getX()-1][c.getY() + 1];
            return adj;
        }
        else if(c.getX() == this.largeur -1 && c.getY() == this.hauteur -1){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() - 1];
            adj[1] = this.cases[c.getX()-1][c.getY() - 1];
            return adj;
        }
        else if(c.getX() == 0){
            Case[] adj = new Case[5];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            adj[2] = this.cases[c.getX()][c.getY() - 1];
            adj[3] = this.cases[c.getX()+1][c.getY() + 1];
            adj[4] = this.cases[c.getX()+1][c.getY() - 1];
            return adj;
        }
        else if(c.getX() == this.largeur -1){
            Case[] adj = new Case[5];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX()][c.getY() + 1];
            adj[2] = this.cases[c.getX()][c.getY() - 1];
            adj[3] = this.cases[c.getX()-1][c.getY() + 1];
            adj[4] = this.cases[c.getX()-1][c.getY() - 1];
            return adj;
        }
        else if(c.getY() == 0){
            Case[] adj = new Case[5];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX() + 1][c.getY()];
            adj[2] = this.cases[c.getX()][c.getY() + 1];
            adj[3] = this.cases[c.getX() - 1][c.getY()+1];
            adj[4] = this.cases[c.getX() + 1][c.getY()+1];
            return adj;
        }
        else if(c.getY() == this.hauteur -1){
            Case[] adj = new Case[3];
            adj[0] = this.cases[c.getX() - 1][c.getY()];
            adj[1] = this.cases[c.getX() + 1][c.getY()];
            adj[2] = this.cases[c.getX()][c.getY() - 1];
            adj[0] = this.cases[c.getX() - 1][c.getY()-1];
            adj[1] = this.cases[c.getX() + 1][c.getY()-1];
            return adj;
        }
        else {
            Case[] adj = new Case[8];
            adj[0] = this.cases[c.getX() + 1][c.getY()];
            adj[1] = this.cases[c.getX() - 1][c.getY()];
            adj[2] = this.cases[c.getX()][c.getY() + 1];
            adj[3] = this.cases[c.getX()][c.getY() - 1];
            adj[4] = this.cases[c.getX() + 1][c.getY()-1];
            adj[5] = this.cases[c.getX() - 1][c.getY()-1];
            adj[6] = this.cases[c.getX()+1][c.getY() + 1];
            adj[7] = this.cases[c.getX()-1][c.getY() + 1];
            return adj;
        }
    }

    /**
     * Renvoie un boolean sur si une case donnée appartient au tableau de case donné en paramètre ou pas
     * @param c  une case
     * @param adj un tableau de cases
     * @return true si c appartient à adj, false sinon
     */
    public boolean caseBien(Case c, Case[] adj) {
        for (Case aCase : adj) {
            if (caseEgale(aCase,c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Renvoie un boolean sur si deux cases données en paramètres ont les mêmes coordonnées ou non
     * @param c1 une case
     * @param c2 une case
     * @return true si les cases sont égales, false sinon
     */
    public boolean caseEgale(Case c1, Case c2){
        return c1.getX() == c2.getX() && c1.getY() == c2.getY();
    }

    /**
     * Renvoie la case avec les coordonnées a et b
     * @return la case ayant les coordonnées a et b
     */
    public Case renvoieCase() {
        int a = (int) (Math.random() * (this.largeur));
        int b = (int) (Math.random() * (this.hauteur));
        return this.cases[a][b];
    }

    /**
     * Renvoie une case au hasard de la grille avec les coordonnées a et b et une zone speciale donnée en paramètre
     * @param zoneSpe une zoneSpe
     * @return la case avec les coordonnées a et b ayant une nouvelle zone speciale donnée en paramètre
     */
    public Case renvoieCase(ZoneSpe zoneSpe) {
        int a = (int) (Math.random() * (this.largeur));
        int b = (int) (Math.random() * (this.hauteur));
        while(this.cases[a][b].getZoneSpe() != ZoneSpe.normal){
            a = (int) (Math.random() * (this.largeur));
            b = (int) (Math.random() * (this.hauteur));
        }
        this.cases[a][b].setZoneSpe(zoneSpe);
        return this.cases[a][b];
    }

    /**
     * Si le joueur a encore des actions, asseche une case si elle est soit adjacente au joueur soit égale à la position du joueur
     * @param c la case qu'on veut assécher
     * @param i le tour du joueur qui pourra assécher une case
     */
    public void assecheZone(Case c,int i){
        if(this.nbAction > 0){
            if(c.getEtat() == Etat.inondee) {
                if (this.joueurs[i].getRole() == Role.Explorateur) {
                    if (caseBien(c, caseAdjacenteExplorateur(this.joueurs[i].getCoordonnees())) || caseEgale(c, this.joueurs[i].getCoordonnees())) {
                        c.assecheCase();
                        this.nbAction -= 1;
                    }
                }
                else if (caseBien(c, caseAdjacente(this.joueurs[i].getCoordonnees())) || caseEgale(c, this.joueurs[i].getCoordonnees())) {
                    c.assecheCase();

                    this.nbAction -= 1;
                }
            }
            else {
                this.message = "Erreur: vous ne pouvez pas assecher cette zone";
            }
        }
    }

    /**
     * Le joueur dont c'est le tour peut assécher une case
     * @param c la case à assécher
     */
    public void assecherZone(Case c){
        assecheZone(c, this.tourJoueur);
    }

    /**
     * Deplace le joueur dont c'est le tour sur la case c en paramètre si il a encore des actions et que toutes les conditions sont respectées :
     * case non submergee, adjacente au joueur, dans la grille
     * Sinon on modifie l'attribut message pour signaler une erreur
     * @param c la case où le joueur veut se déplacer
     * @param i l'indice du joueur dont c'est le tour
     */
    public void deplaceJoueur(Case c , int i) {
        if(!this.partieGagne() && !this.partiePerdue()) {
            if (this.nbAction > 0) {
                if (c.getX() < this.largeur && c.getX() >= 0 && c.getY() < this.hauteur && c.getY() >= 0) {
                    if(c.getEtat() != Etat.submergee && this.joueurs[i].getRole() == Role.Pilote){
                        this.joueurs[i].setCoordonnees(c);
                        this.nbAction -= 1;
                    }
                    if(c.getEtat() != Etat.submergee && this.joueurs[i].getRole() == Role.Explorateur) {
                        if (caseBien(c, caseAdjacenteExplorateur(this.joueurs[i].getCoordonnees()))) {
                            this.joueurs[i].setCoordonnees(c);
                            this.nbAction -= 1;
                        }
                    }

                    if(c.getEtat() != Etat.submergee || this.joueurs[i].getRole() == Role.Plongeur) {
                        if (caseBien(c, caseAdjacente(this.joueurs[i].getCoordonnees()))) {
                            this.joueurs[i].setCoordonnees(c);
                            this.nbAction -= 1;
                        }
                    }
                }
                 else {
                    this.message = "Erreur: vous ne pouvez pas allez sur cette case";
                }
            }
        }
    }

    /**
     * Deplace le joueur dont c'est le tour sur la case c
     * @param c la case où le joueur veut se déplacer
     */
    public void deplaceJoueurs(Case c){
        deplaceJoueur(c, this.tourJoueur);
    }

    /**
     * Le joueur recupère un artefact si il a encore des actions
     */
    public void recupArtefact(){
        if(this.nbAction > 0) {
            if(this.joueurs[this.tourJoueur].recupArtefact()) {
                this.nbAction -= 1;
            }
        }
    }

    /**
     * Echange une clef entre le joueur dont c'est le tour et un joueur qui se situe sur la même case que lui
     * @param f la clé qu'on veut échanger
     * @param i l'indice du joueur
     */
    public void echangeClef(Clef f,int i){
        if(this.nbAction > 0) {
            if ((this.joueurs[this.tourJoueur].getCoordonnees() == joueurs[i].getCoordonnees()) || this.joueurs[this.tourJoueur].getRole() == Role.Messager){
                if(this.joueurs[this.tourJoueur].joueurPossedeClef(f)) {
                    joueurs[i].setClefpossedees(f, 1);
                    this.joueurs[this.tourJoueur].setClefpossedees(f, -1);
                    this.nbAction -= 1;
                }else {
                    this.message = "Erreur: vous ne possedez pas de la clef que vous voulez donner";
                }
            }else {
                this.message = "Erreur: le joueur a qui vous voulez donner n'est pas sur la même zone que vous";
            }
        }
    }


    /**
     * A la fin du tour d'un joueur il peut recevoir une clef ou avoir sa case inondée ou rien
     */
    public void chercheClef(){
        float i = (float) Math.random() ;
        if (i < 0.2){
            this.joueurs[tourJoueur].clefAleatoire();
        }
        else if(i < 0.5){
            this.joueurs[tourJoueur].getCoordonnees().inonde();
        }
    }

    /**
     * Inonde trois cases au hasard si elles ne sont pas déjà submergee
     */
    public void inondeCase() {
        int i = 0 ;
        while (i < 3){
            Case c = renvoieCase();
            if ( c.getEtat() != Etat.submergee ) {
                c.inonde();
                i++;
            }
        }
    }

    /**
     * Le joueur dont c'est le tour récupère potentiellement une clef
     */
    public void recupClef(){
        this.getJoueur(this.tourJoueur).clefAleatoire();
    }

    /**
     * Renvoie un boolean sur si tous les joueurs sont sur la case Héliport ou non
     * @return true si les joueurs sont tous sur la case Heliport, false sinon
     */
    public boolean tousHeliport(){
        return caseEgale(this.joueurs[0].getCoordonnees(), this.heliport) && (caseEgale(this.joueurs[1].getCoordonnees(), this.heliport)
                && (caseEgale(this.joueurs[2].getCoordonnees(), this.heliport) && caseEgale(this.joueurs[3].getCoordonnees(), this.heliport)));
    }


    /**
     * Renvoie un booleean sur si toutes les cases sont submergées ou pas
     * @return true si toutes les cases ne sont pas submergées, false sinon
     */
    public boolean toutEstSubmergee(){
        for (Case[] aCase : cases) {
            for (int j = 0; j < cases[0].length; j++) {
                if (aCase[j].getEtat() == Etat.inondee || aCase[j].getEtat() == Etat.normale) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Renvoie un boolean sur si un artefact  d'indice donné en paramètre est possédé par un joueur ou non
     * @param indiceArtefact l'indice de l'artefact
     * @return false si un joueur possède l'artefact, true sinon
     */
    public boolean artefactPasPossede(int indiceArtefact){
        for (Joueur joueur : this.joueurs) {
            if (joueur.getArtefactpossedees(indiceArtefact)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Renvoie un boolean sur si la partie est gagnée ou non
     * Une partie est gagné si tous les artefacts ont été récupéré et si tous les joueurs sont sur la case Heliport
     * @return true si la partie est gagnée, false sinon
     */
    public boolean partieGagne(){
        boolean[] artefact = new boolean[4];
        for(int i = 0; i < 4; i++){
            if(this.joueurs[0].getArtefactpossedees(i) || this.joueurs[1].getArtefactpossedees(i)
                    || this.joueurs[2].getArtefactpossedees(i) || this.joueurs[3].getArtefactpossedees(i)){
                artefact[i] = true;
            }
        }
        return artefact[0] && artefact[1] && artefact[2] && artefact[3] && tousHeliport();
    }

    /**
     * Renvoie un boolean sur si la partie est perdue ou non
     * Une partie est perdue si la case Heliport est submergée ou si un des joueurs s'est noyé
     * @return true si la partie est perdue, false sinon
     */
    public boolean partiePerdue(){
        if(this.heliport.getEtat() == Etat.submergee){
            return true;
        }
        for(int i = 0; i < 4; i ++){
            if(joueurs[i].seNoie()){
                return true;
            }
        }
        return false;
    }

    /**
     * Fait avancer le jeu en appellant certaines méthodes de la classe et en changeant les attributs nbAction et tourJoueur
     * Previent la classe Observable
     */
    public void avance(){
        this.chercheClef();
        this.recupClef();
        this.inondeCase();
        this.nbAction = 3;
        this.tourJoueur = (this.tourJoueur + 1) % this.joueurs.length;
        previentObservable();
    }
}

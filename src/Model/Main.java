package Model;

import Vue.Vue;

public class Main {
    public static final int HAUTEUR = 15, LARGEUR = 25;

    public static void main(String[] args){
        Ile modele = new Ile(LARGEUR,HAUTEUR);   //Construction de l'Ile
        new Vue(modele);                         //Tout ce qui est affichage
    }
}

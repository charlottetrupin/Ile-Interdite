package Test;

import Model.Case;
import Model.Etat;
import Model.Ile;
import org.junit.jupiter.api.Assertions;


public class IleTest {
    Ile modele = new Ile(3,3); // il est necessaire

    @org.junit.jupiter.api.Test
    void testInondee(){ //ici on verifie qu'on innonde bien 3 cases en meme temps
        Case[][] cases = modele.getCases();
        int a = 0;
        int cpt;
        while (!modele.toutEstSubmergee()) {
            modele.inondeCase();
            a= a+3;
            cpt = 0;
            System.out.println("a = " + a);
            for (int i = 0; i < cases.length; i++) {
                for (int j = 0; j < cases[0].length; j++) {
                    if (modele.getCases(i, j).getEtat() == Etat.inondee ){
                        cpt++;
                        //System.out.println("cpt dans inondee= " + cpt);
                    }else if( modele.getCases(i,j).getEtat() == Etat.submergee){
                        cpt= cpt+2;
                        //System.out.println("cpt dans submergeé= " + cpt);
                    }
                }
            }
            Assertions.assertEquals(a , cpt);
        }
    }

    @org.junit.jupiter.api.Test
    void testAsseche(){
        Case[][] cases = modele.getCases();
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[0].length; j++) {
                cases[i][j].inonde();
                cases[i][j].assecheCase();
                Assertions.assertEquals(Etat.normale, cases[i][j].getEtat());
            }
        }
        while (!modele.toutEstSubmergee()) {
            modele.inondeCase();
        }
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[0].length; j++) {
                cases[i][j].assecheCase();
                Assertions.assertEquals(Etat.submergee , cases[i][j].getEtat());
            }
        }

    }

    @org.junit.jupiter.api.Test
    void testInitHeiport(){ //test que les joueurs sont bien initialisé sur la case heliport
        Assertions.assertEquals(modele.getHeliport(), modele.getJoueur(0).getCoordonnees());
        Assertions.assertEquals(modele.getHeliport(), modele.getJoueur(1).getCoordonnees());
        Assertions.assertEquals(modele.getHeliport(), modele.getJoueur(2).getCoordonnees());
        Assertions.assertEquals(modele.getHeliport(), modele.getJoueur(3).getCoordonnees());
    }

    @org.junit.jupiter.api.Test
    void testdeplaceJoueur(){ //si on deplace le joueur sur une case on verifie qu'il ce position bien sur celle-si
        if(modele.getJoueur(0).getCoordonnees().getX() < 2) {
            modele.setTourJoueur(0);
            modele.deplaceJoueurs(modele.getCases(modele.getJoueur(0).getCoordonnees().getX() + 1,modele.getJoueur(0).getCoordonnees().getY()));
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX() + 1, modele.getHeliport().getY()), modele.getJoueur(0).getCoordonnees());
        } else {
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX() , modele.getHeliport().getY()), modele.getJoueur(0).getCoordonnees());
        }

        if( modele.getJoueur(1).getCoordonnees().getY() < 2){
            modele.setTourJoueur(1);
            modele.deplaceJoueurs(modele.getCases(modele.getJoueur(1).getCoordonnees().getX() ,modele.getJoueur(1).getCoordonnees().getY() + 1));
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX(), modele.getHeliport().getY() + 1), modele.getJoueur(1).getCoordonnees());
        }else {
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX() , modele.getHeliport().getY()), modele.getJoueur(1).getCoordonnees());
        }

        if( modele.getJoueur(2).getCoordonnees().getY() > 1){
            modele.setTourJoueur(2);
            modele.deplaceJoueurs(modele.getCases(modele.getJoueur(2).getCoordonnees().getX() ,modele.getJoueur(2).getCoordonnees().getY() - 1));
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX(), modele.getHeliport().getY() - 1), modele.getJoueur(2).getCoordonnees());
        }else {
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX() , modele.getHeliport().getY()), modele.getJoueur(2).getCoordonnees());
        }

        if( modele.getJoueur(3).getCoordonnees().getX() > 1){
            modele.setTourJoueur(3);
            modele.deplaceJoueurs(modele.getCases(modele.getJoueur(3).getCoordonnees().getX() - 1 ,modele.getJoueur(3).getCoordonnees().getY()));
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX() - 1, modele.getHeliport().getY()), modele.getJoueur(3).getCoordonnees());
        }else {
            Assertions.assertEquals(modele.getCases(modele.getHeliport().getX() , modele.getHeliport().getY()), modele.getJoueur(3).getCoordonnees());
        }

    }

}

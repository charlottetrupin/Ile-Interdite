package Vue;

import Model.Case;
import Model.Ile;
import Model.Joueur;
import javax.swing.*;
import java.awt.*;

/**
 * Creation des joueurs et de leur représentation sur la grille
 */
public class VueJoueur extends JPanel{
    private Ile modele;
    public Case heliport;
    private int i;


    public VueJoueur(Ile modele, int i) {
        this.i = i;
        this.modele = modele;
        this.heliport = this.modele.getHeliport();
    }

    public void paintComponent(Graphics g) {
        dessinerUnJoueur(g, modele.getJoueur(this.i));
    }

    public void dessinerUnJoueur(Graphics g, Joueur j) {
        g.setColor(j.getCouleur());
        switch (j.getNumJoueur()){
            case 1:
                if(!j.seNoie()){
                    g.fillOval(2 + (j.getCoordonnees().getX() * VueGrille.getTaille()), 2 + (j.getCoordonnees().getY() * VueGrille.getTaille()), 12, 12);
                }
                break;
            case 2:
                if(!j.seNoie()) {
                    g.fillOval(18 + (j.getCoordonnees().getX() * VueGrille.getTaille()), 2 + (j.getCoordonnees().getY() * VueGrille.getTaille()), 12, 12);
                }
                break;
            case 3:
                if(!j.seNoie()) {
                    g.fillOval(2 + (j.getCoordonnees().getX() * VueGrille.getTaille()), 18 + (j.getCoordonnees().getY() * VueGrille.getTaille()), 12, 12);
                }
                break;
            case 4:
                if(!j.seNoie()) {
                    g.fillOval(18 + (j.getCoordonnees().getX() * VueGrille.getTaille()), 18 + (j.getCoordonnees().getY() * VueGrille.getTaille()), 12, 12);
                }
                break;

        }
    }
}
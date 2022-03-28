package Controleur;


import Model.Ile;
import Observer.Observer;
import Vue.VueGrille;
import javax.swing.*;
import java.awt.event.*;



public class Souris extends JPanel implements MouseListener, Observer {
    private Ile modele;

    public Souris(Ile modele, VueGrille grille){
        this.modele = modele;
    }

    @Override
    public void update() {
        repaint();
    }

    /**
     * En fonction du clique souris, on avance, assèche ou récupère un artefact
     * @param e le clique souris
     * @throws ArrayIndexOutOfBoundsException si le clique souris est en dehors de la grille on rattrape l'exception et on l'affiche sur notre panneau d'affichage
     */
    public void mouseClicked(MouseEvent e) throws ArrayIndexOutOfBoundsException {
        try {
            int cliqueX = e.getX() / VueGrille.getTaille();
            int cliqueY = (e.getY()-25) / VueGrille.getTaille();

            if (e.getButton() == MouseEvent.BUTTON1) {
                if (modele.caseEgale(modele.getJoueur(modele.getTourJoueur()).getCoordonnees(),modele.getCases(cliqueX, cliqueY))){
                    modele.recupArtefact();
                }
                else {
                    modele.deplaceJoueurs(modele.getCases(cliqueX, cliqueY));
                }
            }

            if (e.getButton() == MouseEvent.BUTTON3) {    //clique droit
                modele.assecherZone(modele.getCases(cliqueX, cliqueY));

            }
            modele.setMessage("");
            super.repaint();
        } catch(ArrayIndexOutOfBoundsException i){
            modele.setMessage("Erreur: Vous ne pouvez pas mettre le pion à l'exterieur de la grille");
        }
    }


    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }


}

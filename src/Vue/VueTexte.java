package Vue;

import Model.Ile;
import Model.Main;
import Observer.Observer;
import javax.swing.*;
import java.awt.*;

/**
 * Creation des textes sur les joueurs et ce qu'ils possèdent
 * On a aussi une phrase qui donne le tour du joueur qui doit joueur
 */
public class VueTexte extends JPanel implements Observer {
    private Ile modele;

    public VueTexte(Ile modele){
        this.modele = modele;
        Dimension dim = new Dimension(300, VueGrille.getTaille() * Main.HAUTEUR);
        this.setPreferredSize(dim);
    }


    @Override
    public void update() {
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        texteTourJoueur(g);

        textArtefactClef(g,modele.getJoueur(0).getCouleur(), 0 , 0);
        textArtefactClef(g,modele.getJoueur(1).getCouleur(), 105 , 1);
        textArtefactClef(g,modele.getJoueur(2).getCouleur(), 210 , 2);
        textArtefactClef(g,modele.getJoueur(3).getCouleur(), 315 , 3);

        super.repaint();
    }


    public void texteTourJoueur(Graphics g){
        g.setColor(this.modele.getJoueur(modele.getTourJoueur()).getCouleur());
        g.drawString(("C'est le tour du joueur " + (this.modele.getTourJoueur()+1) + ", il lui reste " + this.modele.getNbAction() + " actions"), 5, 20 );
    }


    public void textArtefactClef(Graphics g, Color c, int y, int numJoueur){
        g.setColor(c);
        g.drawString("LE JOUEUR " + (numJoueur + 1) + " ( " + modele.getJoueur(numJoueur).getRole() + " )", 90, 70 + y);

        g.drawString("Clefs", 80, 90 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).possedeClef(0), 80, 105 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).possedeClef(1), 80, 120 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).possedeClef(2), 80, 135 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).possedeClef(3), 80, 150 + y);

        g.drawString("Artefacts", 190, 90 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).artefact(0), 190, 105 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).artefact(1), 190, 120 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).artefact(2), 190, 135 + y);
        g.drawString( "" + modele.getJoueur(numJoueur).artefact(3), 190, 150 + y);

        g.setColor(new Color(0, 52, 253, 255));
        g.drawString("eau: " , 5, 105 + y);

        g.setColor(new Color(133, 70, 0, 255));
        g.drawString("terre: ", 5, 120 + y);

        g.setColor(new Color(214, 3, 0, 250));
        g.drawString("feu: ", 5, 135 + y);

        g.setColor(new Color(148, 3, 191, 255));
        g.drawString("air: " , 5 , 150 + y);

    }

}

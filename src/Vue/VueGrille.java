package Vue;

import javax.swing.*;
import java.awt.*;
import Model.*;
import Observer.* ;

/**
 * Creation de la grille, des cases spéciales et des joueurs
 */
public class VueGrille extends JPanel implements Observer {

    private Ile modele;
    private final static int TAILLE = 34; // fenetre d'affichage
    public VueJoueur[] joueurs;

    public static int getTaille() {
        return TAILLE;
    }


    public VueGrille(Ile modele) {
        this.modele = modele;
        Dimension dim = new Dimension(TAILLE* Main.LARGEUR, TAILLE* Main.HAUTEUR);
        this.setPreferredSize(dim);
        this.joueurs = new VueJoueur[4];
        this.joueurs[0] = new VueJoueur(modele,0);
        this.joueurs[1] = new VueJoueur(modele,1);
        this.joueurs[2] = new VueJoueur(modele,2);
        this.joueurs[3] = new VueJoueur(modele,3);
    }

    @Override
    public void update() {
        repaint();
    }


    public void paintComponent(Graphics g) {
       
        paintArtefact(g);
        for(int i = 0; i< modele.getLargeur(); i++) {
            for(int j = 0; j< modele.getHauteur(); j++) {
                paint(g, modele.getCases(i, j), i*TAILLE, j*TAILLE);
                if(i == joueurs[0].heliport.getX()
                        && j == joueurs[0].heliport.getY()) {
                    paintHeliport(g, joueurs[0].heliport);
                }
            }
        }

        this.joueurs[0].paintComponent(g);
        this.joueurs[1].paintComponent(g);
        this.joueurs[2].paintComponent(g);
        this.joueurs[3].paintComponent(g);
        
        super.repaint();
    }

    private void paint(Graphics g, Case c, int x, int y) {
        // Sélection d'une couleur en fonction de l'état d'une case
        if (c.getEtat() == Etat.inondee) {
            g.setColor(new Color(0, 144, 254));
        } else if (c.getEtat() == Etat.submergee) {
            g.setColor(Color.BLACK);
        }else{
            g.setColor(Color.WHITE);
        }
        // Coloration d'un rectangle correspondant à une case
        g.fillRect(x, y, TAILLE-2, TAILLE-2);
    }
    
    // Creation de l'affichage de la zone Heliport
    private void paintHeliport(Graphics g, Case c){
        g.setColor(new Color(255, 159, 29, 75));
        g.fillRect(c.getX() * TAILLE, c.getY() * TAILLE, TAILLE-2, TAILLE-2);
    }

    // Creation de l'affichage des zones d'artefacts 
    public void paintArtefact(Graphics g) {
        //eau
        if (modele.artefactPasPossede(0)) {
            g.setColor(new Color(0, 52, 253, 255));
            g.fillRect((modele.getZoneArtefact()[0].getX() * TAILLE) - 2, (modele.getZoneArtefact()[0].getY() * TAILLE) - 2, TAILLE + 2, TAILLE + 2);
        }
        //terre
        if (modele.artefactPasPossede(1)) {
            g.setColor(new Color(133, 70, 0, 255));
            g.fillRect((modele.getZoneArtefact()[1].getX() * TAILLE) - 2, (modele.getZoneArtefact()[1].getY() * TAILLE) - 2, TAILLE + 2, TAILLE + 2);
        }
        //feu
        if (modele.artefactPasPossede(2)) {
            g.setColor(new Color(191, 3, 0, 255));
            g.fillRect((modele.getZoneArtefact()[2].getX() * TAILLE) - 2, (modele.getZoneArtefact()[2].getY() * TAILLE) - 2, TAILLE + 2, TAILLE + 2);
        }
        //air
        if (modele.artefactPasPossede(3)) {
            g.setColor(new Color(148, 3, 191, 255));
            g.fillRect((modele.getZoneArtefact()[3].getX() * TAILLE) - 2, (modele.getZoneArtefact()[3].getY() * TAILLE) - 2, TAILLE + 2, TAILLE + 2);
        }
    }
}
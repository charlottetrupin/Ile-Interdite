package Vue;

import Controleur.Controleur;
import Model.Ile;
import Model.Main;
import Observer.Observer;
import javax.swing.*;
import java.awt.*;

/**
 * Création du bouton fin de tour et de l'affichage des messages d'erreur ou de fin de partie
 */
public class VueFinDeTour extends JPanel implements Observer {

    private Ile modele;

    public VueFinDeTour(Ile modele) {
        this.modele = modele;

        JButton finDeTour = new JButton("Fin de tour");
        this.add(finDeTour);

        Controleur ctrl = new Controleur(modele);
        finDeTour.addActionListener(ctrl);

        Dimension dim = new Dimension(Main.LARGEUR * VueGrille.getTaille() , 50);
        this.setPreferredSize(dim);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.repaint();
        if(modele.partieGagne()) {
            g.setColor(Color.black);
            g.drawString("Bravo ! Vous avez gagné la partie !!! ", 5, 45);

        }else if (modele.partiePerdue()){
            g.setColor(Color.black);
            g.drawString("Vous avez perdue la partie !!! ", 5, 45);
        }else{
            g.setColor(Color.red);
            String a = modele.getMessage();
            g.drawString(a, 5, 45);
        }
    }

}
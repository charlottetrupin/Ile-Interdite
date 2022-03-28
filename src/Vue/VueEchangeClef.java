package Vue;

import Model.Clef;
import Model.Ile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Creation des boutons permettant l'échange de clefs entre joueurs
 */
public class VueEchangeClef extends JPanel implements ActionListener {

    private Ile modele;
    private JButton clefEau;
    private JButton clefTerre;
    private JButton clefFeu;
    private JButton clefAir;
    private JCheckBox j1;
    private JCheckBox j2;
    private JCheckBox j3;
    private JCheckBox j4;

    public VueEchangeClef(Ile modele){
        this.modele = modele;
        Dimension dim = new Dimension(250 , 130);
        this.setPreferredSize(dim);

        // Initialisation des boutons
        j1=new JCheckBox("joueur 1");
        this.add(j1);

        j2=new JCheckBox("joueur 2");
        this.add(j2);

        j3=new JCheckBox("joueur 3");
        this.add(j3);

        j4=new JCheckBox("joueur 4");
        this.add(j4);

        ButtonGroup bg=new ButtonGroup();
        bg.add(j1);bg.add(j2);bg.add(j3);bg.add(j4);

        this.clefEau = new JButton(("clef Eau"));
        clefEau.addActionListener(this);
        this.add(this.clefEau);

        this.clefTerre = new JButton("clef terre");
        clefTerre.addActionListener(this);
        this.add(this.clefTerre);

        this.clefFeu = new JButton("clef Feu");
        clefFeu.addActionListener(this);
        this.add(this.clefFeu);

        this.clefAir = new JButton("clef Air");
        clefAir.addActionListener(this);
        this.add(this.clefAir);
    }

    /**
     * Appelle la methode echangeClefs en fonction de l'event donné en paramètre
     * @param e l'evenement (les boutons qu'on a choisi)
     */
    public void actionPerformed(ActionEvent e) {
        if (j1.isSelected()) {
            echangeClefs(e, 0);
        }
        if (j2.isSelected()) {
            echangeClefs(e, 1);
        }
        if (j3.isSelected()) {
            echangeClefs(e, 2);
        }
        if (j4.isSelected()) {
            echangeClefs(e, 3);
        }
    }

    /**
     * Appella la méthode echangeClef de Ile en fonction du bouton sur lequel on a cliqué et de l'indice du joueur a qui on veut donnner la clef
     * @param e l'evenement (les boutons qu'on a choisi
     * @param indiceJoueur l'indice du joueur a qui on donne la clef
     */
    public void echangeClefs(ActionEvent e, int indiceJoueur){
        Object source = e.getSource();
        if (source == clefEau) {
            modele.echangeClef(Clef.clefEau, indiceJoueur);
        }
        if (source == clefTerre) {
            modele.echangeClef(Clef.clefTerre, indiceJoueur);
        }
        if (source == clefFeu) {
            modele.echangeClef(Clef.clefFeu, indiceJoueur);
        }
        if (source == clefAir) {
            modele.echangeClef(Clef.clefAir, indiceJoueur);
        }
    }
}


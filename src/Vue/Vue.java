package Vue;

import javax.swing.*;
import java.awt.*;

import Controleur.Souris;
import Model.* ;

/**
 * Initialise toutes les Vues et les affiche
 */
public class Vue {

    public Vue (Ile modele){

        // Initialisation de la fenetre d'affichage
        JFrame frame = new JFrame();
        frame.setTitle("Jeu de l'Ile interdite");
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);
        frame.setSize(300, 400);


        // Ajout des éléments dans la fenetre d'affichage
        VueGrille grille = new VueGrille(modele);
        grille.setPreferredSize(new Dimension(Main.LARGEUR * VueGrille.getTaille(), Main.HAUTEUR * VueGrille.getTaille()));
        GridBagConstraints gbc = new GridBagConstraints();

        // On positionne la case de départ
        gbc.gridx = 0;
        gbc.gridy = 0;

        // La taille en hauteur et en largeur
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        frame.add(grille, gbc);
        frame.getContentPane().add(grille);

        // Initialise le texte sur les joueurs, les clefs et artefacts qu'ils possèdent
        VueTexte texte = new VueTexte(modele);
        texte.setPreferredSize(new Dimension(300, VueGrille.getTaille() * Main.HAUTEUR));
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(texte,gbc);

        // Initialise le bouton fin de tour
        VueFinDeTour finDeTour = new VueFinDeTour(modele);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(finDeTour,gbc);

        // Initialise les boutons pour échanger les Clefs
        VueEchangeClef echangeClef = new VueEchangeClef(modele);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(echangeClef,gbc);

        // Relie la souris à l'affichage
        Souris mouse = new Souris(modele, grille);
        frame.addMouseListener(mouse);

        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

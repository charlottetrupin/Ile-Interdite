package Controleur;

import Model.Ile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    /**
     * On garde un pointeur vers le modèle, car le contrôleur doit
     * provoquer un appel de méthode du modèle.
     **/
    Ile modele;

    public Controleur(Ile modele) {
        this.modele = modele;
    }

    /**
     * On verifie que la partie n'est ni perdue ni gagné avant de faire avancer le modèle
     * Sinon on "bloque" les boutons
     */
    public void actionPerformed(ActionEvent e) {
        if((!modele.partiePerdue()) && (!modele.partieGagne())) {
            modele.avance();
        }
    }
}

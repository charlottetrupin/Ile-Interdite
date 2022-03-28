package Test;


import Model.Clef;
import Model.Ile;
import Model.Joueur;
import Model.Role;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

public class JoueurTest {

    Ile modele = new Ile(3,3);

    @org.junit.jupiter.api.Test
    void testPossedeClef(){
        Joueur j = new Joueur(modele, 0, Color.red, Role.Normal);
        j.setClefpossedees(Clef.clefEau,1);
        j.setClefpossedees(Clef.clefTerre, 1);
        j.setClefpossedees(Clef.clefFeu, 1);
        j.setClefpossedees(Clef.clefAir, 1);
        Assertions.assertTrue(j.getClefpossedees(0) == 1);
        Assertions.assertTrue(j.getClefpossedees(1) == 1);
        Assertions.assertTrue(j.getClefpossedees(2) == 1);
        Assertions.assertTrue(j.getClefpossedees(3) == 1);
    }

    @org.junit.jupiter.api.Test
    void testPossedeArtefact(){
        Joueur j = new Joueur(modele, 0, Color.red, Role.Normal);

        j.setClefpossedees(Clef.clefEau, 1);
        j.setCoordonnees(modele.getZoneArtefact()[0]);
        Assertions.assertTrue(j.recupArtefact());
        Assertions.assertTrue(j.getArtefactpossedees(0));

        j.setClefpossedees(Clef.clefTerre, 1);
        j.setCoordonnees(modele.getZoneArtefact()[1]);
        Assertions.assertTrue(j.recupArtefact());
        Assertions.assertTrue(j.getArtefactpossedees(1));

        j.setClefpossedees(Clef.clefFeu, 1);
        j.setCoordonnees(modele.getZoneArtefact()[2]);
        Assertions.assertTrue(j.recupArtefact());
        Assertions.assertTrue(j.getArtefactpossedees(2));

        j.setClefpossedees(Clef.clefAir, 1);
        j.setCoordonnees(modele.getZoneArtefact()[3]);
        Assertions.assertTrue(j.recupArtefact());
        Assertions.assertTrue(j.getArtefactpossedees(3));

    }

}

package Test;

import Model.Case;
import Model.Etat;
import Model.Ile;
import org.junit.jupiter.api.Assertions;

class CaseTest {
    Ile modele = new Ile(4,4);

    @org.junit.jupiter.api.Test
    void testInondee(){
        Case[][] cases = modele.getCases();
        Case c = cases[0][0];
        c.inonde();
        Assertions.assertEquals(Etat.inondee, c.getEtat());

    }

    @org.junit.jupiter.api.Test
    void assecherZone() {
        Case[][] cases = modele.getCases();
        Case c = cases[0][0];
        c.assecheCase();
        Assertions.assertEquals(Etat.normale, c.getEtat());

        c.inonde();
        c.assecheCase();
        Assertions.assertEquals(Etat.normale, c.getEtat());

        c.inonde();
        c.inonde();
        c.assecheCase();
        Assertions.assertEquals(Etat.submergee, c.getEtat());
    }

}
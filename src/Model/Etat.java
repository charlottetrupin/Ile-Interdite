package Model;

/**
 *  Represente l'état d'une case
 *  Une case peut être normale, inondee ou submergee
 **/

public enum Etat {
    normale,
    inondee,
    submergee;


    /**
     * Renvoie un string représentant un état
     */
    public String toString() {
        if (this == normale) {
            return "N" ;
        }
        else if (this == inondee) {
            return "I";
        }
        else return "S";
    }

}

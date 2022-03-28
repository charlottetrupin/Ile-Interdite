package Model;

/**
 * Représente les différentes zone speciales que peut avoir une case
 */
public enum ZoneSpe {
    heliport,
    normal,
    eau,
    terre,
    feu,
    air;


    /**
     * Renvoie un string représentant une zone speciale
     */
    public String toString() {
        if (this == heliport) {
            return "Heliport" ;
        }
        else if (this == normal) {
            return "Normal";
        }
        else if (this == eau) {
            return "Eau";
        }
        else if (this == terre){
            return "Terre";
        } else if (this == feu) {
            return "Feu";
        } else {
            return "Air";
        }
    }
}

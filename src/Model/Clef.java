package Model;

public enum Clef {
    clefEau,
    clefTerre,
    clefFeu,
    clefAir;


    /**
     * Renvoie un string représentant une clef
     */
    public String toString() {
        if (this == clefEau) {
            return "ClefE" ;
        }
        else if (this == clefTerre) {
            return "ClefT";
        }
        else if(this == clefFeu) {
            return "ClefF";
        }
        else
            return "ClefA";

    }

}

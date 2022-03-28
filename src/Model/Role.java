package Model;


/**
 * Représente les différents rôles que peut avoir un joueur
 */
public enum Role {
    Plongeur,      //peut se deplacer sur des cases submergées
    Pilote,        //peut se déplacer vers une zone non submerǵee arbitraire
    Explorateur,   //peut se déplacer et asśecher diagonalement
    Messager,      //peut donner une clé qu’il possède à un joueur distant
    Normal;


    /**
     * Renvoie un string représentant un rôle
     */
    public String toString() {
        if (this == Plongeur) {
            return "Plongueur" ;
        }
        else if (this == Pilote) {
            return "Pilote";
        }
        else if (this == Explorateur) {
            return "Explorateur";
        }
        else if (this == Messager){
            return "Messager";
        }
        else return "Normal";
    }
    
}

package farm.model.animals;


/**
 * 
 * @author MConstantin
 *
 */
public interface Aquatic {
    
    /**
     * Sert � savoir si l'animal peut �tre en dehors de l'eau
     * @param t
     * @return r�ponse de la question 
     */
    default String canBeOutsideWatter(int t) {
        return t == 1 ? "Oui" : "Non";
    }
    
    
}

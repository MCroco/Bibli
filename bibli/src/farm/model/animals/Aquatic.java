package farm.model.animals;


/**
 * 
 * @author MConstantin
 *
 */
public interface Aquatic {
    
    /**
     * Sert à savoir si l'animal peut être en dehors de l'eau
     * @param t
     * @return réponse de la question 
     */
    default String canBeOutsideWatter(int t) {
        return t == 1 ? "Oui" : "Non";
    }
    
    
}

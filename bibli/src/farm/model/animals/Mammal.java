package farm.model.animals;


/**
 *
 * @author MConstantin
 */
public interface Mammal {
 
    
    /**
     * @param t
     * @return
     */
    default String hasFur(int t) {
        return t == 1 ? "Oui" : "Non"; 
    }

}

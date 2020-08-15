package farm.model.animals;

/**
 *
 * @author MConstantin
 */
public interface Reptile {
    
    default String isVennon(int t) {
        return t ==1 ? "Oui" : "Non"; 
    }
    
}

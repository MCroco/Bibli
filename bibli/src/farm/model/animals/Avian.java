package farm.model.animals;

/**
 *
 * @author MConstantin
 */
public interface Avian {

    /**
     * @param t
     * @return
     */
    default String peutVoler(int t) {
        return t == 1 ? "Oui" : "Non"; 
    }
    
    /**
     * @param t
     * @return
     */
    default String aPlumes(int t) {
        return t == 1 ? "Oui" : "Non"; 
    }

}

package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author M. Constantin
 */
public interface Avian {

    default String peutVoler(int t) {
        return t == 1 ? "Oui" : "Non"; 
    }
    
    default String aPlumes(int t) {
        return t == 1 ? "Oui" : "Non"; 
    }
    
    public ArrayList<String> toArrayList();
      
    public ArrayList<String> nameVariables();
}

package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public interface Mammal {
 
    
    default String hasFur(int t) {
        return t == 1 ? "Yes" : "No"; 
    }
    
    public ArrayList<String> toArrayList();
    
    public ArrayList<String> nameVariables();
}

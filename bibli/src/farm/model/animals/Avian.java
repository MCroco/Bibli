
package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public interface Avian {

    default String canFly(int t) {
        return t == 1 ? "Yes" : "No"; 
    }
    
    default String hasFeeders(int t) {
        return t == 1 ? "Yes" : "No"; 
    }
    
    public ArrayList<String> toArrayList();
      
    public ArrayList<String> nameVariables();
}
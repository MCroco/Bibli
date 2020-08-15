/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm.model.animals;

/**
 *
 * @author MConstantin
 */
public interface Insect {

    /**
     * @param t
     * @return
     */
    default String isVennon(int t) {
        return t==1 ? "Yes": "No"; 
    }
}

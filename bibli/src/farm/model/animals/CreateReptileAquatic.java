/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateReptileAquatic extends Animal implements Reptile, Aquatic {
    
    private int isVenom;
    private int OutsideWater;
    
    public CreateReptileAquatic(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
        
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateReptileAquatic(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    public int getIsVenom() {
        return isVenom;
    }

    public void setIsVenom(int isVenom) {
        this.isVenom = isVenom;
    }

    public int getOutsideWater() {
        return OutsideWater;
    }

    public void setOutsideWater(int OutsideWater) {
        this.OutsideWater = OutsideWater;
    }
    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(isVenom(isVenom));
        list.add(canBeOutsideWatter(OutsideWater));
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("isVenom");
        names.add("OutsideWater");
        return names;
    }
    
    
}

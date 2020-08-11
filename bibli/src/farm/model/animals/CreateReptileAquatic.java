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
    
    private int isVennon;
    private int canBeOutSideWatter;
    
    public CreateReptileAquatic(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
        
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateReptileAquatic(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    public int getIsVennon() {
        return isVennon;
    }

    public void setIsVennon(int isVennon) {
        this.isVennon = isVennon;
    }

    public int getCanBeOutSideWatter() {
        return canBeOutSideWatter;
    }

    public void setCanBeOutSideWatter(int canBeOutSideWatter) {
        this.canBeOutSideWatter = canBeOutSideWatter;
    }
    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(isVennon(isVennon));
        list.add(canBeOutsideWatter(canBeOutSideWatter));
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("isVennon");
        names.add("canBeOutSideWatter");
        return names;
    }
    
    
}

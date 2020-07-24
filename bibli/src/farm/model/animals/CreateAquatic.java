package farm.model.animals;

import java.util.ArrayList;


/**
 * 
 * @author MConstantin
 *
 */

public class CreateAquatic extends Animal implements Aquatic {
    
    private int OutsideWater;
    
    public CreateAquatic(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
        
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateAquatic(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    public void setOutsideWater(int OutsideWater) {
        this.OutsideWater = OutsideWater;
    }    
    
    public int getOutsideWater() {
        return OutsideWater;
    }
    
    @Override
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(canBeOutsideWatter(OutsideWater));
        return list;
    }
    
    @Override
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("OutsideWater");
        return names;
    }
    
}

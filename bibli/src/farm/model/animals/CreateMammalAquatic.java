package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateMammalAquatic extends Animal implements Mammal, Aquatic  {
    
    private int furry;
    private int OutsideWater; 
    
    public CreateMammalAquatic(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
        
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateMammalAquatic(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    public int getFurry() {
        return furry;
    }

    public void setFurry(int furry) {
        this.furry = furry;
    }

    public int getCanBeOutSideWatter() {
        return OutsideWater;
    }

    public void setCanBeOutSideWatter(int OutsideWater) {
        this.OutsideWater = OutsideWater;
    }
    
     public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(hasFur(furry));
        list.add(canBeOutsideWatter(OutsideWater));
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("furry");
        names.add("OutsideWater");
        return names;
    }
    
    
}

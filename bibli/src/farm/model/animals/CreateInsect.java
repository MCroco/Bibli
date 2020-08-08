package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateInsect extends Animal implements Insect {
    
    private int isVenom; 
    
    
    public CreateInsect(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
    
    }
    
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateInsect(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    public int getIsVennon() {
        return isVenom;
    }

    public void setIsVennon(int isVenom) {
        this.isVenom = isVenom;
    }
    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(isVenom(isVenom));
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("isVenom");
        return names;
    }
    
}

package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateReptile extends Animal implements Reptile  {
    
    private int isVenom; 
    
    public CreateReptile(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
    
    }

    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateReptile(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    public int getIsVennon() {
        return isVenom;
    }

    public void setIsVennon(int isVenom) {
        this.isVenom = isVenom;
    }
    
    @Override
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(isVenom(isVenom));
        return list;
    }
    
    @Override
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("isVenom");
        return names;
    }
    
}

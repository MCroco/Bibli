package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateInsect extends Animal implements Insect {
    
    private int isVennon; 
    
    
    /**
     * @param specie
     * @param name
     * @param dateOfBirth
     * @param dateOfArrival
     * @param gender
     * @param medication
     * @param vaccine
     */
    public CreateInsect(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
    
    }
    
    /**
     *
     */
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateInsect(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    /**
     * @return
     */
    public int getIsVennon() {
        return isVennon;
    }

    /**
     * @param isVennon
     */
    public void setIsVennon(int isVennon) {
        this.isVennon = isVennon;
    }
    
    /**
     *
     */
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(isVennon(isVennon));
        return list;
    }
    
    /**
     *
     */
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("isVennon");
        return names;
    }
    
}

package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateAvian extends Animal implements Avian {
    
    private int canFly;
    private int hasFeeders;
    
    
    /**
     * @param specie
     * @param name
     * @param dateOfBirth
     * @param dateOfArrival
     * @param gender
     * @param medication
     * @param vaccine
     */
    public CreateAvian(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
    
    }
    
    /**
     *
     */
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateAvian(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    /**
     * @return
     */
    public int getCanFligh() {
        return canFly;
    }

    /**
     * @param canFly
     */
    public void setCanFligh(int canFly) {
        this.canFly = canFly;
    }

    /**
     * @return
     */
    public int getHasFeeders() {
        return hasFeeders;
    }

    /**
     * @param hasFeeders
     */
    public void setHasFeeders(int hasFeeders) {
        this.hasFeeders = hasFeeders;
    }
    
    
    /**
     *
     */
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(peutVoler(canFly));
        list.add(aPlumes(hasFeeders));
        return list;
    }
    
    
    /**
     *
     */
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("canFly");
        names.add("hasFeeders");
        return names;
    }
    
    
    
}

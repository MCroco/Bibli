package farm.model.animals;

import java.util.ArrayList;

/**
 * @author moi
 *
 */
public class CreateAquatic extends Animal implements Aquatic {
    
    private int canBeOutSideWatter;
    
    /**
     * @param specie
     * @param name
     * @param dateOfBirth
     * @param dateOfArrival
     * @param gender
     * @param medication
     * @param vaccine
     */
    public CreateAquatic(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
        
    }
    
    /**
     *
     */
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateAquatic(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    /**
     * @param canBeOutSideWatter
     */
    public void setCanBeOutSideWatter(int canBeOutSideWatter) {
        this.canBeOutSideWatter = canBeOutSideWatter;
    }    
    
    /**
     * @return
     */
    public int getCanBeOutSideWatter() {
        return canBeOutSideWatter;
    }
//    
    
    /**
     *
     */
    @Override
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(canBeOutsideWatter(canBeOutSideWatter));
        return list;
    }
    
    /**
     *
     */
    @Override
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("canBeOutSideWatter");
        return names;
    }
    
}

package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateMammalAquatic extends Animal implements Mammal, Aquatic  {
    
    private int furry;
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
    public CreateMammalAquatic(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, vaccine);
        
    }
    
    /**
     *
     */
    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        getOffsprings().add(new CreateMammalAquatic(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, vaccine));
    }

    /**
     * @return
     */
    public int getFurry() {
        return furry;
    }

    /**
     * @param furry
     */
    public void setFurry(int furry) {
        this.furry = furry;
    }

    /**
     * @return
     */
    public int getCanBeOutSideWatter() {
        return canBeOutSideWatter;
    }

    /**
     * @param canBeOutSideWatter
     */
    public void setCanBeOutSideWatter(int canBeOutSideWatter) {
        this.canBeOutSideWatter = canBeOutSideWatter;
    }
    
     /**
     *
     */
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(hasFur(furry));
        list.add(canBeOutsideWatter(canBeOutSideWatter));
        return list;
    }
    
    /**
     *
     */
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("furry");
        names.add("canBeOutSideWatter");
        return names;
    }
    
    
}

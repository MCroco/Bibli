package farm.model.animals;

import java.util.ArrayList;

/**
 *
 * @author MConstantin
 */
public class CreateMammal extends Animal implements Mammal {
    
    private int furry; 
    
    public CreateMammal(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine Vaccine) {
        super(specie, name, dateOfBirth, dateOfArrival, gender, medication, Vaccine);
    
    }
    
    public int getFurry() {
        return furry;
    }

    public void setFurry(int furry) {
        this.furry = furry;
    }
    
    public String toString() {
        String offpring = "";
        if (getOffsprings().size() != 0){
            for (int i = 0 ; i < getOffsprings().size() ; i++){
                if (i == getOffsprings().size() - 1){
                    offpring += String.valueOf(getOffsprings().get(i).getidAnimal());
                }else{
                    offpring += String.valueOf(getOffsprings().get(i).getidAnimal())+", ";
                }
            }
            offpring = "Animal: "+offpring;
        }else{
            offpring = "No offprings";
        }
    return super.toString() + "\tFurry:" + getFurry() + "\n" + "\t Offprings:\n" + "\t\t" + offpring + "\n";
    }

    @Override
    public void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine Vaccine) {
        getOffsprings().add(new CreateMammal(this.getSpecie(), name, dateOfBirth, dateOfArrival, gender, medication, Vaccine));
     
    }
    
    @Override
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = super.toArrayList();
        list.add(hasFur(furry));
        return list;
    }
    
    @Override
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = super.nameVariables();
        names.add("furry");
        return names;
    }


    
}

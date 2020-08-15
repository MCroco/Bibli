package farm.model.animals;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author M. Constantin
 */
public class Vaccine implements Serializable {
    private int id;
    private final int serial; 
    private ArrayList<String> vaccineName;
    
    public Vaccine() {
        serial = id; 
        id++;
        vaccineName = new ArrayList<>(); 
    }
    
    public Vaccine(String name) {
        serial = id; 
        id++;
        vaccineName = new ArrayList<>();
        vaccineName.add(name); 
    }
    
    public void addVacine(String name) {
        vaccineName.add(name); 
    }

    public ArrayList<String> getVaccineName() {
        return vaccineName;
    }

//    public String toString(){
//        String var = "";
//        if (getVaccineName().size() != 0){
//            for (int i = 0 ; i < getVaccineName().size() ; i++){
//                if (i == getVaccineName().size() - 1){
//                    var += String.valueOf(getVaccineName().get(i));
//                }else{
//                    var += String.valueOf(getVaccineName().get(i))+", ";
//                }
//            }
//        }
//        return var;
//    }    

    public void addVaccine(ArrayList<String> vac) {
        for (String v : vac) {
            this.vaccineName.add(v);
        }
    }
} 
       


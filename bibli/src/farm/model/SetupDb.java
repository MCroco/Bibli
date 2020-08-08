
package farm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import farm.model.animals.Animal;
import farm.model.animals.Medication;
import farm.model.animals.Vaccine;


/**
 *
 * @author MConstantin
 */
public class SetupDb implements Serializable {
    private ArrayList<Animal> myAnimals;
    private ArrayList<Medication> myMedication;
    private ArrayList<Vaccine> myVaccines;

    private String[] mammalSpecies = {"Cheval", "Vache", "Cochon", "Mouton", "Chevre", "Chien", "Chat", "Lapin"};
    private String[] reptileSpecies = {"Serpent", "Lezard", "Igouane", "Chamaleons"}; 
    private String[] avianSpecies = {"Poule", "Canard", "Oies", "Signe", "Dinde"}; 
    private String[] mammalAquaticSpecies = {"Castor", "Capibara"}; 
    private String[] reptileAquatic = {"Tortue", "Salamandre"}; 
    private String[] names = {};
    private String[] medication = {"Advantix", "Covarmed", "ABCEDYL ", "BRONCHORYL", "CERVICYL ", "DRAINOSYL ", "HEMOSTATYL ", "Veratasol"};
    private String[] vaccine = {"Tenivac", "MMRV", "Typhoid-Oral", "Flulaval", "MenACWY", "MenB", "Fluzone", "Zostavax"};
    
    private String[] dates = {};
    
    
    private String[] animalTypes = {"Mamifere", "Reptile", "Aviaire", "Aquatique", "Insecte"};
    
    public SetupDb() {
        myAnimals = new ArrayList<Animal>();
        myMedication = new ArrayList<>();
        myVaccines = new ArrayList<>();

    }
        
    
    public void setListMedication(int numMed) { 
        Random r = new Random(); 
        for(int i = 0; i < numMed ; i++) {
            myMedication.add(new Medication());
            for(int j = 0 ; j < r.nextInt(4); j++) {
                myMedication.get(i).addMedication(medication[r.nextInt(medication.length)]);
            }
        }
    }
    
    public void setListVacine(int numbVac) {
        Random r = new Random(); 
        for(int i = 0; i < numbVac ; i++) {
            myVaccines.add(new Vaccine());
            for(int j = 0 ; j < r.nextInt(4); j++) {
                myVaccines.get(i).addVacine(vaccine[r.nextInt(vaccine.length)]);
            }
        }
    }
    

    
    public ArrayList<Animal> getMyAnimals() {
        return myAnimals;
    }

    public void setMyAnimals(ArrayList<Animal> myAnimals) {
        this.myAnimals = myAnimals;
    }

    public ArrayList<Medication> getMyMedication() {
        return myMedication;
    }
    
     public ArrayList<Vaccine> getMyVaccines() {
        return myVaccines;
    }

    public void setMyMedication(ArrayList<Medication> myMedication) {
        this.myMedication = myMedication;
    }


    
}


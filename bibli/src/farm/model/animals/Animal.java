package farm.model.animals;

import java.io.Serializable;
import java.util.ArrayList;

import farm.model.SetupData;

public abstract class Animal implements Serializable {
    
    private static int id;
    private final  int exhibitionNumb;
    private String specie;
    private String name;
    private String dateOfBirth;
    private String dateOfArrival;
    private String gender;
    private Medication medication;
    private Vaccine vaccine;
    private ArrayList<Animal> offsprings;
    
   
    public Animal() {
        exhibitionNumb = id; 
        id++;
        
    }
    
    public Animal(String specie, String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine) {
        exhibitionNumb = id; 
        id++; 
        this.specie = specie; 
        this.name = name; 
        this.dateOfBirth = dateOfBirth; 
        this.dateOfArrival = dateOfArrival;
        this.medication = medication; 
        this.vaccine = vaccine; 
        if (gender == 1) {
            this.gender = "Male";
        } else {
            this.gender = "Femelle";
        }
        this.offsprings = new ArrayList<Animal>();
    }

    public int getExhibitionNumb() {
        return exhibitionNumb;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public String getGender() {
        return gender;
    }

    public Medication getMedication() {
        return medication;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public String getSpecie() {
        return specie;
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<Animal> getOffsprings() {
        return offsprings;
    }
    
    
    
    public abstract void createOffpring(String name, String dateOfBirth, String dateOfArrival, int gender, Medication medication, Vaccine vaccine);

    
    public String toStringOffsprings(){
        String offpring = "";
        if (getOffsprings().size() != 0){
            for (int i = 0 ; i < getOffsprings().size() ; i++){
                if (i == getOffsprings().size() - 1){
                    offpring += String.valueOf(getOffsprings().get(i).getExhibitionNumb());
                }else{
                    offpring += String.valueOf(getOffsprings().get(i).getExhibitionNumb())+", ";
                }
            }
            offpring = "Animal: "+offpring+"";
        }
        return offpring;
    }
    
    public ArrayList<String> toArrayList(){
        ArrayList<String> list = new ArrayList<String>();
        list.add(String.valueOf(getExhibitionNumb()));
        list.add(getSpecie());
        list.add(getName());
        list.add(getDateOfBirth());
        list.add(getDateOfArrival());
        list.add(String.valueOf(getGender()));
        list.add(getMedication().toString());
        list.add(getVaccine().toString());
        list.add(toStringOffsprings());
        return list;
    }
    
    public ArrayList<String> nameVariables(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("exhibitionNumb");
        names.add("specie");
        names.add("name");
        names.add("dateOfBirth");
        names.add("dateOfArrival");
        names.add("gender");
        names.add("medication");
        names.add("vacine");
        names.add("offsprings");
        return names;
    }
    
    public  void setStaticVariable(int i) {
        this.id = i; 
    }
    
    
    

    
}

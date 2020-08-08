package farm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import farm.model.animals.Animal;
import farm.model.animals.CreateAvian;
import farm.model.animals.CreateMammal;
import farm.model.animals.CreateMammalAquatic;
import farm.model.animals.CreateReptile;
import farm.model.animals.CreateReptileAquatic;
import farm.model.animals.Medication;
import farm.model.animals.Vaccine;


/**
 *
 * @author MConstantin
 */
public class SetupData implements Serializable {
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
    
    public SetupData() {
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
    
    public void setListAnimals (int numAnimals) {
        try {
            
            Random r = new Random();
            for (int i = 0; i< numAnimals; i++) {
                
                switch (r.nextInt(5)) {
                    case 0: 
                        myAnimals.add(new CreateMammal(mammalSpecies[r.nextInt(mammalSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size()))));

                        // Down Casting to acces the mammal method furry
                        CreateMammal c; 
                        c = (CreateMammal) myAnimals.get(myAnimals.size()-1);
                        c.setFurry(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            c.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size())));
                             
                        //Down Casting to set furry to the Offsprings 
                        CreateMammal d; 
                        d = (CreateMammal) c.getOffsprings().get(j);
                        d.setFurry(r.nextInt(2));
                        myAnimals.add(d);
                        }
                    break;

                    case 1:
                        myAnimals.add(new CreateMammalAquatic(mammalAquaticSpecies[r.nextInt(mammalAquaticSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size()))));

                        // Down Casting to acces the mammal Aquatic properties 
                        CreateMammalAquatic mAq; 
                        mAq =   (CreateMammalAquatic) myAnimals.get(myAnimals.size()-1);
                        mAq.setCanBeOutSideWatter(r.nextInt(2));
                        mAq.setFurry(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            mAq.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size())));

                        //Down Casting to set unique fields to the Offsprings 
                        CreateMammalAquatic mA2; 
                        mA2 =  (CreateMammalAquatic) mAq.getOffsprings().get(j);
                        mA2.setCanBeOutSideWatter(r.nextInt(2));
                        mA2.setFurry(r.nextInt(2));
                        myAnimals.add(mA2);
                        
                        }
                    break;
                        
                    case 2:
                        myAnimals.add(new CreateReptile(reptileSpecies[r.nextInt(reptileSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size()))));

                        // Down Casting to acces the Reptile Method
                        CreateReptile rept;  
                        rept =   (CreateReptile) myAnimals.get(myAnimals.size()-1);
                        rept.setIsVennon(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            rept.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size())));

                         
                        CreateReptile rept2; 
                        rept2 = (CreateReptile) rept.getOffsprings().get(j);
                        rept2.setIsVennon(r.nextInt(2));
                        myAnimals.add(rept2);
                        }
                    break;
                    
                    case 3: 
                        myAnimals.add(new CreateAvian(avianSpecies[r.nextInt(avianSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size()))));
                        
                        
                        // Down Casting to acces the Avian Method
                        CreateAvian av;  
                        av =    (CreateAvian) myAnimals.get(myAnimals.size()-1);
                        av.setCanFligh(r.nextInt(2));
                        av.setHasFeeders(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            av.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size())));

                        CreateAvian av2; 
                        av2 = (CreateAvian) av.getOffsprings().get(j);
                        av2.setCanFligh(r.nextInt(2));
                        av2.setHasFeeders(r.nextInt(2));
                        myAnimals.add(av2);
                        }
                        break; 
                        
                    case 4: 
                        myAnimals.add(new CreateReptileAquatic(reptileSpecies[r.nextInt(reptileSpecies.length)], names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                        dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size()))));
                        
                        
                        // Down Casting to acces
                        CreateReptileAquatic ra;  
                        ra =     (CreateReptileAquatic) myAnimals.get(myAnimals.size()-1);
                        ra.canBeOutsideWatter(r.nextInt(2));
                        ra.isVennon(r.nextInt(2));

                        //Create Offsprings 
                        for (int j = 0; j < r.nextInt(4); j++) {
                            ra.createOffpring(names[r.nextInt(names.length)], dates[r.nextInt(dates.length)], 
                            dates[r.nextInt(dates.length)], r.nextInt(2), myMedication.get(r.nextInt(myMedication.size())), myVaccines.get(r.nextInt(myVaccines.size())));

                        CreateReptileAquatic ra2; 
                        ra2 =  (CreateReptileAquatic) ra.getOffsprings().get(j);
                        ra2.canBeOutsideWatter(r.nextInt(2));
                        ra2.isVennon(r.nextInt(2));
                        myAnimals.add(ra2);
                        }
                }
            }
        } catch(Exception e) {
            System.out.println("An Error has ocurred" + e);
            
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


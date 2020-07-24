package farm.model;

/**
 *
 * @author MConstantin
 */
import farm.model.animals.Animal;

import farm.model.animals.CreateMammal;
import farm.model.animals.Insect;
import farm.model.animals.Mammal;
import farm.model.animals.Medication;
import farm.model.animals.Reptile;
import farm.model.animals.Vaccine;
import farm.model.animals.Aquatic;
import farm.model.animals.Avian;
/*
 * A FAIRE AVEC CETTE STRUCTURE
 * 
 * 

import farm.model.animals.CreateAquatic;
import farm.model.animals.CreateAvian;
import farm.model.animals.CreateMammalAquatic;
import farm.model.animals.CreateReptile;
import farm.model.animals.CreateReptileAquatic;

 **/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class SetupDb implements Serializable {
	private ArrayList<Animal> myAnimals;
	private ArrayList<Medication> myMedication;
	private ArrayList<Vaccine> myVaccines;
 
    private String[] names = {"Poulette", "Rabbitou", "Chevrie", "Coqueee", "Antoinetté", "Julianne", "Nancy", "Bjorn", "Elisette", "Cobra", "judith", "Merveille", "Sezam", "Jeanninneee", "Rougeole"};
	private String[] mammalSpecies = {"Vache", "Cochon", "Cheval", "Lapin", "Ane", "Mouton","Chinchilla", "Chevre", "Chien", "Chat", "Cochon d'Inde"};
	private String[] avianSpecies = {"Peroquet", "Poules", "Oies", "Canard", "Dinde", "Pigeon"}; 
	private String[] mammalAquaticSpecies = {"Pinguin", "Castor", "Loutre", "Marmotte", "Capibara"}; 
	private String[] reptileAquatic = {"Crocodile", "Anaconda", "Serpent du Nord", "Salamandre", "Tortue", "Iguane"}; 
	private String[] medication = {"Bovalto Respi 3", "Bovipast RSP", "Nasym", "Cortimadin", "Tetapitant", "Ablastral", "Bactaxime", "Allokyn", "Sublamin", "Nornex", "Adiline", "Veratasol"};
	private String[] vaccine = {"Toux du chenil", "Piroplasmose", "Lyme", "CHPPILR", "Bvd", "Bpie", "bronchopneumonies ", "entérotoxémies"};
	private String[] dates = {"03/09/2019", "13/06/2020", "17/02/2019", "09/01/2018", "28/10/2018", "02/08/2018", "31/08/2019", "22/11/2019", "29/06/2018", "10/02/2018", "12/2019/2016",
			"23/07/2019", "30/09/2019", "22/03/2019", "21/10/1988", "13/02/2020", "07/09/2018", "23/01/2019", "09/11/2019", "14/05/1915", "24/12/2020", "22/12/2018", "21/07/2016", 
			"25/08/1992", "26/10/2017", "24/04/2020", "14/10/2017", "15/09/2017", "29/01/2015", "09/12/2018", "12/12/2017", "02/05/2020", "17/12/2017", "05/03/2020"};
	private String[] animalTypes = {"Mammals", "Avians", "Aquatics", "Insects"};



	/*
	 * 
	 * a tester pour les dates

	 */


	public SetupDb() {
		myAnimals = new ArrayList<Animal>();
		myMedication = new ArrayList<>();
		myVaccines = new ArrayList<>();

	}


	public void setListMedications(int numMed) { 
		Random r = new Random(); 
		for(int i = 0; i < numMed ; i++) {
			myMedication.add(new Medication());
			for(int j = 0 ; j < r.nextInt(4); j++) {
				myMedication.get(i).addMedication(medication[r.nextInt(medication.length)]);
			}
		}
	}

	public void setListVaccines(int numbVac) {
		Random r = new Random(); 
		for(int i = 0; i < numbVac ; i++) {
			myVaccines.add(new Vaccine());
			for(int j = 0 ; j < r.nextInt(4); j++) {
				myVaccines.get(i).addVaccine(vaccine[r.nextInt(vaccine.length)]);
			}
		}
	}

	public void setListAnimals (int numAnimals) {
		try {

			Random ran = new Random();
			for (int i = 0; i< numAnimals; i++) {

				switch (ran.nextInt(5)) {
				case 0: 
					myAnimals.add(new CreateMammal(mammalSpecies[ran.nextInt(mammalSpecies.length)], names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
							dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size()))));

					
					CreateMammal c; 
					c = (CreateMammal) myAnimals.get(myAnimals.size()-1);
					c.setFurry(ran.nextInt(2));

					//Create Offsprings 
					for (int j = 0; j < ran.nextInt(4); j++) {
						c.createOffpring(names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
								dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size())));

						//Down Casting to set furry to the Offsprings 
						CreateMammal d; 
						d = (CreateMammal) c.getOffsprings().get(j);
						d.setFurry(ran.nextInt(2));
						myAnimals.add(d);
					}
					break;

				case 1:
					myAnimals.add(new CreateMammalAquatics(mammalAquaticSpecies[r.nextInt(mammalAquaticSpecies.length)], names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
							dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size()))));

					// Down Casting to acces the mammal Aquatic properties 
					CreateMammalAquatic mAq; 
					mAq =   (CreateMammalAquatic) myAnimals.get(myAnimals.size()-1);
					mAq.setCanBeOutSideWatter(ran.nextInt(2));
					mAq.setFurry(ran.nextInt(2));

					//Create Offsprings 
					for (int j = 0; j < ran.nextInt(4); j++) {
						mAq.createOffpring(names[r.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
								dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size())));

						//Down Casting to set unique fields to the Offsprings 
						CreateMammalAquatic mA2; 
						mA2 =  (CreateMammalAquatic) mAq.getOffsprings().get(j);
						mA2.setCanBeOutSideWatter(ran.nextInt(2));
						mA2.setFurry(ran.nextInt(2));
						myAnimals.add(mA2);

					}
					break;

				case 2:
					myAnimals.add(new CreateReptile(reptileSpecies[ran.nextInt(reptileSpecies.length)], names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
							dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size()))));

					// Down Casting to acces the Reptile Method
					CreateReptile rept;  
					rept =   (CreateReptile) myAnimals.get(myAnimals.size()-1);
					rept.setIsVennon(ran.nextInt(2));

					//Create Offsprings 
					for (int j = 0; j < ran.nextInt(4); j++) {
						rept.createOffpring(names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
								dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size())));


						CreateReptile rept2; 
						rept2 = (CreateReptile) rept.getOffsprings().get(j);
						rept2.setIsVennon(ran.nextInt(2));
						myAnimals.add(rept2);
					}
					break;

				case 3: 
					myAnimals.add(new CreateAvians(avianSpecies[ran.nextInt(avianSpecies.length)], names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
							dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size()))));


					// Down Casting to acces the Avian Method
					CreateAvians av;  
					av =    (CreateAvians) myAnimals.get(myAnimals.size()-1);
					av.setCanFligh(ran.nextInt(2));
					av.setHasFeeders(ran.nextInt(2));

					//Create Offsprings 
					for (int j = 0; j < ran.nextInt(4); j++) {
						av.createOffpring(names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
								dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size())));

						CreateAvian av2; 
						av2 = (CreateAvian) av.getOffsprings().get(j);
						av2.setCanFligh(ran.nextInt(2));
						av2.setHasFeeders(ran.nextInt(2));
						myAnimals.add(av2);
					}
					break; 

				case 4: 
					myAnimals.add(new CreateReptileAquatic(reptileSpecies[ran.nextInt(reptileSpecies.length)], names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
							dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size()))));


					// Down Casting to acces
					CreateReptileAquatic ra;  
					ra =     (CreateReptileAquatic) myAnimals.get(myAnimals.size()-1);
					ra.canBeOutsideWatter(ran.nextInt(2));
					ra.isVennon(ran.nextInt(2));

					//Create Offsprings 
					for (int j = 0; j < ran.nextInt(4); j++) {
						ra.createOffpring(names[ran.nextInt(names.length)], dates[ran.nextInt(dates.length)], 
								dates[ran.nextInt(dates.length)], ran.nextInt(2), myMedication.get(ran.nextInt(myMedication.size())), myVaccines.get(ran.nextInt(myVaccines.size())));

						CreateReptileAquatic ra2; 
						ra2 =  (CreateReptileAquatic) ra.getOffsprings().get(j);
						ra2.canBeOutsideWatter(ran.nextInt(2));
						ra2.isVennon(ran.nextInt(2));
						myAnimals.add(ra2);
					}
				}
			}
		} catch(Exception e) {
			System.out.println("il y a un soucis : " + e);

		}
	}


	/**
	 * Getter for the animal
	 * @return myAnimals
	 */
	public ArrayList<Animal> getMyAnimals() {
		return myAnimals;
	}
	
	/**
	 * Setter for the animal 
	 * @param myAnimals
	 */
	public void setMyAnimals(ArrayList<Animal> myAnimals) {
		this.myAnimals = myAnimals;
	}

	
	
	public ArrayList<Medication> getMyMedication() {
		return myMedication;
	}

	
	public void setMyMedication(ArrayList<Medication> myMedication) {
		this.myMedication = myMedication;
	}
	
	
	
	public ArrayList<Vaccine> getMyVaccines() {
		return myVaccines;
	}




}


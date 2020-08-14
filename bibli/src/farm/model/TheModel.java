/**
 * Class The Model
 * 
 * Purpose:
 * 
 * Responsible for creating the instances of the setup 
 * 
 * In this class we have methods for serialization and deserialization which will be the methods responsible for storing the data and getting it back  
 * 
 */
package farm.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import farm.model.animals.Animal;


/**
 *
 * @author MConstantin
 */
public class TheModel  {
    
    /**
     * Instances for the class are described as follow 
     */
    private SetupData setup; // instance to access the methods in SetupData class 

    private File file; // file used for serialization of animals  

    private ArrayList<Animal> listAnimals; // we need a list of animals
   
    
    public SetupData getSetup() {
		return setup;
	}



	public void setSetup(SetupData setup) {
		this.setup = setup;
	}



	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public void setListAnimals(ArrayList<Animal> listAnimals) {
		this.listAnimals = listAnimals;
	}



	/**
     * 
     * @return 
     */
    public ArrayList<Animal> getListAnimals() {
        return listAnimals;
    }
    

     
    /**
     * Constructor of TheModel, which it doesn't take any parameters 
     * 
     * We initialize the setup and search instances 
     */
    public TheModel() {
        
        setup  = new SetupData();
        
        
        // As soon as TheModel in run. It will look for the data file (.ser) 
        try {
             file = new File("data.ser"); // create a new file for animal 
             
             
             boolean exits = file.createNewFile();

             
             if (!exits) { // if the files exits 
                deserialization(); // then retrieve the data 
                
             } else { // if the files do not exits, It means there is not data. Then Create it 
                setup.setListMedication(50);
                setup.setListVacine(50);
                setup.setListMain(200);
             
                
                // after creating the data assign the list of animals created in setup class to the listAnimals. 
                listAnimals = setup.getMyAnimals(); 
              
                
             }
        // Catch any Error, if any.         
        } catch (IOException ex) {
            System.out.println("Exception Occurred:");
	    ex.printStackTrace();
        }

    }
    
    /**
     * This Method take the data within the Arrays listAnimal and serialize then inside the files data.ser
     * 
     */
    public void serialization() {
        
            FileOutputStream fileOut = null;
        try {
            // we will need:
            // 1) FileOutputStream
            fileOut = new FileOutputStream(file);

            // 2) ObjectOutputStream - and pass on the FileOutputStream
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // now we will need to write the object 
            out.writeObject(listAnimals);
            out.flush();
            // Close file
            out.close();

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            
    }
    
    /**
     * This Method take the data Within the files data.ser and copy it into the the Arrays listAnimal . 
     * 
     * At the end of this method we use the setSatatic variable, to set the id in the class Animal so we can keep track of the last exhibition number without creating redundancy 
     */
    @SuppressWarnings("unchecked")
	public void deserialization()  {
            
            FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("data.ser");
            // 2) ObjectInputStream - Pass on the FileInputStream 
            ObjectInputStream in = new ObjectInputStream(fileIn);
            try {
                listAnimals = (ArrayList<Animal>) in.readObject();
                in.close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            // setup the static variable in Animals
            listAnimals.get(0).setStaticVariable(listAnimals.size());

           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileIn.close();
            } catch (IOException ex) {
                Logger.getLogger(TheModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

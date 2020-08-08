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
    private SetupData setup; // instance to access the methods in SetUp class 

    private File file; // file used for serialization of animals  

    private ArrayList<Animal> listAnimals; // we need a list of animals
   
    
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
             
                
                // after creating the data assign the list of animals and keepers created in setup class to the listAnimals and listOfKeepers. 
                listAnimals = setup.getMyAnimals(); 
              
                
             }
        // Catch any Error, if any.         
        } catch (IOException ex) {
            System.out.println("Exception Occurred:");
	    ex.printStackTrace();
        }

    }
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

    
    
}

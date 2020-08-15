/**
 * ViewAnimalsFrame
 *
 * Purpose:
 * 
 * To create a frame that displays/search for Animals
 * 
 * This class creates objects with the following characteristics:
 * 
 * Header header
 * ImageLabel viewAnimalImage;
 * RefineByPanel refiningTextPanel;
 * ViewAnimalsPanel animalsPanel;
 * ViewAnimalCard animalView;
 * ViewOffspringsPanel offspringsPanel;
 * final ArrayList<String> refiningFields;
 * GenericButton updateAnimalButton;
 * ImageLabel viewAnimalsOnFrame;
 * 
 * This Class Extends MainFrame, that is a class that creates Frames given a input
 */

package farm.view.animals;

import java.util.ArrayList;

import farm.model.animals.Animal;
import farm.view.generic.GenericButton;
import farm.view.generic.Header;
import farm.view.generic.ImageLabel;
import farm.view.generic.MainFrame;

/**
 *
 *
 * Purpose:
 * To create a frame that displays Animals that are stored in the ArrayList.
 * This Class Extends MainFrame, that is a class that creates Frames given a input.
 *
 * @author MConstantin
 *
 */
public class ViewAnimalsFrame extends MainFrame {
    
    private Header header;
    private ImageLabel viewAnimalImage;
    private ViewAnimalsPanel animalsPanel;
    private ViewAnimalCard animalView;
    private ViewOffspringsPanel offspringsPanel;
    private GenericButton updateAnimalButton;
    private final ImageLabel placeHolderImage;
    private ArrayList<Animal> animals;
    
    /**
     * Constructor of the Class ViewAnimalsFrame to create ViewAnimalsFrame objects.
     * 
     * This constructor takes the parameters:
     * 
     * @param frameTitle String that sets the title of the frame
     * @param frameWidth int that sets the width of the frame
     * @param frameHeight int that sets the height of the frame
     * @param iconName String that points to the location of the icon of the frame
     */
    public ViewAnimalsFrame(ArrayList<Animal> animals, String frameTitle, int frameWidth, int frameHeight, String iconName) {
        
        super(frameTitle, frameWidth, frameHeight, iconName);
        
        this.animals = animals;
        
        // Header panel
        this.header = new Header(frameWidth, 260, "Voir / MAJ animaux", "src/farm/view/images/addanimal.png", "src/farm/view/images/back.png", "Retour");
        this.add(header);
        
        // Animals Image
        this.viewAnimalImage = new ImageLabel(10, 40, 270, 180, "src/farm/view/images/animali.png");
        this.add(viewAnimalImage.getImageLabel());
        

        
        
        // Animals' list Panel
        this.animalsPanel = new ViewAnimalsPanel(15, 205, 500, 360, "Animaux", "Animaux recherches", 330);
        this.add(this.animalsPanel);
        
        // Initializing the table with all the data
        this.animalsPanel.dataToString(animals);
        this.animalsPanel.setData();
        
        
        // Another Animals Image
        this.placeHolderImage = new ImageLabel(10, 10, 10, 10, "src/farm/view/images/placeholder.jpg");
        this.add(this.placeHolderImage.getImageLabel());
        this.placeHolderImage.getImageLabel();        
        
        // Animal's Description Card
        this.animalView = new ViewAnimalCard(525, 205, 220, 360, "Details animaux", "Details de l'animal");
        this.add(this.animalView);
        
        // Animal's Offprings Table
        this.offspringsPanel = new ViewOffspringsPanel(755, 205, 200, 300, "Enfant", "Enfant de l'animal choisi", 270);
        this.add(this.offspringsPanel);
        
        // Update Animal Selected Button
        this.updateAnimalButton = new GenericButton(800, 520, 120, "src/farm/view/images/updateanimal.png", "Mise a jour animal", "Mise a jour animal selectionne");
        this.add(this.updateAnimalButton);
        
        
    }

    public ViewAnimalCard getAnimalView() {
        return animalView;
    }

    public Header getHeader() {
        return header;
    }

    public ViewOffspringsPanel getOffspringsPanel() {
        return offspringsPanel;
    }

//    public ImageLabel getPlaceHolderImage() {
//        return placeHolderImage;
//    }

    public ViewAnimalsPanel getAnimalsPanel() {
        return animalsPanel;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public GenericButton getUpdateAnimalButton() {
        return updateAnimalButton;
    }
    
    
    
}

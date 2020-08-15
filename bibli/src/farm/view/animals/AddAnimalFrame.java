/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm.view.animals;

import java.util.ArrayList;
import java.util.Arrays;

import farm.view.generic.CalendarPanel;
import farm.view.generic.CheckBoxPanel;
import farm.view.generic.ComboBoxFieldsPanel;
import farm.view.generic.GenericButton;
import farm.view.generic.Header;
import farm.view.generic.ImageLabel;
import farm.view.generic.MainFrame;
import farm.view.generic.TextFieldPanel;

/**
 *
 * @author MConstantin
 */
public class AddAnimalFrame extends MainFrame {
    
    private ComboBoxFieldsPanel medication;
    private ComboBoxFieldsPanel vaccine;
    private ComboBoxFieldsPanel type;
    private ComboBoxFieldsPanel specie;
    private ComboBoxFieldsPanel gender;
    private Header header;
    private final ImageLabel addAnimalImageLabel;
    private TextFieldPanel addAnimalName;
    private final ImageLabel addAnimalImageLabel2;
    private CalendarPanel addAnimalDayOfBirth;
    private CalendarPanel addAnimalDayOfArrival;
    private GenericButton addAnimalButton;
    private GenericButton resetAnimalButton;
    private final ImageLabel addAnimalImageLabel3;
    private CheckBoxPanel extraCharacteristics;
    
    public AddAnimalFrame(String frameTitle, int frameWidth, int frameHeight, String iconName) {
        super(frameTitle, frameWidth, frameHeight, iconName);
        
        this.header = new Header(frameWidth, 110, "Ajouter", "src/farm/view/images/addanimal.png", "src/farm/view/images/back.png", "Retour");
        this.add(this.header);
        
        this.addAnimalImageLabel = new ImageLabel(20, 70, 173, 200, "src/farm/view/images/addditto.png");
        this.add(this.addAnimalImageLabel.getImageLabel());
        
        this.type = new ComboBoxFieldsPanel(this.setTypesFields(), "Type", 200, 70, 60);
        this.add(this.type);
        this.type.setEnabled(true);
        this.type.getFieldOne().setEnabled(true);
        
        ArrayList<String> list = new ArrayList<>();
        this.specie = new ComboBoxFieldsPanel(list, "Espece", 200, 130, 60);
        this.add(this.specie);
        this.specie.setEnabled(true);
        this.specie.getFieldOne().setEnabled(true);
        
        this.addAnimalName = new TextFieldPanel(340, 70, 190, 60, "Nom ");
        this.add(this.addAnimalName);
        this.addAnimalName.setEnabled(true);
        this.addAnimalName.getTextField().setEnabled(true);
        
        ArrayList<String> genders = new ArrayList<String>();
        genders.add("Male");
        genders.add("Femelle");
        this.gender = new ComboBoxFieldsPanel(genders, "Genre", 340, 130, 60);
        this.add(this.gender);
        this.gender.setEnabled(true);
        this.gender.getFieldOne().setEnabled(true);
        
        this.addAnimalImageLabel2 = new ImageLabel(485, 140, 40, 40, "src/farm/view/images/cat.png");
        this.add(this.addAnimalImageLabel2.getImageLabel());
        
        this.addAnimalDayOfBirth = new CalendarPanel(540, 70, "Jour de naissance ", "Jour naissance");
        this.add(this.addAnimalDayOfBirth);
        this.addAnimalDayOfBirth.setEnabled(true);
        this.addAnimalDayOfBirth.getDatePicker().getComponent(0).setEnabled(true);
        this.addAnimalDayOfBirth.getDatePicker().getComponent(1).setEnabled(true);
        
        this.addAnimalDayOfArrival = new CalendarPanel(540, 130, "Jour arrivage ", "Jour arrivee");
        this.add(this.addAnimalDayOfArrival);
        this.addAnimalDayOfArrival.setEnabled(true);
        this.addAnimalDayOfArrival.getDatePicker().getComponent(0).setEnabled(true);
        this.addAnimalDayOfArrival.getDatePicker().getComponent(1).setEnabled(true);
        
        this.medication = new ComboBoxFieldsPanel(this.setMedicineFields(), "Medicaments", 200, 190);
        this.add(this.medication);
        
        this.vaccine = new ComboBoxFieldsPanel(this.setVaccineFields(), "Vaccin", 340, 190);
        this.add(this.vaccine);
        
        this.extraCharacteristics = new CheckBoxPanel(480, 190, 120, 80, "Extras ", "Ajouter des details pour l'animal");
        this.add(this.extraCharacteristics);
        
        
        this.addAnimalButton = new GenericButton(495, 280, 90, "src/farm/view/images/addanimal.png", "Ajouter ", "Ajouter Animal");
        this.add(this.addAnimalButton);
        this.addAnimalButton.setEnabled(true);
        
        this.resetAnimalButton = new GenericButton(50, 280, 90, "src/farm/view/images/reset.png", "Reset ", "Reset valeurs");
        this.add(this.resetAnimalButton);
        this.resetAnimalButton.setEnabled(true);
        
        this.addAnimalImageLabel3 = new ImageLabel(610, 190, 130, 130, "src/farm/view/images/snake.png");
        this.add(this.addAnimalImageLabel3.getImageLabel());
        
    }
    
    /**
     * @return
     */
    private ArrayList<String> setTypesFields() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Aviaire");
        list.add("Mamifere");
        list.add("Reptile");
        list.add("Mamifere Aquatique");
        list.add("Reptile Aquatic");
        
        return list;
    }
    
    /**
     * @param typeField
     * @return
     */
    public ArrayList<String> setSpeciesFields(String typeField) {
        ArrayList<String> list;
        
        switch (typeField) {
            case "Aviaire":
                String[] avianSpecies = {"Poule", "Canard", "Oies", "Signe", "Dinde"}; 
                list = new ArrayList<>(Arrays.asList(avianSpecies));
                return list;
            case "Mamifere":
                String[] mammalSpecies = {"Cheval", "Vache", "Cochon", "Mouton", "Chevre", "Chien", "Chat", "Lapin"};
                list = new ArrayList<>(Arrays.asList(mammalSpecies));
                return list;
            case "Reptile":
                String[] reptileSpecies = {"Tortue", "Salamandre"};  
                list = new ArrayList<>(Arrays.asList(reptileSpecies));
                return list;
            case "Mamifere Aquatique":
                String[] mammalAquaticSpecies = {"Castor", "Capibara"};  
                list = new ArrayList<>(Arrays.asList(mammalAquaticSpecies));
                return list;
            case "Reptile Aquatic":
                String[] reptileAquaticSpecies = {"Tortue", "Salamandre"};  
                list = new ArrayList<>(Arrays.asList(reptileAquaticSpecies));
                return list;
            default:
                return null;
        }
        
    }
    
    /**
     * @return
     */
    public ArrayList<String> setMedicineFields() {
        ArrayList<String> list;
        String[] medication = {"Advantix", "Covarmed", "ABCEDYL ", "BRONCHORYL", "CERVICYL ", "DRAINOSYL ", "HEMOSTATYL ", "Veratasol"};
        list = new ArrayList<>(Arrays.asList(medication));
        return list;
    }
    
    /**
     * @return
     */
    public ArrayList<String> setVaccineFields() {
        ArrayList<String> list;
        String[] vacine = {"Tenivac", "MMRV", "Typhoid-Oral", "Flulaval", "MenACWY", "MenB", "Fluzone", "Zostavax"};
        list = new ArrayList<>(Arrays.asList(vacine));
        return list;
    }

    /**
     * @return
     */
    public ComboBoxFieldsPanel getMedication() {
        return medication;
    }

    /**
     * @return
     */
    public ComboBoxFieldsPanel getVaccine() {
        return vaccine;
    }

    /**
     * @return
     */
    public ComboBoxFieldsPanel getTypeField() {
        return type;
    }

    /**
     * @return
     */
    public ComboBoxFieldsPanel getSpecie() {
        return specie;
    }

    /**
     * @return
     */
    public ComboBoxFieldsPanel getGender() {
        return gender;
    }

    /**
     * @return
     */
    public Header getHeader() {
        return header;
    }

    /**
     * @return
     */
    public TextFieldPanel getAddAnimalName() {
        return addAnimalName;
    }

    /**
     * @return
     */
    public CalendarPanel getAddAnimalDayOfBirth() {
        return addAnimalDayOfBirth;
    }

    /**
     * @return
     */
    public CalendarPanel getAddAnimalDayOfArrival() {
        return addAnimalDayOfArrival;
    }

    /**
     * @return
     */
    public GenericButton getAddAnimalButton() {
        return addAnimalButton;
    }

    /**
     * @return
     */
    public GenericButton getResetAnimalButton() {
        return resetAnimalButton;
    }

    /**
     * @return
     */
    public CheckBoxPanel getExtraCharacteristics() {
        return extraCharacteristics;
    }
    
    
    
}

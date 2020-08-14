/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm.controller.animals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import farm.controller.TheController;
import farm.model.TheModel;
import farm.model.animals.Animal;
import farm.model.animals.CreateAvian;
import farm.model.animals.CreateMammal;
import farm.model.animals.CreateMammalAquatic;
import farm.model.animals.CreateReptile;
import farm.model.animals.CreateReptileAquatic;
import farm.model.animals.Medication;
import farm.model.animals.Vaccine;
import farm.view.TheView;
import farm.view.animals.AddAnimalFrame;

/**
 * Cette classe va être responsable de la communication avec la fenêtre d'ajout d'animal ;
 * Elle va gérer les interactions et va s'assurer que tous les champs soient remplis et qu'ils
 * puissent être ressetés.
 * @author MConstantin
 */
public class AddAnimalController implements WindowListener {

    TheModel model;
    TheView view;
    TheController ctrl;
    AddAnimalFrame addAnimal;

    /**
     * @param model
     * @param view
     * @param ctrl
     */
    public AddAnimalController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;

        this.addAnimal = this.view.getAddAnimal();

    }

    public void setAddAnimal(AddAnimalFrame addAnimal) {
        this.addAnimal = addAnimal;
        this.goBackButtonController();
        this.addAnimal.addWindowListener(this);
        this.addAnimalButtonController();
        this.addTypeBoxController();
        this.resetDetailsAnimalButtonController();
    }

    private void goBackButtonController() {

        addAnimal.getHeader().getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(addAnimal, "Vous voulez retourner?", "Retour?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    addAnimal.dispose();
                    view.getAdminDash().setVisible(true);
                    view.getAdminDash().validate();
                    view.getAdminDash().repaint();

                }
            }

        });
    }

    private void resetDetailsAnimalButtonController() {

        addAnimal.getResetAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resetValues();

            }

        });
    }
    
    private void addAnimalButtonController() {

        addAnimal.getAddAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int t = addAnimal.getTypeField().getFieldOne().getSelectedIndex();
                int s = addAnimal.getSpecie().getFieldOne().getSelectedIndex();
                String n = addAnimal.getAddAnimalName().getTextField().getText();
                int difDates = addAnimal.getAddAnimalDayOfArrival().dateToInt() - addAnimal.getAddAnimalDayOfBirth().dateToInt();
                int g = addAnimal.getGender().getFieldOne().getSelectedIndex();
                int m = addAnimal.getMedication().getFieldOne().getSelectedIndex();
                int v = addAnimal.getVaccine().getFieldOne().getSelectedIndex();

                if (t == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "Le type doit etre selectionne!", "Quelque chose ne va pas!", JOptionPane.ERROR_MESSAGE);
                } else if (s == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "L'espece doit etre selectionnee!", "Quelque chose ne va pas!", JOptionPane.ERROR_MESSAGE);
                } else if (n.equals("")) {
                    JOptionPane.showMessageDialog(addAnimal, "Le nom doit etre remplis!", "Quelque chose ne va pas!", JOptionPane.ERROR_MESSAGE);
                } else if (difDates < 0) {
                    JOptionPane.showMessageDialog(addAnimal, "La date d'arrivage doit etre apres la date de naissence!", "Quelque chose ne va pas!", JOptionPane.ERROR_MESSAGE);
                } else if (g == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "Le genre doit etre selectionne!", "Quelque chose ne va pas!", JOptionPane.ERROR_MESSAGE);
                } else if (m == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "La premiere medication doit etre selectionnee", "Quelque chose ne va pas!", JOptionPane.ERROR_MESSAGE);
                } else if (v == -1) {
                    JOptionPane.showMessageDialog(addAnimal, "Le premier vaccin doit etre selectionne!", "Quelque chose ne va pas!", JOptionPane.ERROR_MESSAGE);
                } else {
                    addNewAnimal();
                    JOptionPane.showMessageDialog(addAnimal, "Animal ajoute a la base de donnees!", "Super!", JOptionPane.INFORMATION_MESSAGE);
                    resetValues();
                }

            }

        });
    }
    
    private void resetValues() {
        addAnimal.getTypeField().getFieldOne().setSelectedIndex(-1);
        addAnimal.getSpecie().getFieldOne().setSelectedIndex(-1);
        addAnimal.getAddAnimalName().getTextField().setText("");
        addAnimal.getAddAnimalDayOfArrival().setDate("25/08/2020");
        addAnimal.getAddAnimalDayOfBirth().setDate("25/08/2020");
        addAnimal.getGender().getFieldOne().setSelectedIndex(-1);
        addAnimal.getMedication().getFieldOne().setSelectedIndex(-1);
        addAnimal.getMedication().getFieldTwo().setSelectedIndex(-1);
        addAnimal.getMedication().getFieldThree().setSelectedIndex(-1);
        addAnimal.getVaccine().getFieldOne().setSelectedIndex(-1);
        addAnimal.getVaccine().getFieldTwo().setSelectedIndex(-1);
        addAnimal.getVaccine().getFieldThree().setSelectedIndex(-1);
        
        addAnimal.getExtraCharacteristics().removeAll();
        addAnimal.getExtraCharacteristics().updateUI();
    }    
    
    private void addNewAnimal() {
        String type = addAnimal.getTypeField().getFieldOne().getSelectedItem().toString();
        String specie = addAnimal.getSpecie().getFieldOne().getSelectedItem().toString();
        String name = addAnimal.getAddAnimalName().getTextField().getText();
        int gender = 0;
        if (addAnimal.getGender().getFieldOne().getSelectedItem().toString().equals("Male")) {
            gender = 1;
        }
        String dob = addAnimal.getAddAnimalDayOfBirth().dateToString();
        String doa = addAnimal.getAddAnimalDayOfArrival().dateToString();
        
        ArrayList<String> medNames = getMedication();
        Medication med = new Medication();
        med.addMedication(medNames);
        
        ArrayList<String> vacNames = getVaccination();
        Vaccine vac = new Vaccine();
        vac.addVaccine(vacNames);
        
        ArrayList<Integer> ext = getExtraCharacteristicas();
        
        Animal animal;
        
        switch (addAnimal.getTypeField().getFieldOne().getSelectedItem().toString()) {
            case "Aviaire":
                animal = new CreateAvian(specie, name, dob, doa, gender, med, vac);
                ((CreateAvian)animal).setCanFligh(ext.get(0));
                ((CreateAvian)animal).setHasFeeders(ext.get(1));
                model.getListAnimals().add(animal);
                break;
            case "Mamifere":
                animal = new CreateMammal(specie, name, dob, doa, gender, med, vac);
                ((CreateMammal)animal).setFurry(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            case "Reptile":
                animal = new CreateReptile(specie, name, dob, doa, gender, med, vac);
                ((CreateReptile)animal).isVennon(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            case "Mamifere Aquatique":
                animal = new CreateMammalAquatic(specie, name, dob, doa, gender, med, vac);
                ((CreateMammalAquatic)animal).setFurry(ext.get(0));
                ((CreateMammalAquatic)animal).canBeOutsideWatter(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            case "Reptile Aquatique":
                animal = new CreateReptileAquatic(specie, name, dob, doa, gender, med, vac);
                ((CreateReptileAquatic)animal).isVennon(ext.get(0));
                ((CreateReptileAquatic)animal).canBeOutsideWatter(ext.get(0));
                model.getListAnimals().add(animal);
                break;
            default:
                break;
        }
    }
    
    private ArrayList<Integer> getExtraCharacteristicas() {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (JCheckBox cb : addAnimal.getExtraCharacteristics().getGeneralFields()) {
            if (cb.isSelected()) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        
        return list;
    }
    
    private ArrayList<String> getMedication() {
        ArrayList<String> list = new ArrayList<>();
        list.add(addAnimal.getMedication().getFieldOne().getSelectedItem().toString());
        
        if (addAnimal.getMedication().getFieldTwo().getSelectedIndex() > -1) {
            list.add(addAnimal.getMedication().getFieldTwo().getSelectedItem().toString());
        }
        if (addAnimal.getMedication().getFieldThree().getSelectedIndex() > -1) {
            list.add(addAnimal.getMedication().getFieldThree().getSelectedItem().toString());
        }
        
        return list;
    }
    
    private ArrayList<String> getVaccination() {
        ArrayList<String> list = new ArrayList<>();
        list.add(addAnimal.getVaccine().getFieldOne().getSelectedItem().toString());
        
        if (addAnimal.getVaccine().getFieldTwo().getSelectedIndex() > -1) {
            list.add(addAnimal.getVaccine().getFieldTwo().getSelectedItem().toString());
        }
        if (addAnimal.getVaccine().getFieldThree().getSelectedIndex() > -1) {
            list.add(addAnimal.getVaccine().getFieldThree().getSelectedItem().toString());
        }
        
        return list;
    }

    private void addTypeBoxController() {

        addAnimal.getTypeField().getFieldOne().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (addAnimal.getTypeField().getFieldOne().getSelectedIndex() > -1) {
                    addAnimal.getSpecie().addFieldsToFieldOne(addAnimal.setSpeciesFields(addAnimal.getTypeField().getFieldOne().getSelectedItem().toString()));
                    addAnimal.getExtraCharacteristics().removeAll();
                    addAnimal.getExtraCharacteristics().updateUI();
                    extraCharacteristics();
                }
                
            }

        });
    }
    
    
    private void extraCharacteristics() {
        ArrayList<String> list = new ArrayList<>();
        
        switch (addAnimal.getTypeField().getFieldOne().getSelectedItem().toString()) {
            case "Aviaire":
                addAnimal.getExtraCharacteristics().setAmountOfFields(2);
                list.add("Vole");
                list.add("Plume");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Mamifere":
                addAnimal.getExtraCharacteristics().setAmountOfFields(1);
                list.add("Fourrure");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Reptile":
                addAnimal.getExtraCharacteristics().setAmountOfFields(1);
                list.add("Venimeux");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Mamifere aquatique":
                addAnimal.getExtraCharacteristics().setAmountOfFields(2);
                list.add("Fourrure");
                list.add("Amphibie");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            case "Reptile aquatique":
                addAnimal.getExtraCharacteristics().setAmountOfFields(2);
                list.add("Venimeux");
                list.add("Amphibie");
                addAnimal.getExtraCharacteristics().setFieldsCheckBoxes(list);
                break;
            default:
                break;
        }
        
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(addAnimal, "Vous voulez retourner?", "Retour?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            addAnimal.dispose();
            view.getAdminDash().setVisible(true);
            view.getAdminDash().validate();
            view.getAdminDash().repaint();

        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}

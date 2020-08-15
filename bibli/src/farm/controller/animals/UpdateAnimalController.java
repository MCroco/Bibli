package farm.controller.animals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import farm.controller.TheController;
import farm.model.TheModel;
import farm.model.animals.Animal;
import farm.model.animals.Medication;
import farm.model.animals.Vaccine;
import farm.view.TheView;
import farm.view.animals.UpdateAnimalFrame;

/**
 * Cette classes sert � gerer les r�ponses pour la fen�tre de Mise � jour Animal ;
 * La fen�tre apparait une fois que le bouton "MAJ" est appuy� sur la fen�tre qui affiche les animaux.
 * @author 
 */
public class UpdateAnimalController implements WindowListener {

    TheView view;
    UpdateAnimalFrame updateAnimal;
    ArrayList<Animal> animals;
    TheController ctrl;
    TheModel model;
    int index = 0;

    public UpdateAnimalController(TheModel model, TheView view, TheController ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        this.updateAnimal = view.getUpdateAnimal();
        this.animals = this.model.getListAnimals();

    }

    public void getIndexOfAnimal(int index) {
        this.index = index;
    }

    private void goBackButtonController() {

        updateAnimal.getHeader().getGoBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(updateAnimal, "Vous voulez retourner?", "Retour?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    updateAnimal.dispose();

                    view.getViewAnimals().setVisible(true);

                    view.getViewAnimals().getAnimalsPanel().removeAllRows();
                    ctrl.getViewAnimalsCtrl().resetAnimalDetails();

                    ctrl.getViewAnimalsCtrl().setAnimalsTable(animals);
                    ctrl.getViewAnimalsCtrl().viewAnimals.getAnimalsPanel().getViewAnimalsTable().setRowSelectionInterval(0, index);

                    ctrl.getViewAnimalsCtrl().setAnimalCard(index);
                    ctrl.getViewAnimalsCtrl().setOffspringsTable();
                }
            }

        });
    }

    private void addChild(String name, String dob, Medication med, Vaccine vac, String gender) {

        int gNum = 0;
        String[] types = null;
        for (int i = 0; i < animals.get(index).getClass().getInterfaces().length; i++) {
            if (i == 0) {
                types = new String[animals.get(index).getClass().getInterfaces().length];
            }
            types[i] = animals.get(index).getClass().getInterfaces()[i].getSimpleName();
        }
        if ("Male".equals(gender)) {
            gNum = 1;
        } else {
            gNum = 0;
        }

        animals.get(index).createOffpring(name, dob, dob, gNum, med, vac);
        int lastOff = animals.get(index).getOffsprings().size();
        animals.add(animals.get(index).getOffsprings().get(lastOff - 1));

    }

    private void addChildButtonController() {
        updateAnimal.getAddOffSpringsPanel().getAddOffspringButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = updateAnimal.getAddOffSpringsPanel().getAddOffspringName().getTextField().getText();
                String dob = updateAnimal.getAddOffSpringsPanel().getAddOffspringDayOfBirth().dateToString();
                int medIndex = updateAnimal.getAddOffSpringsPanel().getMedication().getFieldOne().getSelectedIndex();
                int vacIndex = updateAnimal.getAddOffSpringsPanel().getVaccine().getFieldOne().getSelectedIndex();
                int gIndex = updateAnimal.getAddOffSpringsPanel().getOffSpringGender().getFieldOne().getSelectedIndex();

                if (name.equals("")) {
                    JOptionPane.showMessageDialog(updateAnimal, "Le nom n'est pas choisi!", "Le nom!", JOptionPane.ERROR_MESSAGE);
                } else if (medIndex == -1) {
                    JOptionPane.showMessageDialog(updateAnimal, "Le medicament n'est pas choisi!", "Le medicament!", JOptionPane.ERROR_MESSAGE);
                } else if (vacIndex == -1) {
                    JOptionPane.showMessageDialog(updateAnimal, "Le vaccin n'est pas choisi!", "Le vaccin!", JOptionPane.ERROR_MESSAGE);
                } else if (gIndex == -1) {
                    JOptionPane.showMessageDialog(updateAnimal, "Le genre n'est pas choisi", "Le genre!", JOptionPane.ERROR_MESSAGE);
                } else {
                    Medication med = new Medication();
                    med.addMedication((String) updateAnimal.getAddOffSpringsPanel().getMedication().getFieldOne().getSelectedItem());
                    Vaccine vac = new Vaccine();
                    vac.addVacine((String) updateAnimal.getAddOffSpringsPanel().getVaccine().getFieldOne().getSelectedItem());
                    String g = (String) updateAnimal.getAddOffSpringsPanel().getOffSpringGender().getFieldOne().getSelectedItem();
                    addChild(name, dob, med, vac, g);
                    updateOffspringsTable();
                    JOptionPane.showMessageDialog(updateAnimal, "L'animal a un enfant!", "Super!", JOptionPane.INFORMATION_MESSAGE);

                }
            }

        });
    }

    private void updateOffspringsTable() {
        updateAnimal.getOffspringsPanel().removeAllRows();
        updateAnimal.getOffspringsPanel().dataToString(animals.get(index).getOffsprings());
        updateAnimal.getOffspringsPanel().setData();
        updateAnimal.getUpdateAnimalButton().setEnabled(true);

    }

    public void setUpdateAnimal(UpdateAnimalFrame updateAnimal) {
        this.updateAnimal = updateAnimal;
        this.updateAnimal.addWindowListener(this);
        this.goBackButtonController();
        this.addChildButtonController();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(this.view.getUpdateAnimal(), "Vous voulez retourner?", "Retour?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            updateAnimal.dispose();

            view.getViewAnimals().setVisible(true);

            view.getViewAnimals().getAnimalsPanel().removeAllRows();
            ctrl.getViewAnimalsCtrl().resetAnimalDetails();

            ctrl.getViewAnimalsCtrl().setAnimalsTable(animals);
            ctrl.getViewAnimalsCtrl().viewAnimals.getAnimalsPanel().getViewAnimalsTable().setRowSelectionInterval(0, index);

            ctrl.getViewAnimalsCtrl().setAnimalCard(index);
            ctrl.getViewAnimalsCtrl().setOffspringsTable();

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
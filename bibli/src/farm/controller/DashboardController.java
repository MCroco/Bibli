package farm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

import farm.controller.TheController;
import farm.model.TheModel;
import farm.view.Dashboard;
import farm.view.TheView;
import farm.view.animals.AddAnimalFrame;
import farm.view.animals.ViewAnimalsFrame;

/**
 * Cette classe est utilisée afin de travailler avec la fenêtre principale;
 * Cette fenêtre dit ce qui va se passer lorsque un des 2 boutons sont appuyés 
 * ou bien lorsque l'utilisateur veut fermer l'application 
 * @author MConstantin
 */
public class DashboardController implements WindowListener {

    TheController ctrl;
    TheView view;
    TheModel model;
    Dashboard adminDash;
    ViewAnimalsFrame viewAnimals;
    AddAnimalFrame addAnimal;


    public DashboardController(TheModel model, TheView view, TheController ctrl) {

        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        this.adminDash = view.getAdminDash();

        this.adminDash.addWindowListener(this);
        this.goBackButtonController();
        
        this.viewAnimalsButtonController();
        
        this.addAnimalsButtonController();


    }

    private void goBackButtonController() {

        adminDash.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(adminDash, "Vous voulez vous deconnecter?", "Deconnexion?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

                    adminDash.dispose();
                    model.serialization();

                }
            }

        });
    }
    

    private void addAnimalsButtonController() {

        adminDash.getAddAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimal = new AddAnimalFrame("Admin - Add Animal", 760, 350, "src/farm/view/images/animal.png");
                
                ctrl.getAddAnimalCtrl().setAddAnimal(addAnimal);
                view.setAddAnimal(addAnimal);
                
                adminDash.dispose();
                
                addAnimal.setVisible(true);
                addAnimal.validate();
                addAnimal.repaint();
            }

        });
    }

    private void viewAnimalsButtonController() {

        adminDash.getViewAnimalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAnimals = new ViewAnimalsFrame(adminDash.getView().getAnimals(), "Voir animaux", 975, 600, "src/farm/view/images/animal.png");
                
                ctrl.getViewAnimalsCtrl().setViewAnimals(viewAnimals);
                view.setViewAnimals(viewAnimals);
                
                adminDash.dispose();
                
                viewAnimals.setVisible(true);
                viewAnimals.validate();
                viewAnimals.repaint();
            }

        });
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(adminDash, "Vous voulez vous deconnecter?", "Deconnexion?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {

            
            adminDash.dispose();
            

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

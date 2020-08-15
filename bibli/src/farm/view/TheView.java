package farm.view;

import java.util.ArrayList;

import farm.model.TheModel;
import farm.model.animals.Animal;


/**
 * creating already some kind of structure
 */
import farm.view.animals.AddAnimalFrame;
import farm.view.animals.UpdateAnimalFrame;
import farm.view.animals.ViewAnimalsFrame;


/**
 *
 * @author MConstantin
 */
public class TheView {

    ViewAnimalsFrame viewAnimals;
    UpdateAnimalFrame updateAnimal;
    Dashboard adminDash;
    AddAnimalFrame addAnimal;


    ArrayList<Animal> animals;


    /**
     * @param model
     */
    public TheView(TheModel model) {

        this.animals = model.getListAnimals();


        this.adminDash = new Dashboard(this, "Fenetre principale", 340, 300, "src/farm/view/images/animal.png");

    }

    /**
     * @param addAnimal
     */
    public void setAddAnimal(AddAnimalFrame addAnimal) {
        this.addAnimal = addAnimal;
    }



    /**
     * @return
     */
    public AddAnimalFrame getAddAnimal() {
        return addAnimal;
    }

    /**
     * @return
     */
    public ViewAnimalsFrame getViewAnimals() {
        return viewAnimals;
    }

    /**
     * @param viewAnimals
     */
    public void setViewAnimals(ViewAnimalsFrame viewAnimals) {
        this.viewAnimals = viewAnimals;
    }

    /**
     * @param updateAnimal
     */
    public void setUpdateAnimal(UpdateAnimalFrame updateAnimal) {
        this.updateAnimal = updateAnimal;
    }

    /**
     * @return
     */
    public UpdateAnimalFrame getUpdateAnimal() {
        return updateAnimal;
    }

    /**
     * @return
     */
    public Dashboard getAdminDash() {
        return adminDash;
    }

    /**
     * @return
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * @param adminDash
     */
    public void setAdminDash(Dashboard adminDash) {
        this.adminDash = adminDash;
    }


}

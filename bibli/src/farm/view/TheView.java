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


    public TheView(TheModel model) {

        this.animals = model.getListAnimals();


        this.adminDash = new Dashboard(this, "Fenetre principale", 340, 300, "src/farm/view/images/animal.png");

    }

    public void setAddAnimal(AddAnimalFrame addAnimal) {
        this.addAnimal = addAnimal;
    }



    public AddAnimalFrame getAddAnimal() {
        return addAnimal;
    }

    public ViewAnimalsFrame getViewAnimals() {
        return viewAnimals;
    }

    public void setViewAnimals(ViewAnimalsFrame viewAnimals) {
        this.viewAnimals = viewAnimals;
    }

    public void setUpdateAnimal(UpdateAnimalFrame updateAnimal) {
        this.updateAnimal = updateAnimal;
    }

    public UpdateAnimalFrame getUpdateAnimal() {
        return updateAnimal;
    }

    public Dashboard getAdminDash() {
        return adminDash;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAdminDash(Dashboard adminDash) {
        this.adminDash = adminDash;
    }


}

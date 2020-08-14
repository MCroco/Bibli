package farm.controller;

import farm.controller.animals.AddAnimalController;
import farm.controller.animals.UpdateAnimalController;
import farm.controller.animals.ViewAnimalsController;
import farm.model.TheModel;
import farm.view.TheView;

/**
 * Cette classe a comme but de relier les autres classes "controller";
 * Elle fait cela en créant un objet pour chacune des classes.
 * @author MConstantin
 */

public class TheController {
    
    ViewAnimalsController viewAnimalsCtrl;
    UpdateAnimalController updateAnimalCtrl;
    DashboardController adminCtrl;
    AddAnimalController addAnimalCtrl;


    /**
     * @param model
     * @param view
     */
    public TheController(TheModel model, TheView view) {
        
        this.adminCtrl = new DashboardController(model, view, this);
        this.viewAnimalsCtrl = new ViewAnimalsController(model, view, this);
        this.updateAnimalCtrl = new UpdateAnimalController(model, view, this);
        this.addAnimalCtrl = new AddAnimalController(model, view, this);

    }

    /**
     * @return
     */
    public AddAnimalController getAddAnimalCtrl() {
        return addAnimalCtrl;
    }

    /**
     * @return
     */
    public ViewAnimalsController getViewAnimalsCtrl() {
        return viewAnimalsCtrl;
    }

    /**
     * @return
     */
    public UpdateAnimalController getUpdateAnimalCtrl() {
        return updateAnimalCtrl;
    }

    /**
     * @return
     */
    public DashboardController getAdminCtrl() {
        return adminCtrl;
    }

}

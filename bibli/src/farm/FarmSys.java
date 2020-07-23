package farm;


import farm.controller.TheController;
import farm.model.TheModel;
import farm.view.TheView;

/**
 *
 * @author MConstantin
 */
public class FarmSys {
    
    TheModel model;
    TheView view;
    TheController control;

    public FarmSys() {
        
        model = new TheModel();
        view = new TheView(model);
        control = new TheController(model, view);
        
    }
    
}

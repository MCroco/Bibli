
package farm;

import farm.controller.TheController;
import farm.model.TheModel;
import farm.view.TheView;

/**
 * 
 * C'est la classe Farm va permettre à l'application de démarrer,
 * car elle contient la "main".
 * @author MConstantin
 * @return nothing
 *
 */
public class Farm {

	/**
	 * Le main va relier les 3 grosses parties : model - view - controller
	 * 
	 * @param args 
	 */
    public static void main(String[] args) {
    	
        TheModel model;
        TheView view;
        TheController control;
        
        model = new TheModel();
        view = new TheView(model);
        control = new TheController(model, view);

    }

}

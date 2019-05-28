/**
 * @author MBQS
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import controller.Controller;
//import map.BoulderModel;
import view.View;

/**
 * The Class Main.
 *
 * @author MBQS
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
       
    	View view = new View();
    	//BoulderModel mod=new BoulderModel();

    	//mod.show();
    	//mod.play();
    	/*final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.control();
        controller.orderPerform(ControllerOrder.English);*/
    }
}

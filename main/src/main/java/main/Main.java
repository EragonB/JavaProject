/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import contract.ControllerOrder;
import controller.Controller;
import map.BoulderModel;
import model.DAOBoulderDash;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     */
    public static void main(final String[] args) throws SQLException {
        /*final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.control();
        controller.orderPerform(ControllerOrder.English);*/
    	BoulderModel model=new BoulderModel();
    	//model.play();
    	model.show();
    	/*DAOBoulderDash db = new DAOBoulderDash();
    	
    	ResultSet tab=db.find(2);
    	while(tab.next())
    	{
    		System.out.println(tab.getInt("Map_Height")+"      "+ tab.getInt("diamondsNeeded"));
    	}*/
    	
    	
    }
}

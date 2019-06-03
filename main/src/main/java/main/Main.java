package main;

import java.sql.SQLException;

import contract.IController;
import contract.IModel;
import contract.IView;
import controller.Controller;
import map.BoulderModel;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws SQLException the SQL exception
     */
    public static void main(final String[] args) throws SQLException {
 
    	IModel model=new BoulderModel();
    	  	
    	IView view = new View();

    	IController controller = new Controller(view, model);
    	
    	
    }
}

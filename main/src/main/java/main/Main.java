package main;

import java.sql.SQLException;

import contract.IController;
import contract.IModel;
import contract.IView;
import controller.Controller;
import map.BoulderModel;
import view.View;

public abstract class Main {

    public static void main(final String[] args) throws SQLException {
 
    	IModel model=new BoulderModel();
    	  	
    	IView view = new View();

    	IController controller = new Controller(view, model, 1);
    	
    	
    }
}

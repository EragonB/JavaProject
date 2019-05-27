package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.HelloWorld;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private HelloWorld helloWorld;

	public Model() {
		this.helloWorld = new HelloWorld();
	}

	
/*	private void setHelloWorld(final HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
		this.setChanged();
		this.notifyObservers();
	}*/


	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			//this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

}

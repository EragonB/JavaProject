/**
 * 
 */
package map;


import java.sql.SQLException;
import java.util.Observable;

import MotionlessElement.MotionlessElementFactory;
import contract.IMap;
import contract.IModel;
import contract.Permeability;




// TODO: Auto-generated Javadoc
/**
 * The Class BoulderModel.
 *
 * @author Bryan
 */
public class BoulderModel extends Observable implements IModel{
	
	/** The map. */
	private IMap map;
	
	/** The id map. */
	private int id_map=4;
	private Thread thread;
	/**
	 * Instantiates a new boulder model.
	 *
	 * @throws SQLException the SQL exception
	 */
	public BoulderModel() throws SQLException
	{
		this.map=new Map(this.id_map);
		this.thread=new Thread(this);
		this.thread.start();
		
		}
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

/**
 * Play.
 */

public  void play()
{
	
if(this.getMap().getMobile().getState()==this.getMap().getMobile().alive())
{
		
		this.getMap().setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(), this.getMap().getMobile().getLastPositionX(), this.getMap().getMobile().getLastPositionY());
		
		
		if(this.getMap().getOnTheMapXY(this.getMap().getMobile().getX(), this.getMap().getMobile().getY()).getPermeability()
				==Permeability.Creusable||
				this.getMap().getOnTheMapXY(this.getMap().getMobile().getX(), this.getMap().getMobile().getY()).getPermeability()
				==Permeability.Passable)
		{
			
			this.getMap().setOnTheMapXY(this.map.getMobile(), this.map.getMobile().getX(), this.map.getMobile().getY());
		//this.setNotifier();
		}
		else {
			this.map.getMobile().setXY(this.map.getMobile().getLastPositionX(),this.map.getMobile().getLastPositionY());
			
			
		}
	}
	else {
		
		System.out.println("Crash");
	}
	

	
}


public Observable getObservable()
{
	return this;
}

public void setNotifier()
{
	this.setChanged();
	this.notifyObservers();
}

@Override
public void run() {
	// TODO Auto-generated method stub
	while(true)
	{
		try {
			this.thread.sleep(20);
			this.setNotifier();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
}


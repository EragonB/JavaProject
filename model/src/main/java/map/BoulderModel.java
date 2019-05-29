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
import contract.State;




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
	private int id_map=1;
	private Thread thread, threadA;
	/**
	 * Instantiates a new boulder model.
	 *
	 * @throws SQLException the SQL exception
	 */
	
	public BoulderModel() throws SQLException
	{
		this.map=new Map(this.id_map);
		this.threadA = new Thread(this);
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
	
	if(this.getMap().getMobile().getState()==this.getMap().getMobile().alive() || this.getMap().getMobile().getState() != State.Finish)
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
		
		else if(this.getMap().getOnTheMapXY(this.getMap().getMobile().getX(), this.getMap().getMobile().getY()).getPermeability() == Permeability.Recover) 
		{
			this.getMap().setOnTheMapXY(this.map.getMobile(), this.map.getMobile().getX(), this.map.getMobile().getY());
			this.getMap().setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(), this.map.getMobile().getLastPositionX(), this.map.getMobile().getLastPositionY());
			
			this.map.setDiamPlayer(this.map.getDiamPlayer()+1);
			System.out.print(this.map.getDiamPlayer());
			
			if (this.map.getDiamPlayer() == this.map.getCompteDiamant()) {
				this.getMap().setOnTheMapXY(MotionlessElementFactory.createDoor(), this.map.getXYDoor(1), this.map.getXYDoor(2));
				System.out.print("CHOCOLAT");
			}
			
		}
		else if (this.getMap().getOnTheMapXY(this.getMap().getMobile().getX(), this.getMap().getMobile().getY()).getPermeability() == Permeability.Door)
		{
			this.getMap().getMobile().finish();
		}

		else if(this.getMap().getOnTheMapXY(this.getMap().getMobile().getX(), this.getMap().getMobile().getY()).getPermeability() == Permeability.Enemy){
			this.getMap().getMobile().die();
		}
		else {
			this.map.getMobile().setXY(this.map.getMobile().getLastPositionX(),this.map.getMobile().getLastPositionY());
			this.getMap().setOnTheMapXY(this.map.getMobile(), this.map.getMobile().getX(), this.map.getMobile().getY());
			
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
			this.map.updateRocher();
			this.map.updateDiamonds();
			this.thread.sleep(20);
			this.setNotifier();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
}


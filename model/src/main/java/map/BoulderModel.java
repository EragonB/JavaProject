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


/**
 * The Class BoulderModel.
 *
 * 
 */
public class BoulderModel extends Observable implements IModel{
	
	/** The map. */
	private IMap map;
	/** The id map. */
	private int id_map=1;
	
	/** The thread. */
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
	
	int MobileX = this.getMap().getMobile().getX();
	int MobileY = this.getMap().getMobile().getY();
	int MobileLastX =  this.getMap().getMobile().getLastPositionX();
	int MobileLastY =  this.getMap().getMobile().getLastPositionY();
	
	if(this.getMap().getMobile().getState()==this.getMap().getMobile().alive() && this.getMap().getMobile().getState() != State.Finish)
	{
		
		this.getMap().setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(), MobileLastX, MobileLastY);
		
		
		if(this.getMap().getOnTheMapXY(MobileX, MobileY).getPermeability() == Permeability.Creusable || this.getMap().getOnTheMapXY(MobileX, MobileY).getPermeability() == Permeability.Passable)
		{
			
			this.getMap().setOnTheMapXY(this.map.getMobile(), MobileX, MobileY);
		
		}
		
		else if(this.getMap().getOnTheMapXY(MobileX, MobileY).getPermeability() == Permeability.Recover) 
		{
			this.getMap().setOnTheMapXY(this.map.getMobile(), MobileX, MobileY);
			this.getMap().setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(), MobileLastX, MobileLastY);
			
			this.map.setDiamPlayer(this.map.getDiamPlayer()+1);
			this.map.DeleteDiamond();
			
			if (this.map.getDiamPlayer() == this.map.getAccountDiamond()) {
				this.getMap().setOnTheMapXY(MotionlessElementFactory.createDoor(), this.map.getXYDoor(1), this.map.getXYDoor(2));
			}
			
		}
		
		else if (this.getMap().getOnTheMapXY(MobileX, MobileY).getPermeability() == Permeability.Door)
		{
			this.getMap().getMobile().finish();
		}

		else if(this.getMap().getOnTheMapXY(MobileX, MobileY).getPermeability() == Permeability.Enemy)
		{
			this.getMap().getMobile().die();
		}
		else if(this.getMap().getOnTheMapXY(MobileX, MobileY).getPermeability() == Permeability.Push)
		{
			if(this.getMap().getMobile().getSprite() == 'K')
			{
				if (this.getMap().getOnTheMapXY(this.getMap().getMobile().getX()-1, this.getMap().getMobile().getY()).getPermeability() == Permeability.Passable)
				{
					this.getMap().setTab(this.getMap().getMobile().getX(), this.getMap().getMobile().getY(), -1);
					this.getMap().setOnTheMapXY(this.map.getMobile(), MobileX, MobileY);
					
				}
				else
				{
					this.map.getMobile().setXY(MobileLastX,MobileLastY);
					this.getMap().setOnTheMapXY(this.map.getMobile(), this.getMap().getMobile().getX(), this.getMap().getMobile().getY());	
				}
				
			}
			else if(this.getMap().getMobile().getSprite() == 'M')
			{
				if (this.getMap().getOnTheMapXY(this.getMap().getMobile().getX()+1, this.getMap().getMobile().getY()).getPermeability() == Permeability.Passable)
				{
					this.getMap().setTab(this.getMap().getMobile().getX(), this.getMap().getMobile().getY(), 1);
					this.getMap().setOnTheMapXY(this.map.getMobile(), MobileX, MobileY);
					
				}
				else
				{
					this.map.getMobile().setXY(MobileLastX,MobileLastY);
					this.getMap().setOnTheMapXY(this.map.getMobile(), this.getMap().getMobile().getX(), this.getMap().getMobile().getY());	
				}
				
			}
			else 
			{
				this.map.getMobile().setXY(MobileLastX,MobileLastY);
				this.getMap().setOnTheMapXY(this.map.getMobile(), this.getMap().getMobile().getX(), this.getMap().getMobile().getY());	
			}
		}
		else {

			this.map.getMobile().setXY(MobileLastX,MobileLastY);
			this.getMap().setOnTheMapXY(this.map.getMobile(), this.getMap().getMobile().getX(), this.getMap().getMobile().getY());			
		}
	}
	else if (this.getMap().getMobile().getState() == State.Finish)
	{
		System.out.println("WIN !!!");
	}

	

		
	}
	
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	public Observable getObservable()
	{
		return this;
	}
	
	/**
	 * Sets the notifier.
	 */
	public void setNotifier()
	{
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Run.
	 */
	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(50);
				this.setNotifier();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}


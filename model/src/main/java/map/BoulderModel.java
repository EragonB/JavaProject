/**
 * 
 */
package map;


import java.sql.SQLException;
import java.util.Observable;

import contract.IMap;
import contract.IModel;



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
	
	/**
	 * Instantiates a new boulder model.
	 *
	 * @throws SQLException the SQL exception
	 */
	public BoulderModel() throws SQLException
	{
		this.map=new Map(this.id_map);
		
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
public void play()
{
this.map.getMobile().moveLeft();

this.getMap().setOnTheMapXY(this.map.getMobile(), this.map.getMobile().getX(), this.map.getMobile().getY());

this.setChanged();
this.notifyObservers();
}

/**
 * Show.
 */
public void show()
{
	for (int y = 0; y < this.map.getHeight(); y++) {
        for (int x = 0; x < this.map.getWidth(); x++) {

                System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite());
            }
        System.out.println("");
        }
        
        
    }

public Observable getObservable()
{
	return this;
}
}


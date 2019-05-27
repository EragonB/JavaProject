/**
 * 
 */
package map;


import java.sql.SQLException;

import Mobile.*;



// TODO: Auto-generated Javadoc
/**
 * The Class BoulderModel.
 *
 * @author Bryan
 */
public class BoulderModel {
	
	/** The map. */
	private IMap map;
	
	/** The id map. */
	private int id_map=1;
	
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
//this.mobile.getMovement().moveLeft();	
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
}


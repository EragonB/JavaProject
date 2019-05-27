/**
 * 
 */
package map;


import java.sql.SQLException;

import Mobile.*;



/**
 * @author Bryan
 *
 */
public class BoulderModel {
	
	private IMap map;
	/*private final int MAP_HEIGHT=9;
	private final int MAP_WIDTH=5;*/
	private Mobile mobile=new Enemy();
	private int id_map=2;
	
	public BoulderModel() throws SQLException
	{
		
		
		this.map=new Map(this.id_map);
		this.mobile.setX(this.map.getWidth()/2);
		this.mobile.setY(0);
		this.getMap().setOnTheMapXY(this.mobile, this.mobile.getX(), this.mobile.getY());
	}
	
	public IMap getMap() {
		return this.map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

public void play()
{
this.mobile.getMovement().moveLeft();	
}

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


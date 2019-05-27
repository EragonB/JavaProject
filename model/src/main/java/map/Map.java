/**
 * 
 */
package map;


import java.sql.ResultSet;
import java.sql.SQLException;

import Element.IElement;
import MotionlessElement.MotionlessElementFactory;
import model.DAOBoulderDash;

/**
 * @author Bryan
 *
 */
public class Map implements IMap {
	
	private int height;
	private int width;
	private IElement[][] onTheMap;
	private DAOBoulderDash daoboulderdash;
	private ResultSet resultset=null;

	public Map(int id_map) throws SQLException {
		// TODO Auto-generated constructor stub
		
		this.daoboulderdash=new DAOBoulderDash();
		this.resultset=this.daoboulderdash.find(id_map);
		while(this.resultset.next())
		{
			this.height=this.resultset.getInt("Map_Height");
			this.width=this.resultset.getInt("Map_Width");
		}
		
		this.onTheMap= new IElement[this.height][this.width];
		this.fillonTheMap();
	}

	private void fillonTheMap() {
		// TODO Auto-generated method stub
		for(int y=0; y < getHeight(); y++){
			
			
			for(int x=0; x < getWidth(); x++){
				
					if ((x==0) || (x==getWidth()-1)) {							// A test to know if one is on the edge to put a ditch or not //
					this.setOnTheMapXY(MotionlessElementFactory.createWall(), x, y);			// We put a ditch on this road //
	// An obstacle is placed on the road //
				}
					else{
					
					this.setOnTheMapXY(MotionlessElementFactory.createDirt(), x, y);	// We just put macadam on the road //
				}
			}
		}
	}

	
	public int getHeight() {
		return height;
	}

	
	public void setHeight(int height) {
		this.height = height;
	}

	
	public int getWidth() {
		return this.width;
	}

	
	public void setWidth(int width) {
		this.width = width;
	}

	
	public IElement getOnTheMapXY(int x, int y) {
		return this.onTheMap[y][x];
	}

	
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[y][x] = element;
	}
	
	

}

/**
 * 
 */
package map;


import java.sql.ResultSet;
import java.sql.SQLException;

import MotionlessElement.MotionlessElementFactory;
import contract.IElement;
import contract.IMap;
import model.DAOBoulderDash;
import Mobile.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Map.
 *
 * @author Bryan
 */
public class Map implements IMap {
	
	/** The height. */
	private int height;
	
	/** The width. */
	private int width;
	
	/** The on the map. */
	private IElement[][] onTheMap;
	
	/** The daoboulderdash. */
	private DAOBoulderDash daoboulderdash;
	
	/** The resultset. */
	private ResultSet resultset=null;

	
	/** The mobile. */
	private Mobile mobile=new Gugus();
	
	/**
	 * Instantiates a new map.
	 *
	 * @param id_map the id map
	 * @throws SQLException the SQL exception
	 */
	public Map(int id_map) throws SQLException {
		// TODO Auto-generated constructor stub
		
		this.daoboulderdash=new DAOBoulderDash();
		this.resultset=this.daoboulderdash.findMap(id_map);
		while(this.resultset.next())
		{
			this.height=this.resultset.getInt("Map_Height");
			this.width=this.resultset.getInt("Map_Width");
			this.mobile.setX(this.resultset.getInt("startX"));
			this.mobile.setY(this.resultset.getInt("startY"));
		}
		
		this.onTheMap= new IElement[this.height][this.width];
		this.fillonTheMap(id_map);
		
		
		this.setOnTheMapXY(this.mobile, this.mobile.getX(), this.mobile.getY());
		
	}

	/**
	 * Fill on the map.
	 * @throws SQLException 
	 */
	private void fillonTheMap(int id_map) throws SQLException {
		
		for(int y=0; y < getHeight(); y++){
			
			
			for(int x=0; x < this.getWidth(); x++){
				
					if ((x==0) || (x==this.getWidth()-1)||y==this.getHeight()-1 || y==0) {	// A test to know if one is on the edge to put a ditch or not //
					this.setOnTheMapXY(MotionlessElementFactory.createWall(), x, y);			
	// An obstacle is placed on the road //
				}
					else{
					
					this.setOnTheMapXY(MotionlessElementFactory.createDirt(), x, y);	
				}
			}
		}
		this.setElement(id_map);
		
	}

	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return this.width;
	}

	
	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	
	/**
	 * Gets the on the map XY.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the on the map XY
	 */
	public IElement getOnTheMapXY(int x, int y) {
		return this.onTheMap[y][x];
	}

	
	/**
	 * Sets the on the map XY.
	 *
	 * @param element the element
	 * @param x the x
	 * @param y the y
	 */
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[y][x] = element;
	}
	
	
	public void setElement(int id_map) throws SQLException
	{
		this.resultset=this.daoboulderdash.findElement(id_map);
		while(this.resultset.next())
		{
			switch(this.resultset.getInt("NBR"))
			{
			
			case 1:
				this.setOnTheMapXY(new Diamond(), this.resultset.getInt("X"), this.resultset.getInt("Y"));
				break;
				
			case 2:
				this.setOnTheMapXY(new Stone(), this.resultset.getInt("X"), this.resultset.getInt("Y"));
				break;
				
			case 3:
				this.setOnTheMapXY(MotionlessElementFactory.createWall(), this.resultset.getInt("X"), this.resultset.getInt("Y"));
				break;
				
			case 4:
				this.setOnTheMapXY(new Enemy(), this.resultset.getInt("X"), this.resultset.getInt("Y"));
				break;
				
			case 5:
				this.setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(), this.resultset.getInt("X"), this.resultset.getInt("Y"));
				break;
			}
		}
	}

	public DAOBoulderDash getDaoboulderdash() {
		return daoboulderdash;
	}

	public void setDaoboulderdash(DAOBoulderDash daoboulderdash) {
		this.daoboulderdash = daoboulderdash;
	}

	public ResultSet getResultset() {
		return resultset;
	}

	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

}

/**
 * 
 */
package map;


import java.sql.ResultSet;
import java.sql.SQLException;

import MotionlessElement.MotionlessElementFactory;
import contract.IElement;
import contract.IMap;
import contract.IMobile;
import contract.Permeability;
import model.DAOBoulderDash;
import Mobile.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Map.
 *
 * @author Bryan
 */
public class Map implements IMap{
	
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

	private ResultSet results=null;
	
	/** The mobile. */
	private IMobile mobile=new Gugus();

	
	int vaTab = 13;
	int Tab[][] = new int[vaTab][4];
	int valA = 0, XI = 0;
	Stone2[] ArrayObject = new Stone2[vaTab];
	
	public void updateRocher()
	{
		for(int a = 0; a < vaTab; a++) {
			
			if(getOnTheMapXY(ArrayObject[a].getX(), ArrayObject[a].getY()+1).getPermeability() == Permeability.Passable) 
			{
				char compar = getOnTheMapXY(ArrayObject[a].getX(), ArrayObject[a].getY()+1).getSprite();
				
				if(compar == ' ') 
				{
					ArrayObject[a].setLastPositionX(ArrayObject[a].getX(), ArrayObject[a].getY());
					ArrayObject[a].setXY(ArrayObject[a].getX(), (ArrayObject[a].getY()+1));
					
					setOnTheMapXY(ArrayObject[a],ArrayObject[a].getX(), ArrayObject[a].getY());
					setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(),ArrayObject[a].getLastPositionX(), ArrayObject[a].getLastPositionY());
				}
				
				else if (compar == 'O' || compar == 'L' || compar == 'K' || compar == 'M') 
				{
					//mobile.die();
				}
				
			}
			
			else {
				
				
			}
		}
	}
	
	
	
	public void setPosMapElement(int id) throws SQLException {

		this.results = this.daoboulderdash.FindComplete(id);
		while(this.results.next())
		{
			Tab[valA][0] = this.results.getInt("Id_Map");
			Tab[valA][1] = this.results.getInt("id_Rock");
			Tab[valA][2] = this.results.getInt("X");
			Tab[valA][3] = this.results.getInt("Y");
			valA++;
		}
	}
	
	public void setRock() {
		for(int a = 0; a< vaTab; a++)
		{
			ArrayObject[a] = new Stone2(Tab[a][2], Tab[a][3]);
		}
	}
	
	/**
	 * Instantiates a new map.
	 *
	 * @param id_map the id map
	 * @throws SQLException the SQL exception
	 */
	public Map(int id_map) throws SQLException {
		// TODO Auto-generated constructor stub
		
		this.daoboulderdash=new DAOBoulderDash();
		setPosMapElement(4);
		setRock();
		this.resultset=this.daoboulderdash.findMap(id_map);
		
		while(this.resultset.next())
		{
			this.height=this.resultset.getInt("Map_Height");
			this.width=this.resultset.getInt("Map_Width");
			this.mobile.setXY(this.resultset.getInt("startX"), this.resultset.getInt("startY"));

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
		//this.set
		
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
			int x=this.resultset.getInt("X");
			int y=this.resultset.getInt("Y");
			switch(this.resultset.getInt("NBR"))
			{
			
			case 1:
				this.setOnTheMapXY(new Diamond(), x, y);
				break;
				
			case 2:
				this.setOnTheMapXY(ArrayObject[XI], ArrayObject[XI].getX(), ArrayObject[XI].getY());
				XI ++;
				break;
				
			
			case 3:
				this.setOnTheMapXY(MotionlessElementFactory.createWall(), x, y);
				break;
				
			case 4:
				this.setOnTheMapXY(new Enemy(), x, y);
				break;
				
			case 5:
				this.setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(), x, y);
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

	public IMobile getMobile() {
		return mobile;
	}

	public void setMobile(IMobile mobile) {
		this.mobile = mobile;
	}

public void resetXY()
{
System.out.println("Je suis un giezfhz");
}

@Override
public void run() {
	
	this.resetXY();
	
}

}

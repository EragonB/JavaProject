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

	
	int NombreDeCaouille = 13, NbxDiamonds = 13 , valA = 0, valB = 0, XI = 0, XV = 0;
	
	int TabRock[][] = new int[NombreDeCaouille]	[4];
	int TabDiam[][] = new int[NbxDiamonds]		[4];
	Stone2[] ArrayObject = new Stone2[NombreDeCaouille];
	Diamond2[] ArrayDiamond = new Diamond2[NbxDiamonds];
	
	public void updateRocher()
	{
		for(int a = 0; a < NombreDeCaouille; a++) {
			
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
		}
	}
	
	public void updateDiamonds()
	{
		for(int a = 0; a < NbxDiamonds; a++) {
			
			if(getOnTheMapXY(ArrayDiamond[a].getX(), ArrayDiamond[a].getY()+1).getPermeability() == Permeability.Passable) 
			{
				char compar = getOnTheMapXY(ArrayDiamond[a].getX(), ArrayDiamond[a].getY()+1).getSprite();
				
				if(compar == ' ') 
				{
					ArrayDiamond[a].setLastPositionX(ArrayDiamond[a].getX(), ArrayDiamond[a].getY());
					ArrayDiamond[a].setXY(ArrayDiamond[a].getX(), (ArrayDiamond[a].getY()+1));
					
					setOnTheMapXY(ArrayDiamond[a],ArrayDiamond[a].getX(), ArrayDiamond[a].getY());
					setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(),ArrayDiamond[a].getLastPositionX(), ArrayDiamond[a].getLastPositionY());
				}
				
				else if (compar == 'O' || compar == 'L' || compar == 'K' || compar == 'M') 
				{
					//mobile.die();
				}
				
			}
		}
	}
	
	
	
	public void setPosMapElement(int id) throws SQLException {

		this.results = this.daoboulderdash.FindMobileRock(id);
		while(this.results.next())
		{
			TabRock[valA][0] = this.results.getInt("Id_Map");
			TabRock[valA][1] = this.results.getInt("id_Rock");
			TabRock[valA][2] = this.results.getInt("X");
			TabRock[valA][3] = this.results.getInt("Y");
			valA++;
		}
		
		this.results = this.daoboulderdash.FindDiamond(id);
		while(this.results.next())
		{
			TabDiam[valB][0] = this.results.getInt("Id_Map");
			TabDiam[valB][1] = this.results.getInt("Id_diamond");
			TabDiam[valB][2] = this.results.getInt("X");
			TabDiam[valB][3] = this.results.getInt("Y");
			valB++;
		}
	}
	
	public void setMobileObject() {
		for(int a = 0; a< NombreDeCaouille; a++)
		{
			ArrayObject[a] = new Stone2(TabRock[a][2], TabRock[a][3]);
		}
		for(int a = 0; a< NbxDiamonds; a++)
		{
			ArrayDiamond[a] = new Diamond2(TabDiam[a][2], TabDiam[a][3]);
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
		setMobileObject();
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
				this.setOnTheMapXY(ArrayDiamond[XV], ArrayDiamond[XV].getX(), ArrayDiamond[XV].getY());
				XV ++;
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

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
	

	Thread thread;
	
	/** The mobile. */
	private IMobile mobile=new Gugus();
	

	private int CompteDiamant = 0;
	private int DiamPlayer = 0;

	private int XDoor = 0;
	private int YDoor = 0;
	
	int SizeElement = 60;
	int SizeColumnElement = 0;
	int XI 		= 0, XV 	= 0, XII 	= 0;
	
	int TabRock[][] 		= new int		[SizeElement]	[3];
	int TabDiam[][] 		= new int		[SizeElement]	[3];
	int TabEnem[][]			= new int 		[SizeElement] 	[3];
	Stone[] ArrayObject 	= new Stone		[SizeElement];
	Diamond[] ArrayDiamond 	= new Diamond	[SizeElement];
	Enemy[] ArrayEnemy 		= new Enemy		[SizeElement];


	/**
	 * Instantiates a new map.
	 *
	 * @param id_map the id map
	 * @throws SQLException the SQL exception
	 */
	public Map(int id_map) throws SQLException {
		// TODO Auto-generated constructor stub
		
		this.daoboulderdash=new DAOBoulderDash();
		setPosMapElement(id_map);
		
		
		this.resultset=this.daoboulderdash.findMap(id_map);
		
		while(this.resultset.next())
		{
			this.height=this.resultset.getInt("Map_Height");
			this.width=this.resultset.getInt("Map_Width");
			this.mobile.setXY(this.resultset.getInt("startX"), this.resultset.getInt("startY"));
			this.CompteDiamant = this.resultset.getInt("diamondsNeeded");
			this.XDoor = this.resultset.getInt("doorX");
			this.YDoor = this.resultset.getInt("doorY");

		}
		
		this.onTheMap= new IElement[this.height][this.width];
		this.fillonTheMap(id_map);
		this.setOnTheMapXY(this.mobile, this.mobile.getX(), this.mobile.getY());
		thread = new Thread(this);
		this.thread.start();
		
		
	}

	public void updateRocher()
	{
		//TODO
		for(int a = 0; a < SizeElement; a++) {
			
			char compar = getOnTheMapXY(ArrayObject[a].getX(), ArrayObject[a].getY()+1).getSprite();
			
			Permeability perma = getOnTheMapXY(ArrayObject[a].getX(), ArrayObject[a].getY()+1).getPermeability();
			
			if(perma == Permeability.Passable) 
			{
				
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
			
			else if (perma == Permeability.Enemy)
			{
				
				ArrayObject[a].setLastPositionX(ArrayObject[a].getX(), ArrayObject[a].getY());
				ArrayObject[a].setXY(ArrayObject[a].getX(), (ArrayObject[a].getY()+1));
				
				setOnTheMapXY(ArrayObject[a],ArrayObject[a].getX(), ArrayObject[a].getY());
				this.ArrayDiamond[40] = new Diamond(ArrayObject[a].getLastPositionX(), ArrayObject[a].getLastPositionY());
				setOnTheMapXY(this.ArrayDiamond[40],ArrayObject[a].getLastPositionX(), ArrayObject[a].getLastPositionY());
			}
		}
	}

	public void updateDiamonds()
	{
		//TODO
		for(int a = 0; a < SizeElement; a++) {
			
			
			
			if(getOnTheMapXY(ArrayDiamond[a].getX(), ArrayDiamond[a].getY()+1).getPermeability() == Permeability.Passable ) 
			{
				
				char compar = getOnTheMapXY(ArrayDiamond[a].getX(), ArrayDiamond[a].getY()+1).getSprite();
				char comparA = getOnTheMapXY(ArrayDiamond[a].getX(), ArrayDiamond[a].getY()+2).getSprite();
				
				if(comparA == MotionlessElementFactory.createBackgroundvoid().getSprite() || compar != this.mobile.getSprite() || comparA ==  MotionlessElementFactory.createDirt().getSprite() || comparA == MotionlessElementFactory.createWall().getSprite()) 
				{
					if (compar != this.mobile.getSprite())
					{
						DeletDiamond();
						ArrayDiamond[a].setLastPositionX(ArrayDiamond[a].getX(), ArrayDiamond[a].getY());
						ArrayDiamond[a].setXY(ArrayDiamond[a].getX(), (ArrayDiamond[a].getY()+1));
						
						setOnTheMapXY(ArrayDiamond[a],ArrayDiamond[a].getX(), ArrayDiamond[a].getY());
						setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(),ArrayDiamond[a].getLastPositionX(), ArrayDiamond[a].getLastPositionY());
						
					}
					
				}
				
				else if (compar == 'O' || compar == 'L' || compar == 'K' || compar == 'M') 
				{
					
					mobile.die();
				}
				
			}
		}
	}
	
	public void DeletDiamond()
	{
		for(int a=0; a < SizeElement; a++)
		{
			if (ArrayDiamond[a].getX() == this.mobile.getX() && ArrayDiamond[a].getY() == this.mobile.getY())
			{
				ArrayDiamond[a].setXY(0, 0);
			}
		}
	}
	
	public void updateEnemy()
	{
		//TODO
		/*for(int a = 0; a < SizeElement; a++)
		{
			boolean down, up, left, right;
			
			if(getOnTheMapXY(ArrayEnemy[a].getX(), ArrayEnemy[a].getY()+1).getPermeability() == Permeability.Passable)
			{
				down = true;
			}
			if(getOnTheMapXY(ArrayEnemy[a].getX(), ArrayEnemy[a].getY()-1).getPermeability() == Permeability.Passable)
			{
				up = true;
			}
			if(getOnTheMapXY(ArrayEnemy[a].getX(), ArrayEnemy[a].getX()-1).getPermeability() == Permeability.Passable)
			{
				left = true;
			}
			if(getOnTheMapXY(ArrayEnemy[a].getX(), ArrayEnemy[a].getX()+1).getPermeability() == Permeability.Passable)
			{
				right = true;
			}
			
			switch((int)(Math.random() * 4))
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}*/
	}
	
	public void setTab(int X, int Y)
	{
		for(int a=0; a < SizeElement; a++)
		{
			if (ArrayObject[a].getX() == X && ArrayObject[a].getY() == Y)
			{
				ArrayObject[a].setXY(ArrayObject[a].getX()+1, ArrayObject[a].getY());
			}
		}
		
	}

	public int getXYDoor(int value)
	{
		switch(value) 
		{
		case 1:
			return this.XDoor;
		case 2:
			return this.YDoor;
		default:
			return 0;
		}
	}
	
	public void RemplirTableau(ResultSet Function, int tab[][], String Column) throws SQLException
	{
		//TODO Changer de Nom
		this.results = Function;
		while(this.results.next())
		{
			tab[SizeColumnElement][0] = this.results.getInt(Column);
			tab[SizeColumnElement][1] = this.results.getInt("X");
			tab[SizeColumnElement][2] = this.results.getInt("Y");
			SizeColumnElement++;
			
		}
		SizeColumnElement = 0;
	}

	public void setPosMapElement(int id) throws SQLException {

		RemplirTableau(this.daoboulderdash.FindMobileRock(id), TabRock, "id_Rock");
		RemplirTableau(this.daoboulderdash.FindEnemy(id), TabEnem, "id_monster");
		RemplirTableau(this.daoboulderdash.FindDiamond(id), TabDiam, "Id_diamond");
		
		
		for(int a = 0; a< SizeElement; a++)
		{
			this.ArrayObject[a] = new Stone(TabRock[a][1], TabRock[a][2]);
		}
		for(int a = 0; a< SizeElement; a++)
		{
			this.ArrayDiamond[a] = new Diamond(TabDiam[a][1], TabDiam[a][2]);
		}
		
		for(int a = 0; a< SizeElement; a++)
		{
			this.ArrayEnemy[a] = new Enemy(TabEnem[a][1], TabEnem[a][2]);
		}
	}

	public int getCompteDiamant()
	{
		return this.CompteDiamant;
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

	public void setDiamPlayer(int value)
	{
		this.DiamPlayer = value;
	}
	
	public int getDiamPlayer()
	{
		return DiamPlayer;
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
				this.setOnTheMapXY(ArrayEnemy[XII], ArrayEnemy[XII].getX(), ArrayEnemy[XII].getY());
				XII++;
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
		return this.resultset;
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
	
	public void updateObject()
	{
		this.thread.start();
	}
	
	@Override
	public void run() {
		//TODO Erreur Plosible
		try {
			updateRocher();
			//updateDiamonds();
			this.thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}



}

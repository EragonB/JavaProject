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
import contract.State;
import model.DAOBoulderDash;
import Mobile.*;


/**
 * The Class Map.
 *
 * 
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

	/** The results. */
	private ResultSet results=null;
	
	/** The thread. */
	Thread thread;
	
	/** The mobile. */
	private IMobile mobile=new Gugus();
	
	/** The Compte diamant. */
	private int AccountDiamond = 0;
	
	/** The Diam player. */
	private int DiamPlayer = 0;

	/** The X door. */
	private int XDoor = 0;
	
	/** The Y door. */
	private int YDoor = 0;
	
	/** The Size element. */
	int SizeElement = 60;
	
	/** The Size column element. */
	int SizeColumnElement = 0;
	
	/** The xii. */
	int XI 		= 0, XV 	= 0, XII 	= 0;
	
	/** The Tab rock. */
	int TabRock[][] 			= new int		[SizeElement]	[3];
	
	
	int TabDiamond[][] 			= new int		[SizeElement]	[3];
	
	
	int TabEnemy[][]				= new int 		[SizeElement] 	[3];
	
	/** The Array object. */
	Stone[] 	ArrayStone		= new Stone		[SizeElement];
	
	/** The Array diamond. */
	Diamond[] 	ArrayDiamond 	= new Diamond	[SizeElement];
	
	/** The Array enemy. */
	Enemy[] 	ArrayEnemy 		= new Enemy		[SizeElement];


	/**
	 * Instantiates a new map.
	 *
	 * @param id_map the id map
	 * @throws SQLException the SQL exception
	 */
	public Map(int id_map) throws SQLException {
		
		
		this.daoboulderdash=new DAOBoulderDash();
		setPosMapElement(id_map);
		
		
		this.resultset=this.daoboulderdash.findMap(id_map);
		
		while(this.resultset.next())
		{
			this.height=this.resultset.getInt("Map_Height");
			this.width=this.resultset.getInt("Map_Width");
			this.mobile.setXY(this.resultset.getInt("startX"), this.resultset.getInt("startY"));
			this.AccountDiamond = this.resultset.getInt("diamondsNeeded");
			this.XDoor = this.resultset.getInt("doorX");
			this.YDoor = this.resultset.getInt("doorY");

		}
		
		this.onTheMap= new IElement[this.height][this.width];
		this.fillonTheMap(id_map);
		this.setOnTheMapXY(this.mobile, this.mobile.getX(), this.mobile.getY());
		thread = new Thread(this);
		this.thread.start();
		
		
	}

	/**
	 * Update Rock.
	 */
	public void updateRock()
	{
		if (this.mobile.getState() == State.Life)
		{
			for (int a = 0; a < SizeElement; a++)
			{
				char comparative = getOnTheMapXY(ArrayStone[a].getX(), ArrayStone[a].getY()+1).getSprite();
				
				if (comparative == MotionlessElementFactory.createBackgroundvoid().getSprite())
				{
					ArrayStone[a].setStrengh(ArrayStone[a].getStrengh()+1);
					ArrayStone[a].setLastPositionX(ArrayStone[a].getX(), ArrayStone[a].getY());
					ArrayStone[a].setXY(ArrayStone[a].getX(), (ArrayStone[a].getY()+1));
					setOnTheMapXY(ArrayStone[a],ArrayStone[a].getX(), ArrayStone[a].getY());
					setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(),ArrayStone[a].getLastPositionX(), ArrayStone[a].getLastPositionY());
					
				}
				
				else if (comparative == this.mobile.getSprite())
				{
					if(ArrayStone[a].getStrengh() > 0)
					{
						mobile.die();
					}
				}
				
				else if (getOnTheMapXY(ArrayStone[a].getX(), ArrayStone[a].getY()+1).getPermeability() == Permeability.Enemy)
				{
					
					ArrayStone[a].setLastPositionX(ArrayStone[a].getX(), ArrayStone[a].getY());
					ArrayStone[a].setXY(ArrayStone[a].getX(), (ArrayStone[a].getY()+1));
					
					setOnTheMapXY(ArrayStone[a],ArrayStone[a].getX(), ArrayStone[a].getY());
					this.ArrayDiamond[40] = new Diamond(ArrayStone[a].getLastPositionX(), ArrayStone[a].getLastPositionY());
					setOnTheMapXY(this.ArrayDiamond[40],ArrayStone[a].getLastPositionX(), ArrayStone[a].getLastPositionY());
				}
				else
				{
					ArrayStone[a].setStrengh(0);
				}
			}
		}
	}

	/**
	 * Update diamonds.
	 */
	public void updateDiamonds()
	{
		if (this.mobile.getState() == State.Life)
		{
			for (int a = 0; a < SizeElement; a++)
			{
				char comparative = getOnTheMapXY(ArrayDiamond[a].getX(), ArrayDiamond[a].getY()+1).getSprite();
				
				if (comparative == MotionlessElementFactory.createBackgroundvoid().getSprite())
				{
					ArrayDiamond[a].setStrengh(ArrayDiamond[a].getStrengh()+1);
					ArrayDiamond[a].setLastPositionX(ArrayDiamond[a].getX(), ArrayDiamond[a].getY());
					ArrayDiamond[a].setXY(ArrayDiamond[a].getX(), (ArrayDiamond[a].getY()+1));
					setOnTheMapXY(ArrayDiamond[a],ArrayDiamond[a].getX(), ArrayDiamond[a].getY());
					setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(),ArrayDiamond[a].getLastPositionX(), ArrayDiamond[a].getLastPositionY());
					
				}
				
				else if (comparative == this.mobile.getSprite())
				{
					if(ArrayDiamond[a].getStrengh() > 0)
					{
						mobile.die();
					}
					else 
					{
						DeleteDiamond();
					}
				}
				else
				{
					ArrayDiamond[a].setStrengh(0);
				}
			}

		}
	}
	
	/**
	 * Delete diamond.
	 */
	public void DeleteDiamond()
	{
		for(int a=0; a < SizeElement; a++)
		{
			if (ArrayDiamond[a].getX() == this.mobile.getX() && ArrayDiamond[a].getY() == this.mobile.getY())
			{
				ArrayDiamond[a].setXY(0, 0);
			}
		}
	}

	
	/**
	 * Sets the tab.
	 *
	 * @param X the x
	 * @param Y the y
	 * @param Pos the pos
	 */
	public void setTab(int X, int Y, int Pos)
	{
		for(int a=0; a < SizeElement; a++)
		{
			if (ArrayStone[a].getX() == X && ArrayStone[a].getY() == Y)
			{
				ArrayStone[a].setXY(ArrayStone[a].getX()+Pos, ArrayStone[a].getY());
				setOnTheMapXY(ArrayStone[a], ArrayStone[a].getX(), ArrayStone[a].getY());
			}
		}
		
	}

	/**
	 * Gets the XY door.
	 *
	 * @param value the value
	 * @return the XY door
	 */
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
	

	public void FillInTable(ResultSet Function, int board[][], String Column) throws SQLException
	{
		
		this.results = Function;
		while(this.results.next())
		{
			board[SizeColumnElement][0] = this.results.getInt(Column);
			board[SizeColumnElement][1] = this.results.getInt("X");
			board[SizeColumnElement][2] = this.results.getInt("Y");
			SizeColumnElement++;
			
		}
		SizeColumnElement = 0;
	}

	/**
	 * Sets the pos map element.
	 *
	 * @param id the new pos map element
	 * @throws SQLException the SQL exception
	 */
	public void setPosMapElement(int id) throws SQLException {

		FillInTable(this.daoboulderdash.FindMobileRock(id), TabRock, "id_Rock");
		FillInTable(this.daoboulderdash.FindEnemy(id), TabEnemy, "id_monster");
		FillInTable(this.daoboulderdash.FindDiamond(id), TabDiamond, "Id_diamond");
		
		
		for(int a = 0; a< SizeElement; a++)
		{
			this.ArrayStone[a] = new Stone(TabRock[a][1], TabRock[a][2]);
		}
		for(int a = 0; a< SizeElement; a++)
		{
			this.ArrayDiamond[a] = new Diamond(TabDiamond[a][1], TabDiamond[a][2]);
		}
		
		for(int a = 0; a< SizeElement; a++)
		{
			this.ArrayEnemy[a] = new Enemy(TabEnemy[a][1], TabEnemy[a][2]);
		}
	}


	public int getAccountDiamond()
	{
		return this.AccountDiamond;
	}
	
	/**
	 * Fill on the map.
	 *
	 * @param id_map the id map
	 * @throws SQLException the SQL exception
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
	 * Sets the diam player.
	 *
	 * @param value the new diam player
	 */
	public void setDiamPlayer(int value)
	{
		this.DiamPlayer = value;
	}
	
	/**
	 * Gets the diam player.
	 *
	 * @return the diam player
	 */
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
	
	
	/**
	 * Sets the element.
	 *
	 * @param id_map the new element
	 * @throws SQLException the SQL exception
	 */
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
				this.setOnTheMapXY(ArrayStone[XI], ArrayStone[XI].getX(), ArrayStone[XI].getY());
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

	/**
	 * Gets the daoboulderdash.
	 *
	 * @return the daoboulderdash
	 */
	public DAOBoulderDash getDaoboulderdash() {
		return daoboulderdash;
	}

	/**
	 * Sets the daoboulderdash.
	 *
	 * @param daoboulderdash the new daoboulderdash
	 */
	public void setDaoboulderdash(DAOBoulderDash daoboulderdash) {
		this.daoboulderdash = daoboulderdash;
	}

	/**
	 * Gets the resultset.
	 *
	 * @return the resultset
	 */
	public ResultSet getResultset() {
		return this.resultset;
	}

	/**
	 * Sets the resultset.
	 *
	 * @param resultset the new resultset
	 */
	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public IMobile getMobile() {
		return mobile;
	}

	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(IMobile mobile) {
		this.mobile = mobile;
	}
	

	/**
	 * Run.
	 */
	@Override
	public void run() {
		
		while(true)
		{
			try {
				updateDiamonds();
				updateRock();
				Thread.sleep(400);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		
	}


}

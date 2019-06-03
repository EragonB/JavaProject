package map;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Mobile.Diamond;
import Mobile.Enemy;
import Mobile.Gugus;
import Mobile.Mobile;
import Mobile.Stone;
import MotionlessElement.Dirt;
import MotionlessElement.MotionlessElementFactory;
import contract.IElement;
import contract.IMobile;
import contract.Permeability;
import model.DAOBoulderDash;

public class MapTest {
	
	int ObjectPosY = 0 , ObjectPosX = 0, Strengh = 0, SizeElement = 6, alive = 1;
	
    IMobile Player = new Gugus();
	Diamond [] ArrayDiamond = new Diamond[SizeElement];
	Stone [] ArrayRock = new Stone[SizeElement];
	
	private Map map = null;


	@Before
	public void setUp() throws Exception {
		this.map = new Map(1);
		ArrayRock[0] = new Stone(1, 2);
		ArrayDiamond[0] = new Diamond (1, 2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdateRock() {
		
		if (alive == 1)
		{
			
			if (this.map.getOnTheMapXY(ObjectPosX, ObjectPosY + 1).getSprite() == MotionlessElementFactory.createBackgroundvoid().getSprite()) 
			{
				Strengh++;
				ObjectPosY = ObjectPosY + 1;
			}
			
			else if (this.map.getOnTheMapXY(ObjectPosX, ObjectPosY + 1).getSprite() == Player.getSprite())
			{
				if (Strengh > 0)
				{
					alive = 0;
				}
			}
			
			else if (this.map.getOnTheMapXY(ObjectPosX, ObjectPosY + 1).getPermeability() == Permeability.Enemy)
			{
				ArrayRock[0].setXY(ArrayRock[0].getX(), ArrayRock[0].getY() + 1);
				ArrayDiamond[0] = new Diamond(ArrayRock[0].getX(), ArrayRock[0].getY() - 1);
			}
			
			else 
			{
				Strengh = 0;
			}
			
		}
		assertEquals(alive, 1);
	}

	@Test
	public void testUpdateDiamonds() {
		Player.setXY(ArrayDiamond[0].getX(), ArrayDiamond[0].getY() + 1);
		
		if (alive == 1)
		{
			
			if (this.map.getOnTheMapXY(ArrayDiamond[0].getX(), ArrayDiamond[0].getY() + 1).getSprite() == MotionlessElementFactory.createBackgroundvoid().getSprite()) 
			{
				ArrayDiamond[0].setStrengh(ArrayDiamond[0].getStrengh() + 1);
				ArrayDiamond[0].setXY(ArrayDiamond[0].getX(), ArrayDiamond[0].getY() + 1);
			}
			
			else if (this.map.getOnTheMapXY(ArrayDiamond[0].getX(), ArrayDiamond[0].getY() + 1).getSprite() == Player.getSprite())
			{
				if (ArrayDiamond[0].getStrengh() < 0)
				{
					alive = 0;
				}
				else {
					
					this.map.DeleteDiamond();					
				}
			}
			
			
			else 
			{
				ArrayDiamond[0].setStrengh(0);
				
			}
			
		}
		assertEquals(alive, 1);
	}

	@Test
	public void testDeleteDiamond() {
		Player.setXY(1, 2);
		
					if (ArrayDiamond[0].getX() == Player.getX() && ArrayDiamond[0].getY() == Player.getY())
			{
				ArrayDiamond[0].setXY(0, 0);
			}
					assertEquals(ArrayDiamond[0].getX(), 0);
		}
	


	@Test
	public void testSetTab() {
	    int X = 1;
	    int Y = 2;
	    int value = 1;
	    if (ArrayRock[0].getX() == X && ArrayRock[0].getY() == Y) {
	    	
	    	ArrayRock[0].setXY(ArrayRock[0].getX() + value, ArrayRock[0].getY());
	    }
	    assertEquals(ArrayRock[0].getX(), X + 1);
	}

	@Test
	public void testGetXYDoor() {
		assertNotNull(this.map.getXYDoor(0));
	}

	@Test
	public void testGetAccountDiamond() {
		assertNotNull(this.map.getAccountDiamond());
	}

	@Test
	public void testSetDiamPlayer() {
		int diam2 = 5;
		this.map.setDiamPlayer(diam2);
		assertEquals(diam2, this.map.getDiamPlayer());
	}

	@Test
	public void testGetDiamPlayer() {
		assertNotNull(this.map.getDiamPlayer());
	}

	@Test
	public void testGetHeight() {
		assertNotNull(this.map.getHeight());
	}

	@Test
	public void testSetHeight() {
		int height2 = 15;
		this.map.setHeight(height2);
		assertEquals(height2, this.map.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertNotNull(this.map.getWidth());
	}

	@Test
	public void testSetWidth() {
			int width2 = 10;
			this.map.setWidth(width2);
			assertEquals(width2, this.map.getWidth());

	}

	@Test
	public void testGetOnTheMapXY() {
		assertNotNull(this.map.getOnTheMapXY(2, 2));

	}

	@Test
	public void testSetOnTheMapXY() {
		IElement element2 = new Dirt();
		this.map.setOnTheMapXY(element2, 2, 2);
		assertEquals(element2, this.map.getOnTheMapXY(2, 2));
	}

	@Test
	public void testSetElement() {
		int varswitch = 4;
		int X = 2;
		int Y = 3;
		IMobile enemy = new Enemy(X, Y);
		switch(varswitch) {
		
		case 1 : 
			this.map.setOnTheMapXY(ArrayDiamond[0], ArrayDiamond[0].getX(), ArrayDiamond[0].getY());
			break;
			
		case 2 :
			this.map.setOnTheMapXY(ArrayRock[0], ArrayRock[0].getX(), ArrayRock[0].getY());
			break;
			
		case 3 :
			this.map.setOnTheMapXY(MotionlessElementFactory.createWall(), X, Y);
			break;
			
		case 4 : 
			this.map.setOnTheMapXY(enemy, X, Y);
			break;
			
		case 5 :
			this.map.setOnTheMapXY(MotionlessElementFactory.createBackgroundvoid(), X, Y);
			break;
		}
		assertEquals(enemy, this.map.getOnTheMapXY(X, Y));
	}

	@Test
	public void testGetDaoboulderdash() {
		assertNotNull(this.map.getDaoboulderdash());
	}

	@Test
	public void testSetDaoboulderdash() {
		DAOBoulderDash B2 = new DAOBoulderDash();
		this.map.setDaoboulderdash(B2);
		assertEquals(B2, this.map.getDaoboulderdash());
	}

	@Test
	public void testGetResultset() {
		assertNotNull(this.map.getResultset());
	}

	@Test
	public void testSetResultset() {
		ResultSet set2 = new DAOBoulderDash().findMap(1);
		this.map.setResultset(set2);
		assertEquals(set2, this.map.getResultset());
	}

	@Test
	public void testGetMobile() {
		assertNotNull(this.map.getMobile());
	}

	@Test
	public void testSetMobile() {
		IMobile mobile2 = new Mobile(Permeability.Passable, 'O') {
		};
		this.map.setMobile(mobile2);
		assertEquals(mobile2, this.map.getMobile());
	}

}
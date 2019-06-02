package map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {

	int ObjectPosY = 0 , Strengh = 0, player = 2, voidD = 3, alive = 1, SizeElement = 6;
	int PlayerX = 0 , PlayerY = 0;
	int[][] ArrayDiamand = new int[SizeElement][2];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdateDiamonds() {

		if (alive == 1)
		{
			
			if (ObjectPosY + 1 == voidD) 
			{
				Strengh++;
				ObjectPosY = ObjectPosY + 1;
			}
			
			else if (ObjectPosY + 1 == player)
			{
				if (Strengh > 0)
				{
					alive = 0;
				}
				else
				{
					testDeleteDiamond();
				}
			}
			
			else 
			{
				Strengh = 0;
			}
		}

		
	}

	@Test
	public void testDeleteDiamond() {
		for(int a = 0; a < SizeElement; a++)
		{
			if (ArrayDiamand[a][0] == PlayerX && ArrayDiamand[a][1] == PlayerY)
			{
				ArrayDiamand[a][0] = 0;
				ArrayDiamand[a][1] = 0;
			}
		}
	}

}

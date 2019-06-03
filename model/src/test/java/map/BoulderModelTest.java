package map;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.IMap;

public class BoulderModelTest {
	private BoulderModel model = null;
	private IMap map = null;

	@Before
	public void setUp() throws Exception {
		this.model = new BoulderModel();
		this.map = new Map(2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBoulderModel() {
		assertNotNull(this.model);
	}

	@Test
	public void testGetMap() {
		assertNotNull(this.model.getMap());
	}

	@Test
	public void testSetMap() throws SQLException {
		Map map2 = new Map(2);
		this.model.setMap(map2);
		assertEquals(map2, this.model.getMap());
	}



}
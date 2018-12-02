import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConwayTest {
	private Conway obj;
	@BeforeEach
	void setUp() throws Exception {
		obj = new Conway();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void createBoard()
	{
		int[][] alive = {{0,0}, {1,1}};
		obj.createBoard(alive);
		for(int[] coor : alive)
			assertTrue(obj.isAlive(coor[0], coor[1]));
		assertFalse(obj.isAlive(0, 1));
	}
	@Test
	void getNeighbors () {
		int[][] gameBoard = {{0,0}, {0,1}, {0,2}};
		obj.createBoard(gameBoard);
		List<Conway.Coordinate> res = obj.getNeighbors(0,1);
		assertEquals(res.size(), 2);	
	}
	
	@Test
	void isStillAlive() {
		int[][] gameBoard = {{0,0}, {0,1}, {0,2}};
		
	}

	
}

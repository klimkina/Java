import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class BoardTest extends TestCase{
	Board board;
	
	@BeforeEach
	void setup() {
		board = new Board();
		
	}
	void init() {
		Cell cell = new Cell(0, 0, "Red");
		board.addCell(cell);
		Cell cell2 = new Cell(0, 1, "Red");
		board.addCell(cell2);
		
	}
	@Test
	void testDead() {
		assertEquals(board.isAlive(0,0), false);
	}
	
	@Test
	void testAlive() {
		Cell cell = new Cell(0, 0, "Red");
		board.addCell(cell);
		assertEquals(board.isAlive(0,0), true);
	}
	
	@Test
	void testCellStatus() {
		Rule rule = new Rule();
		init();
		Cell cell = new Cell(1, 0, "Red");
		assertEquals(rule.nextState(cell, board.getNeighbors(cell)), null);
	}
	
	@Test
	void testGetNeighbors() {
		init();
		Cell cell = new Cell(1, 0, "Red");
		assertEquals(board.getNeighbors(cell), null);
	}
}
	


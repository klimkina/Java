import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTests {
    private Board board;
    private final int[][] puzzle04 = {
            {0, 1, 3},
            {4, 2, 5},
            {7, 8, 6}
        };
    private final int[][] goal = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
        };
    private String strPuzzle04 = "3\r\n 0  1  3\r\n 4  2  5\r\n 7  8  6\r\n";
    @Test
    public void testBoardInit() {
        
        board = new Board (puzzle04);
        String str = board.toString();
        assertEquals(str, strPuzzle04);
    }

    @Test
    public void testDimension() {
        
        board = new Board (puzzle04);
        assertEquals(board.dimension(), 3);
    }
    
    @Test
    public void testHamming() {
        board = new Board (puzzle04);
        assertEquals(board.hamming(), 4);
    }
    
    @Test
    public void testManhattan() {
        int[][] manhattan = {
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}
            };
        board = new Board (manhattan);
        assertEquals(board.manhattan(), 10);
        assertEquals(board.hamming(), 5);
        board = new Board (puzzle04);
        assertEquals(board.manhattan(), 4);
    }

    @Test
    public void testIsGoal() {
        board = new Board (puzzle04);
        assertFalse(board.isGoal());
        board = new Board (goal);
        assertTrue(board.isGoal());
    }

    @Test
    public void testTwin() {
        board = new Board (puzzle04);
        int[][] twin = {
                {0, 1, 3},
                {4, 2, 5},
                {7, 6, 8}
            };
        Board twinBoard = new Board(twin);
        assertTrue(board.twin().equals(twinBoard));
    }

    @Test
    public void testEqualsObject() {
        board = new Board (puzzle04);
        String str = board.toString();
        assertEquals(str, strPuzzle04);
    }

    @Test
    public void testNeighbors() {
        board = new Board (puzzle04);
        int[][] puzzle04_left = {
                {1, 0, 3},
                {4, 2, 5},
                {7, 8, 6}
            };
        int[][] puzzle04_top = {
                {4, 1, 3},
                {0, 2, 5},
                {7, 8, 6}
            };
        Board left = new Board(puzzle04_left);
        Board top = new Board(puzzle04_top);
        for (Board neighbor : board.neighbors())
            assertTrue(neighbor.equals(left) || neighbor.equals(top));
    }

    @Test
    public void testToString() {
        board = new Board (puzzle04);
        String str = board.toString();
        assertEquals(str, strPuzzle04);
    }
}

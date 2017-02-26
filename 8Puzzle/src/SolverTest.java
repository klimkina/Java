import static org.junit.Assert.*;

import org.junit.Test;

public class SolverTest {
    private Solver testSolver;
    @Test (expected = java.lang.NullPointerException.class)
    public void testSolverNullArgument() {
        new Solver(null);
    }

    @Test
    public void testIsSolvable() {
        int[][] puzzle04 = {
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
            };
        testSolver = new Solver(new Board(puzzle04));
        assertTrue(testSolver.isSolvable());
        Solver unsolvable = new Solver(new Board(puzzle04).twin());
        assertFalse(unsolvable.isSolvable());
    } 
    
    @Test
    public void testUnSolvable() {
        int[][] puzzle_unsolvable = {
                {1,  2,  3},
                {4,  5,  6},
                {8,  7,  0}
        };
        Solver unsolvable = new Solver (new Board(puzzle_unsolvable));
        assertFalse(unsolvable.isSolvable());
        int[][] puzzle_unsolvable2 = {
                {0,1},
                {2,3}
        };
        unsolvable = new Solver (new Board(puzzle_unsolvable2));
        assertFalse(unsolvable.isSolvable());
        int[][] puzzle_unsolvable3 = {
                {8,  6,  7},
                {2,  5,  4},
                {1,  3,  0}
                };
        unsolvable = new Solver (new Board(puzzle_unsolvable3));
        assertFalse(unsolvable.isSolvable());
    }

    @Test
    public void testMoves() {
        int[][] puzzle04 = {
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
            };
        testSolver = new Solver(new Board(puzzle04));
        assertEquals(testSolver.moves(), 4);
    }

    @Test
    public void testSolution() {
        int[][] puzzle04 = {
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
        };
        Board[] boards = new Board[5];
        int[][] puzzle04_1st_move = {
                {0,  1,  3 },
                {4,  2,  5 },
                {7,  8,  6}
        };
        int[][] puzzle04_2nd_move = {
                {1,  0,  3 },
                {4,  2,  5 },
                {7,  8,  6}
        }; 

        int[][] puzzle04_3rd_move = {
                {1,  2,  3 },
                {4,  0,  5 },
            {7,  8,  6}
        }; 

        int[][] puzzle04_4th_move = {
                {1,  2,  3}, 
                {4,  5,  0   },
            {7,  8,  6 }
        };

        int[][] puzzle04_5th_move = {
                {1,  2,  3 },
                {4,  5,  6 },
                {7,  8,  0}
        };
        boards[0] = new Board (puzzle04_1st_move);
        boards[1] = new Board (puzzle04_2nd_move);
        boards[2] = new Board (puzzle04_3rd_move);
        boards[3] = new Board (puzzle04_4th_move);
        boards[4] = new Board (puzzle04_5th_move);
        testSolver = new Solver(new Board(puzzle04));
        int i = 0;
        for (Board board : testSolver.solution())
            assertEquals(boards[i++], board);
    }

}

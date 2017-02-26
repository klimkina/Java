import static org.junit.Assert.*;
import org.junit.Test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BoggleSolverTest {

    @Test
    public void testBoggleSolver() {
        In in = new In("boggle\\dictionary-algs4.txt");
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard("boggle\\board4x4.txt");
        int score = 0;
        for (String word : solver.getAllValidWords(board)) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
        assertEquals(score, 33);
    }

    @Test
    public void testGetAllValidWords() {
        In in = new In("boggle\\dictionary-algs4.txt");
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard("boggle\\board-q.txt");
        int score = 0;
        for (String word : solver.getAllValidWords(board)) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
        assertEquals(score, 84);
    }

    @Test
    public void testScoreOf() {
        In in = new In("boggle\\dictionary-algs4.txt");
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard("boggle\\board-dodo.txt");
        int score = 0;
        for (String word : solver.getAllValidWords(board)) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }
/*
    @Test
    public void testAdj() {
        fail("Not yet implemented");
    }
*/
}

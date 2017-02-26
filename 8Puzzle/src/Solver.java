/******************************************************************************
 *  Compilation:  javac Solver.java
 *
 *  Liudmila Klimkina 11/26/2016
 *
 ******************************************************************************/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;
import java.util.LinkedList;

public class Solver {
    private LinkedList<Board> solution = null;
    private int cube = 0;

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private SearchNode prev;
        private int moves;
                
        public SearchNode(Board b, SearchNode p, int m) {
            board = b;
            prev = p;
            moves = m;
        }            
        public int compareTo(SearchNode that) {
            if (this.board.manhattan() + this.moves < that.board.manhattan() + that.moves) return -1;
            if (this.board.manhattan() + this.moves > that.board.manhattan() + that.moves) return +1;
            if (this.board.hamming() + this.moves < that.board.hamming() + that.moves) return -1;
            if (this.board.hamming() + this.moves > that.board.hamming() + that.moves) return +1;
            return 0;
        }    
    }
    
    public Solver(Board initial) {           // find a solution to the initial board (using the A* algorithm)
        if (initial == null)
            throw new java.lang.NullPointerException();
        
        Board mainBoard = initial;
        Board twinBoard = initial.twin();
        int moves = 0;
        cube = mainBoard.dimension() * mainBoard.dimension();
        cube *= cube * cube;
        MinPQ<SearchNode> res = new MinPQ<SearchNode>();
        MinPQ<SearchNode> twin = new MinPQ<SearchNode>();
        
        res.insert(new SearchNode(mainBoard, null, 0));
        twin.insert(new SearchNode(twinBoard, null, 0));
        while (!res.min().board.isGoal() && !twin.min().board.isGoal()) {
            moves++;
            if (moves > cube)
                return;
            SearchNode mainNode = res.delMin();
            SearchNode twinNode = twin.delMin();
            for (Board board : mainNode.board.neighbors())
                if (mainNode.prev == null || !board.equals(mainNode.prev.board))
                    res.insert(new SearchNode(board, mainNode, moves));
            for (Board board : twinNode.board.neighbors())
                if (twinNode.prev == null || !board.equals(twinNode.prev.board))
                    twin.insert(new SearchNode(board, twinNode, moves));              
        }
        if (res.min().board.isGoal()) {
            solution = new LinkedList<Board>();
            SearchNode node = res.delMin();
            while (node != null) {
                solution.addFirst(node.board);
                node = node.prev;
            } 
        }            
    }
    public boolean isSolvable() {            // is the initial board solvable?
        return (solution != null && solution.size() > 0);
    }
    public int moves() {                     // min number of moves to solve initial board; -1 if unsolvable
        if (solution == null)
            return -1;
        return solution.size() - 1;
    }
    public Iterable<Board> solution() {      // sequence of boards in a shortest solution; null if unsolvable
        return solution;
    }    
    public static void main(String[] args) { // solve a slider puzzle (given below)
     // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
            }
        
    }
}
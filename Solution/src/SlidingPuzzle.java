import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingPuzzle {
	private static  class Board {
	    private int[][] myBlocks;
	    private int posX;
	    private int posY;
	    
	    public Board(int[][] blocks) {          // (blocks[i][j] = block in row i, column j)
	        if (blocks == null || blocks.length == 0)
	            throw new java.lang.NullPointerException();
	        
	        myBlocks = new int[blocks.length][blocks[0].length];
	        for (int i = 0; i < blocks.length; i++)
	            for (int j = 0; j < blocks[0].length; j++) {
	                this.myBlocks[i][j] = blocks[i][j];
	                if (blocks[i][j] == 0) {
	                    posX = i;
	                    posY = j;
	                }
	            }
	    }
	    
	    public int hamming() {                  // number of blocks out of place
	        int out = 0;
	        for (int i = 0; i < myBlocks.length; i++)
	            for (int j = 0; j < myBlocks[0].length; j++)
	                if (this.myBlocks[i][j] != 0 && this.myBlocks[i][j] != i * myBlocks[0].length + j + 1)
	                    out++;
	        return out;
	    }
	    
	    public int manhattan() {                // sum of Manhattan distances between blocks and goal
	        int out = 0;
	        for (int i = 0; i < myBlocks.length; i++)
	            for (int j = 0; j < myBlocks[0].length; j++)
	                if (this.myBlocks[i][j] != 0)
	                    out += Math.abs((this.myBlocks[i][j] - 1) / myBlocks.length - i) 
	                        + Math.abs((this.myBlocks[i][j] - 1) % myBlocks[0].length - j);
	        return out;
	    }
	      
	    public boolean isGoal() {               // is this board the goal board?
	        return hamming() == 0;
	    }
	    
	    public Board twin() {                   // a board that is obtained by exchanging any pair of blocks
	        Board twin = new Board(myBlocks);
	        if (myBlocks.length < 2)
	            return twin;
	        if (myBlocks[myBlocks.length - 1][myBlocks[0].length - 1] != 0 && 
	        		myBlocks[myBlocks.length - 1][myBlocks[0].length - 2] != 0)
	            twin.exch(myBlocks.length - 1, myBlocks[0].length - 2, myBlocks.length - 1, myBlocks[0].length - 1);
	        else if (myBlocks.length == 2)
	            twin.exch(0, 0, 0, 1);
	        else if (myBlocks[myBlocks.length - 1][myBlocks[0].length - 1] == 0)
	            twin.exch(myBlocks.length - 1, myBlocks[0].length - 2, myBlocks.length - 1, myBlocks[0].length - 3);
	        else
	            twin.exch(myBlocks.length - 1, myBlocks[0].length - 1, myBlocks.length - 1, myBlocks[0].length - 3);
	        return twin;
	    }
	    
	    public boolean equals(Object y) {       // does this board equal y?
	        if (y == null)
	            return false;
	        return this.toString().equals(y.toString());
	    }
	    
	    public Iterable<Board> neighbors() {    // all neighboring boards
	        ArrayList<Board> res = new ArrayList<Board>();
	        if (posX > 0) {
	            Board top = new Board(myBlocks);
	            top.exch(posX, posY, posX - 1, posY);
	            res.add(top);
	        }
	        if (posX < myBlocks.length - 1) {
	            Board bottom = new Board(myBlocks);
	            bottom.exch(posX, posY, posX + 1, posY);
	            res.add(bottom);
	        }
	        if (posY > 0) {
	            Board left = new Board(myBlocks);
	            left.exch(posX, posY, posX, posY - 1);
	            res.add(left);
	        }
	        if (posY < myBlocks[0].length - 1) {
	            Board right = new Board(myBlocks);
	            right.exch(posX, posY, posX, posY + 1);
	            res.add(right);
	        }
	        return res;
	    }
	    
	    public String toString() {              // string representation of this board (in the output format specified below)
	        StringBuilder sb = new StringBuilder();
	        sb.append(myBlocks.length + " " + myBlocks[0].length);
	        sb.append(System.lineSeparator());
	        for (int i = 0; i < myBlocks.length; i++) {
	            for (int j = 0; j < myBlocks[0].length; j++) {
	                sb.append(String.format("%2d", myBlocks[i][j]));
	                 if (j < myBlocks[0].length - 1)
	                    sb.append(" ");
	            }
	            sb.append(System.lineSeparator());
	        }
	        return sb.toString();
	    }
	        
	    private void exch(int i, int j, int newI, int newJ)
	    {
	        int temp = myBlocks[i][j];
	        myBlocks[i][j] = myBlocks[newI][newJ];
	        myBlocks[newI][newJ] = temp;
	        if (myBlocks[i][j] == 0) {
	            posX = i;
	            posY = j;
	        }
	        else if (myBlocks[newI][newJ] == 0) {
	            posX = newI;
	            posY = newJ;
	        }
	    }
	}
	private LinkedList<Board> solution = null;
    private int cube = 0;

    private class SearchNode implements Comparable<SearchNode> {
        private Board node_board;
        private SearchNode prev;
        private int moves;
                
        public SearchNode(Board b, SearchNode p, int m) {
            node_board = b;
            prev = p;
            moves = m;
        }            
        public int compareTo(SearchNode that) {
            if (this.node_board.manhattan() + this.moves < that.node_board.manhattan() + that.moves) return -1;
            if (this.node_board.manhattan() + this.moves > that.node_board.manhattan() + that.moves) return +1;
            if (this.node_board.hamming() + this.moves < that.node_board.hamming() + that.moves) return -1;
            if (this.node_board.hamming() + this.moves > that.node_board.hamming() + that.moves) return +1;
            return 0;
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
    
	public int slidingPuzzle(int[][] board) {           // find a solution to the initial board (using the A* algorithm)
        Board mainBoard = new Board(board);
        Board twinBoard = mainBoard.twin();
        int moves = 0;
        cube = board.length + board[0].length;
        cube *= cube * cube;
        cube *= cube * cube;
        PriorityQueue<SearchNode> res = new PriorityQueue<SearchNode>();
        PriorityQueue<SearchNode> twin = new PriorityQueue<SearchNode>();
        
        res.offer(new SearchNode(mainBoard, null, 0));
        twin.offer(new SearchNode(twinBoard, null, 0));
        while (!res.peek().node_board.isGoal() && !twin.peek().node_board.isGoal()) {
            moves++;
            if (moves > cube)
                return -1;
            SearchNode mainNode = res.poll();
            SearchNode twinNode = twin.poll();
            for (Board b : mainNode.node_board.neighbors())
                if (mainNode.prev == null || !board.equals(mainNode.prev.node_board))
                    res.offer(new SearchNode(b, mainNode, moves));
            for (Board b : twinNode.node_board.neighbors())
                if (twinNode.prev == null || !board.equals(twinNode.prev.node_board))
                    twin.offer(new SearchNode(b, twinNode, moves));              
        }
        if (res.peek().node_board.isGoal()) {
        	solution = new LinkedList<Board>();
        	SearchNode node = res.poll();
        	while (node != null) {
                solution.addFirst(node.node_board);
                node = node.prev;
            }
        	return solution.size()-1;
        }
            
		return -1;
    	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{1,2,3},{5,4,0}};
		SlidingPuzzle obj = new SlidingPuzzle();
		System.out.println(obj.slidingPuzzle(board));
	}

}

/******************************************************************************
 *  Compilation:  javac Board.java
 *
 *  Liudmila Klimkina 11/26/2016
 *
 ******************************************************************************/
import java.util.ArrayList;

public class Board {
    private int[][] myBlocks;
    private int size;
    private int posX;
    private int posY;
    
    public Board(int[][] blocks) {          // construct a board from an n-by-n array of blocks
                                            // (where blocks[i][j] = block in row i, column j)
        if (blocks == null || blocks.length == 0)
            throw new java.lang.NullPointerException();
        size = blocks[0].length;   
        myBlocks = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                this.myBlocks[i][j] = blocks[i][j];
                if (blocks[i][j] == 0) {
                    posX = i;
                    posY = j;
                }
            }
    }
        
    public int dimension() {                // board dimension n
        return size;
    }
    
    public int hamming() {                  // number of blocks out of place
        int out = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (this.myBlocks[i][j] != 0 && this.myBlocks[i][j] != i * size + j + 1)
                    out++;
        return out;
    }
    
    public int manhattan() {                // sum of Manhattan distances between blocks and goal
        int out = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (this.myBlocks[i][j] != 0)
                    out += Math.abs((this.myBlocks[i][j] - 1) / size - i) 
                        + Math.abs((this.myBlocks[i][j] - 1) % size - j);
        return out;
    }
      
    public boolean isGoal() {               // is this board the goal board?
        return hamming() == 0;
    }
    
    public Board twin() {                   // a board that is obtained by exchanging any pair of blocks
        Board twin = new Board(myBlocks);
        if (size < 2)
            return twin;
        if (myBlocks[size - 1][size - 1] != 0 && myBlocks[size - 1][size - 2] != 0)
            twin.exch(size - 1, size - 2, size - 1, size - 1);
        else if (size == 2)
            twin.exch(0, 0, 0, 1);
        else if (myBlocks[size - 1][size - 1] == 0)
            twin.exch(size - 1, size - 2, size - 1, size - 3);
        else
            twin.exch(size - 1, size - 1, size - 1, size - 3);
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
        if (posX < size - 1) {
            Board bottom = new Board(myBlocks);
            bottom.exch(posX, posY, posX + 1, posY);
            res.add(bottom);
        }
        if (posY > 0) {
            Board left = new Board(myBlocks);
            left.exch(posX, posY, posX, posY - 1);
            res.add(left);
        }
        if (posY < size - 1) {
            Board right = new Board(myBlocks);
            right.exch(posX, posY, posX, posY + 1);
            res.add(right);
        }
        return res;
    }
    
    public String toString() {              // string representation of this board (in the output format specified below)
        StringBuilder sb = new StringBuilder();
        sb.append(size);
        sb.append(System.lineSeparator());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(String.format("%2d", myBlocks[i][j]));
                 if (j < size - 1)
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
    
    public static void main(String[] args) { // unit tests (not graded)
    
    }
}
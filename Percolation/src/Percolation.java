/******************************************************************************
 *  Compilation:  javac Percolation.java
 *
 *  Liudmila Klimkina 11/6/2016
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufFull;
    private int gridSize;
    private int sqN;
    
    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException();
        gridSize = n;
        sqN = n * n;
        grid = new boolean[sqN + 2];
                
        uf = new WeightedQuickUnionUF(sqN + 2);
        ufFull = new WeightedQuickUnionUF(sqN + 2);
        
        for (int i = 0; i < sqN; i++)
            grid[i] = false;
        grid[sqN] = true;
        grid[sqN + 1] = true;
    }
    
    private void checkBoundaries(int row, int col)
    {
        if (row <= 0 || col <= 0 || row > gridSize || col > gridSize)
            throw new java.lang.IndexOutOfBoundsException();
    }
    
    private int calcIndex(int row, int col)
    {
        return (row - 1) * gridSize + col - 1;
    }
    
    private int calcLeftIndex(int row, int col)
    {
        return (row - 1) * gridSize + col - 2;
    }
    
    private int calcRightIndex(int row, int col)
    {
        return (row - 1) * gridSize + col;
    }
    
    private int calcTopIndex(int row, int col)
    {
        if (row == 1)
            return sqN;
        return (row - 2) * gridSize + col - 1;
    }
    
    private int calcBottomIndex(int row, int col)
    {
        if (row == gridSize)
            return sqN + 1;
        return (row) * gridSize + col - 1;
    }    
    
    public void open(int row, int col)       // open site (row, col) if it is not open already
    {
        checkBoundaries(row, col);
        
        int currIndex = calcIndex(row, col);
        int leftIndex = calcLeftIndex(row, col);
        int rightIndex = calcRightIndex(row, col);
        int topIndex = calcTopIndex(row, col);
        int bottomIndex = calcBottomIndex(row, col);
        
        grid[currIndex] = true;
        
        if ((col > 1) && (grid[leftIndex])) {
            uf.union(currIndex, leftIndex);
            ufFull.union(currIndex, leftIndex);
        }
        if ((col < gridSize) && (grid[rightIndex])) {
            uf.union(currIndex, rightIndex);
            ufFull.union(currIndex, rightIndex);
        }
        if (grid[topIndex]) {
            uf.union(currIndex, topIndex);
            ufFull.union(currIndex, topIndex);
        }
        if (grid[bottomIndex]) {
            uf.union(currIndex, bottomIndex);
            if (bottomIndex != (sqN + 1))
                ufFull.union(currIndex, bottomIndex);
        }
    }
    
    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        checkBoundaries(row, col);
        return grid[calcIndex(row, col)];
    }
    
    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        checkBoundaries(row, col);
        return ufFull.connected(sqN, calcIndex(row, col));
    }
    
    public boolean percolates()              // does the system percolate?
    {
        return uf.connected(sqN, sqN + 1);
    }
}

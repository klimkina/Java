import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

// Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.

// In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].

// If there is no way to make arr1 strictly increasing, return -1.
class Solution {
	HashMap<String, Integer> map = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    public int minimumMoves(int[][] grid) {
        if (grid.length == 0)
            return -1;
        int n = grid.length;
        map.put((n-1) + " " + (n-1) + " " + 1, 0);
        visited.add((n-1) + " " + (n-1) + " " + 1);
        return minimumMoves(grid, 0, 1, 1);
    }
    private int minimumMoves(int[][] grid, int row, int col, int isHor) {
        int n = grid.length;
        if (row == n-1 && col == n-1 && isHor > 0)
            return 0;
        String key = row + " " + col + " " + isHor;
        if (map.containsKey(key))
            return map.get(key);
        visited.add(key);
        int min = Integer.MAX_VALUE;
        int res = -1;
        if (isHor > 0)
        {
            if (col < n-1 && grid[row][col+1] == 0)
                res = minimumMoves(grid, row, col+1, 1); //right
            if (res >= 0)
                min = Math.min(min, res + 1);
            if (row < n-1 && grid[row+1][col-1] == 0 && grid[row+1][col] == 0)
                   // && !visited.contains((row+1) + " " + (col) + " " + 1)) //down
            {
                 res = minimumMoves(grid, row+1, col, 1);
                 if (res >= 0)
                     min = Math.min(min, res + 1);   
            }
            if (row < n-1 && grid[row+1][col-1] == 0 && grid[row+1][col] == 0)
               //&& !visited.contains((row+1) + " " + (col-1) + " " + 0))//rotate
            {
                res = minimumMoves(grid, row+1, col-1, 0);
                if (res >= 0)
                    min = Math.min(min, res + 1);   
            }
        }
        else
        {
            if (row < n-1 && grid[row+1][col] == 0) // down
                res = minimumMoves(grid, row+1, col, 0);
            if (res >= 0)
                min = Math.min(min, res + 1);
            if (col < n-1 && grid[row-1][col+1] == 0 && grid[row][col+1] == 0)
                  //  && !visited.contains((row-1) + " " + (col+1) + " " + 0))//right
                 {
                     res = minimumMoves(grid, row, col+1, 0);
                     if (res >= 0)
                         min = Math.min(min, res + 1);   
                 }
            if (col < n-1 && grid[row-1][col+1] == 0 && grid[row][col+1] == 0
               && !visited.contains((row-1) + " " + (col+1) + " " + 1))//rotate
            {
                res = minimumMoves(grid, row-1, col+1, 1);
                if (res >= 0)
                    min = Math.min(min, res + 1);   
            }
        }
        if (min == Integer.MAX_VALUE)
            min = -1;
        map.put(key, min);
        return min;
    }

	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] grid = {{0,0,0,0,0,0,0,1,0,0,1,0,0,0,0},
		                  {1,0,0,0,0,1,0,0,0,0,0,0,1,0,0},
		                  {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		                  {0,0,1,0,1,0,0,0,0,1,0,0,1,0,0},
		                  {0,0,0,0,0,0,0,1,0,0,0,0,0,1,0},
		                  {1,0,0,0,1,0,0,0,0,0,0,0,1,0,1},
		                  {1,0,0,0,0,0,0,0,0,0,0,1,0,1,0},
		                  {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
		                  {1,0,0,0,0,0,1,0,0,0,0,0,1,1,0},
		                  {0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
		                  {0,1,0,0,1,0,1,0,0,0,1,0,1,1,0},
		                  {0,1,0,1,1,0,0,0,0,0,1,0,0,0,0},
		                  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		                  {0,0,0,0,1,1,1,0,0,0,1,0,1,0,0},
		                  {0,0,0,0,0,1,0,0,1,0,0,1,0,0,0}};
		System.out.println(obj.minimumMoves(grid));
	}
}

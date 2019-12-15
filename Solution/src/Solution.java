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

/*
Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
 */
class Solution {
	public int shortestPath(int[][] grid, int k) {
        if(grid.length == 0)
            return 0;
        Map<String, Integer> map = new HashMap<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        if(grid[0][0] == 1)
            k= k-1;
        int min = dfs(grid, 0, 0, k, map, visited);
        return  min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int dfs(int[][] grid, int row, int col, int k, Map<String, Integer> map, boolean visited[][]) {
        if(k < 0)
            return Integer.MAX_VALUE;
        if(row == grid.length-1 && col == grid[0].length-1) {
            return 0;
        }
        String key = row + "_" + col + "_" + k;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        visited[row][col] = true;
        int min = Integer.MAX_VALUE;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int d = 0; d < 4; d++) {
            int next_row = row + dirs[d][0];
            int next_col = col + dirs[d][1];
            if(inBounds(grid, next_row, next_col, visited)) {
                int temp = Integer.MAX_VALUE;
                if(grid[next_row][next_col] == 0 || k > 0) 
                        temp = dfs(grid, next_row, next_col, k-grid[next_row][next_col], map, visited);
                
                if(temp != Integer.MAX_VALUE) 
                    min = Math.min(min, temp+1);
            }
        }
        map.put(key, min);
        visited[row][col] = false;
        return min;
    }
    
    boolean inBounds(int grid[][], int i, int j, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !visited[i][j];
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] mat = {{0,0,0},
		                 {1,1,0},
		                 {0,0,0},
		                 {0,1,1},
		                 {0,0,0}};
		System.out.println(obj.shortestPath(mat, 1));
	}
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int projectionArea(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;
	        int[] maxCol = new int[n];
	        int[] maxRow = new int[m];
	        int topSum = 0;
	        for(int i = 0; i < m; i++)
	            for (int j = 0; j < n; j++)
	                if(grid[i][j] > 0)
	                    topSum++;
	        for(int i = 0; i < m; i++)
	            for (int j = 0; j < n; j++)
	            {
	                if (grid[i][j] > maxRow[i])
	                    maxRow[i] = grid[i][j];
	                if (grid[i][j] > maxCol[j])
	                    maxCol[j] = grid[i][j];
	            }
	        for(int i = 0; i < m; i++)
	            topSum += maxRow[i];
	        for (int j = 0; j < n; j++)
	            topSum += maxCol[j];
	        return topSum;
	    }
	
    public static void main(String[] args) {
    	int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
    	System.out.print(projectionArea(grid));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

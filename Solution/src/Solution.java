import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



class Solution {
	public static List<int[]> pacificAtlantic(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] grid = new int[n][m];
        for(int i = 1; i < m-1; i++)
        {
            grid[0][i] += 1;
            grid[n-1][i] += 2;
        }
        for(int i = 1; i < n-1; i++)
        {
            grid[i][0] += 1;
            grid[i][m-1] += 2;
        }
        grid[0][0] = 1;
        grid[n-1][m-1] = 2;
        grid[0][m-1] = 3;
        grid[n-1][0] = 3;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m-i-1; j++)
            {
            	if (grid[i][j] < 3)
            	{
	                if (j > 0 && matrix[i][j-1] <= matrix[i][j] && grid[i][j-1] > 0) 
	                    grid[i][j] = calcOcean(grid[i][j-1], grid[i][j]);
	                if (i > 0 && matrix[i-1][j] <= matrix[i][j] && grid[i-1][j] > 0) 
	                    grid[i][j] = calcOcean(grid[i-1][j], grid[i][j]); 
	                if (j < m-1 && matrix[i][j+1] <= matrix[i][j] && grid[i][j+1] > 0) 
	                    grid[i][j] = calcOcean(grid[i][j+1], grid[i][j]);
            	}
            }
        for(int i = n-1; i >= 0; i--)
            for(int j = 1; j < m-(n-1 -i)-1; j++)
            {
            	if (grid[i][j] < 3)
            	{
	            	if (j > 0 && matrix[i][j-1] >= matrix[i][j] && grid[i][j-1] > 0) 
	                    grid[i][j] = calcOcean(grid[i][j-1], grid[i][j]);
	                if (j < m-1 && matrix[i][j+1] >= matrix[i][j] && grid[i][j+1] > 0) 
	                    grid[i][j] = calcOcean(grid[i][j+1], grid[i][j]);
	                if (i < n-1 && matrix[i+1][j] >= matrix[i][j] && grid[i+1][j] > 0) 
	                    grid[i][j] = calcOcean(grid[i+1][j], grid[i][j]);
            	}
            }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if (grid[i][j] > 2)
                    res.add(new int[]{i,j});
        return res;
        
    }
    private static int calcOcean(int prev, int curr)
    {
        if (curr != prev)
            curr += prev;
        return curr;
    }
	
	public static void main(final String[] args) {
		int[][] ocean = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		List<int[]> res = pacificAtlantic(ocean);
		for (int i = 0; i < res.size(); i++)
			System.out.print(res.get(i)[0] + " " + res.get(i)[0] + ", ");
		//System.out.print(queryString("110101011011000011011111000000", 15));
	}
}

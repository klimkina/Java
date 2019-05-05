import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/*
Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.

Suppose you triangulate the polygon into N-2 triangles.  For each triangle, the value of that triangle is the product of the labels of the vertices, and the total score of the triangulation is the sum of these values over all N-2 triangles in the triangulation.

Return the smallest possible total score that you can achieve with some triangulation of the polygon.
 */

class Solution {
	public int minScoreTriangulation(int[] A) {
        int res = 0;
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++)
            for (int j = 0; j + i < n; j++)
            {
                int m = j + i;
                dp[j][m] = Integer.MAX_VALUE;
                for (int k = j +1; k < m; k++)
                    dp[j][m] = Math.min(dp[j][m], dp[j][k] + dp[k][m] + A[j]*A[k]*A[m]);
            }
        
        return dp[0][n-1];
    }
    
	public static void main(final String[] args) {
		Solution obj = new Solution();
		int[][] points = {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
		int[][] closest = obj.kClosest(points,  5);
		obj.print(closest, 5);
	}
}

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

class Solution {
	HashMap<String, Integer> dist_map = new HashMap<>();
	public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0)
            return points;
        if (K > points.length)
            K = points.length;
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++)
        {
            res[i] = points[i];
            swim(res, i, K);
        }
        for (int i = K; i < points.length; i++)
        {
            if (dist(res[0]) > dist(points[i]))
            {
                res[0] = points[i];
                sink(res, 0, K);
            }
        }
        return res;
        
    }
    private void sink(int[][] res, int n, int K)
    {
        int dist = dist(res[n]);
        while (2*n+1 < K)
        {
            int kid = n*2+1; //left child
            int dist1 = dist(res[kid]); //right child if exist
            int dist2 = Integer.MIN_VALUE;
            if (kid + 1 < K)
            	dist2 = dist(res[kid+1]);
            if(dist1 < dist2)
                kid++;
            if (dist > Math.max(dist1, dist2))
                break;
            swap(res, n, kid);           
            n = kid;
        }
    }
    private void swim(int[][] res, int n, int K)
    {
        int dist = dist(res[n]);
        while (n > 0)
        {
            int d = dist(res[(n-1)/2]); //parent
            if (d < dist)
            {
                swap(res, n, (n-1)/2);
                n = (n-1)/2;
            }
            else
                break;
        }
    }
    private void swap(int[][] res, int a, int b)
    {
        int[] t = res[a];
        res[a] = res[b];
        res[b] = t;
    }
    
    private int dist(int[] point)
    {
    	return point[0]*point[0] + point[1]*point[1];
    }
    
    private void print(int[][] res, int K)
    {
        System.out.print("[");
        for (int i = 0; i < K; i++)
            System.out.print("[" + res[i][0] + "," +res[i][1] +"]");        
        System.out.println("]");
        for (int i = 0; i < K; i++)
            System.out.print(dist(res[i]) + " ");            
        
        System.out.println();
    }
    
	public static void main(final String[] args) {
		Solution obj = new Solution();
		int[][] points = {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
		int[][] closest = obj.kClosest(points,  5);
		obj.print(closest, 5);
	}
}

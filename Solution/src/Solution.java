import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
    	    public int compare(int[] p1, int[] p2) {
    	    	Integer sqDist1 = p1[0]*p1[0] + p1[1]*p1[1];
    	    	Integer sqDist2 = p2[0]*p2[0] + p2[1]*p2[1];
    	    	
    	        return sqDist1 - sqDist2;
    	    }
    	});
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++)
        {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
	
    public static void main(String[] args) 
    {
    	int[][] A = {{3,3},{5,-1},{-2,4}};
    	int[][] res = kClosest(A, 2);
    	for(int i = 0; i < res.length; i++)
    		System.out.print(res[i][0] + " " + res[i][1] + "\n");
    }
}

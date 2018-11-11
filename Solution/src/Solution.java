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
	public static int minAreaRect(int[][] points) {
		Arrays.sort(points, new Comparator<int[]>() { 
        	public int compare(int[] p1, int[] p2) {
        		if(p1[0] == p2[0])
        			return p1[1] - p2[1];
        		return p1[0] - p2[0];
    		}
    	});
        HashMap<Integer, Set<Integer>> mapY = new HashMap<>();
        for(int i = 0; i < points.length; i++)
        {
            if(!mapY.containsKey(points[i][1]))
                mapY.put(points[i][1], new HashSet<>());
            mapY.get(points[i][1]).add(points[i][0]);
        }
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] != p2[0] && p1[1] != p2[1]) { // if dont have the same x or y                    
	                if (mapY.get(p1[1]).contains(p2[0]) && mapY.get(p2[1]).contains(p1[0])) // find other two points
	                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
	
    public static void main(String[] args) 
    {
    	int[][] arr = {{1,1},{1,3},{3,1},{3,3},{2,2}};
    	System.out.println(minAreaRect(arr));
    }
}

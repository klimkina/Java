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

public class Solution {
	public static boolean possibleBipartition(int N, int[][] dislikes) {
	        int[] colors = new int[N+1];
	        HashMap<Integer, Set<Integer>> neighbours = new HashMap<>();
	        for (int i = 0; i <= N; i++)
	        	neighbours.put(i, findNeighbours(i, dislikes));
	        for (int i = 0; i <= N; i++)
	        {
	        	if (colors[i] == 0)
	        	{
	        		if (!color(i, -1, neighbours, colors))
	        			return false;
	        	}
	        }
	        
	        return true;
	    }
	
	private static boolean color (int person, int color, HashMap<Integer, Set<Integer>> neighbours, int[] colors)
	{
		if (colors[person] != 0 && colors[person] != color)
			return false;
		if (colors[person] != 0)
            return true;
		colors[person] = color;
		for (int neib : neighbours.get(person))
			if (!color (neib, -color, neighbours, colors))
				return false;
		return true;
	}
	
	private static Set<Integer> findNeighbours(int person, int[][] dislikes)
	{
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < dislikes.length; i++)
			if (dislikes[i][0] == person || dislikes[i][1] == person)
				set.add(dislikes[i][0] == person ? dislikes[i][1] : dislikes[i][0]);
		return set;
	}

	    public static void main(String[] args) 
	    {
	    	int[][] dislikes = {{1,2},{1,3},{2,4}};
	    	System.out.println(possibleBipartition(4, dislikes));
	    	
	    }
}

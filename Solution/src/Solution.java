import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static TreeMap<Integer, Integer> map;
	
	static int[] airports(int d, int[] x) {
		int[] res = new int[x.length];
		res[0] = 0;
		if(x.length >= 2)
			res[1] = Math.abs(x[0] - x[1]) >= d ? 0 : d - Math.abs(x[0] - x[1]);
		if(x == null || x.length <= 2)
			return res;
        map = new TreeMap<Integer, Integer>();
        map.put(x[0], 1);
        add(x[1]);
       for(int i = 2; i < x.length; i++) {
        	add(x[i]);
        	res[i] = calcCost(x[i], d);
        }
		return res;
    }
	private static void add(int x) {
		if(map.containsKey(x))
			map.put(x, map.get(x)+1);
		else
			map.put(x, 1);	
	}
	private static int calcCost(int x, int d) {
		int min_cost = Integer.MAX_VALUE;
		
		
		int prev = map.firstKey();
		Integer next = map.higherKey(prev);
		if(next == null)
			return d;
		if(next - prev >= d)
			return 0;
		int pos = next - d;
		for(int i = pos; i < map.get(map.lowerKey(map.lastKey())); i++) {
			int cost = calcCostPos(i, d);
			if(cost == 0)
				return 0;
			if (min_cost > cost)
				min_cost = cost;			
		} 
		return min_cost;
	}
	private static int calcCostPos(int pos, int d) {
		int cost = 0;
		Integer first = map.higherKey(pos);
		if(first == map.lastKey())
			return (d - (first - pos)) * map.get(first);
		while(first != null && first - pos < d) {
			cost += (first - pos) * map.get(first);
			first = map.higherKey(first);
		}
		return cost;
	}
    public static void main(String[] args) {
    	int[] x = {1, -1, 2, -1, 1};
    	int[] result = airports(4, x);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
    }
}
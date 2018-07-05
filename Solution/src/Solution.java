import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
		 }
	
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Interval i : intervals)
        {
        	Integer prev_l = map.floorKey(i.start);
        	Integer next_l = map.higherKey(i.start);
        	if (prev_l != null && map.get(prev_l) >= i.start)
        		map.put(prev_l, Math.max(i.end, map.get(prev_l)));
        	else
        		map.put(i.start, i.end);
        	prev_l = map.floorKey(i.start);
        	while(next_l != null && (map.get(next_l) <= map.get(prev_l) || map.get(prev_l) >= next_l))
        	{
        		map.put(prev_l, Math.max(map.get(prev_l), map.get(next_l)));
        		map.remove(next_l);
        		next_l = map.higherKey(prev_l);
        	}
        }
        for(Integer key : map.keySet())
        	res.add(new Interval(key, map.get(key)));
        return res;
    }
	
    public static void main(String[] args) {
    	int[][] is = {{1,4},{0,1}};
    	List<Interval> intervals = new ArrayList<>();
    	for(int[] i : is)
    		intervals.add(new Interval(i[0], i[1]));
    	List<Interval> res = merge(intervals);
    	for (Interval i : res)
    		System.out.println(i.start + " " + i.end);
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

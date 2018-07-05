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
	static class IntervalComparator implements Comparator{
		public int compare(Object o1, Object o2){
		Interval i1 = (Interval)o1;
		Interval i2 = (Interval)o2;
		return i1.start - i2.start;
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
	    for(int i = 0;i<intervals.size()-1;i++)
	    {
	        int j = i+1;
	        if(intervals.get(j).start<=intervals.get(i).end)
	        {
	            intervals.get(i).end = Math.max(intervals.get(j).end,intervals.get(i).end);
	            //intervals.get(i).start = Math.min(intervals.get(j).start,intervals.get(i).start);
	            intervals.remove(j);
	            i--;
	        }
	    }
	    return(intervals);
    }
	
    public static void main(String[] args) {
    	int[][] is = {{1,4},{1,4}};
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

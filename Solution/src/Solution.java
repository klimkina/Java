import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
class Solution {
	public static class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval prev = null;
        Interval curr = null;
        int start = newInterval.start;
        int end = newInterval.end;
        ListIterator<Interval> iter = intervals.listIterator();
        while (iter.hasNext())
        {
            Interval i = iter.next();        
            if (i.start > start)
            {
                curr = i;
                break;
            }
            prev = i;
        }
        if (prev != null && prev.end >= start)
            end = Math.max(prev.end, end);
        
        while (curr != null && curr.start <= end)
        {
            end = Math.max(end, curr.end);
            iter.remove();
            if (iter.hasNext())
            	curr = iter.next();
            else
            	curr = null;
        }
        if (prev == null)
        	intervals.add(0, new Interval (start, end));
        else if (prev.end < start)
        	intervals.add(intervals.indexOf(prev) + 1, new Interval (start, end));
        else
        	prev.end = end;
        return intervals;
    }
	
	public static void main(final String[] args) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(2,7));
		list.add(new Interval(8,8));
		list.add(new Interval(10,10));
		list.add(new Interval(12,13));
		list.add(new Interval(16,19));
		insert(list, new Interval(9,17));
		//System.out.print(shortestDistance(grid));
	}
}

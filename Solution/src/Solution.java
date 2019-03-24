import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



class Solution {
	public static class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });
        ListIterator<Interval> iter = intervals.listIterator();
        Interval prev = null;
        while (iter.hasNext())
        {
            Interval curr = iter.next();
            if (prev != null)
            {
                if (prev.end >= curr.start) {
                    prev.end = Math.max(prev.end, curr.end);
                    iter.remove();
                }
                else
                    prev = curr;
            }
            else
                prev = curr;
        }
        return intervals;
    }
	
	public static void main(final String[] args) {
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(2,4));
		list.add(new Interval(1,3));
		list = merge(list);
		//System.out.print(shortestDistance(grid));
	}
}

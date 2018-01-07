import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
	public static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = new ArrayList<>();
        List<Interval> ans = new ArrayList<>();
        for (List<Interval> list:schedule)
            for (Interval in:list)
                all.add(in);
        Collections.sort(all,(c,d)->(c.start-d.start));
        int max = all.get(0).end;
        for (int i = 1; i < all.size(); i++)
        {
            int l = all.get(i).start;
            int r = all.get(i).end;
            if (r <= max) continue;
            if (l > max) 
                ans.add(new Interval(max, l));
            
            max = r;
        }
        return ans;
    }
    

    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[][][] intervals = {{{1,2},{5,6}},
    			{{1,3}},{{4,10}}
    	};
    	List<List<Interval>> avails = new ArrayList<>();
    	for(int i = 0; i < intervals.length; i++) {
    		List<Interval> l = new ArrayList<>();
    		for(int j = 0; j < intervals[i].length; j++)
    			l.add(new Interval(intervals[i][j][0], intervals[i][j][1]));
    		avails.add(l);
    	}
    	List<Interval> res = obj.employeeFreeTime(avails);
    	for(Interval interval : res)
    		System.out.println(interval.start + " " + interval.end);
        
    }
}
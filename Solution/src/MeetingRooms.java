import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
	public static class Interval implements Comparable<Interval>{
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
		 @Override
		 public int compareTo(Interval that) {
			 return this.start - that.start;
		 }
	}
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length < 2)
			return intervals.length;
		int res = 1;
        Arrays.sort(intervals,(a,b)->a.start - b.start);
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        int pos = 1;
        
        ends.offer(intervals[0].end);
        while(pos < intervals.length) {
        	
        	while(!ends.isEmpty() && intervals[pos].start >= ends.peek()) // remove old meetings
        		ends.poll(); // remove from pq
        	ends.offer(intervals[pos].end);
        	pos++;
        	res = Math.max(res, ends.size());
        		
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervs = {{5, 8},{6, 8}, {10, 20}};
		MeetingRooms obj = new MeetingRooms();
		Interval[] intervals = new Interval[3];
		for(int i = 0; i < 3; i++)
			intervals[i] = new Interval(intervs[i][0], intervs[i][1]);
		System.out.println(obj.minMeetingRooms(intervals));
	}

}

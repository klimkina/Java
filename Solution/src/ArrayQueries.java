import java.util.Arrays;
import java.util.TreeSet;
import java.util.TreeMap;

public class ArrayQueries {
	private static class Interval implements Comparable<Interval> {
		int start;
		int end;
		public Interval(int s, int e) {
			start = s; end = e;
		}
		@Override
		public int compareTo(Interval that) {
			if(this.start != that.start)
				return this.start - that.start;
			return this.end - that.end;
		}
	}
	private static TreeMap<Interval, Integer> bst;
	static int arrayAndQueries(int[] A, int[][] queries) {
        // Complete this function
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < A.length; i++) {
			if(map.get(A[i]) == null)
				map.put(A[i], 0);
			map.put(A[i], map.get(A[i])+1);
		}
			
		bst = new TreeMap<>();
		while(!map.isEmpty()) {
			int start = map.firstKey();
			if(map.get(start) == 1)
				map.remove(start);
			else
				map.put(start, map.get(start) - 1);
			Interval interv = new Interval(start, start);
			start++;
			while(map.get(start) != null) {
				if(map.get(start) == 1)
					map.remove(start);
				else
					map.put(start, map.get(start) - 1);
				start++;
			}
			interv.end = start - 1;
			if(bst.get(interv) == null)
				bst.put(interv, 0);
			bst.put(interv, bst.get(interv)+1);
		}
		//int[] arr = Arrays.copyOf(A, A.length);
		//Arrays.sort(arr);
		int res = 0;
		for(int i = 0; i < queries.length; i++) {
			res += calc(queries[i], A) * i;
		}
		return res;
    }
	private static int calc(int[] querie, int[] A) {
		int old_val = A[querie[0]];
		A[querie[0]] = querie[1];
		Interval origin = new Interval(old_val, old_val);
		Interval interv_left = bst.floorKey(origin);
		Interval interv_new = bst.ceilingKey(new Interval(A[querie[0]], A[querie[0]]));
		if(interv_left == origin) {
			if(bst.get(interv_left) == 1)
				bst.remove(interv_left);
			else
				bst.put(interv_left, bst.get(interv_left) - 1);
			
		}
		if(interv_new.start == A[querie[0]]+1);
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,2,1,1,1};
		int[][] queries = {{3, 2},
			{5, 5}};
		int result = arrayAndQueries(A, queries);
        System.out.println(result);
	}

}

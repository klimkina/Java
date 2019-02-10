import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> optimalUtilization(int maxTravelDist, 
                                    List<List<Integer>> forwardRouteList,
                                    List<List<Integer>> returnRouteList)
	{
        // WRITE YOUR CODE HERE
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Collections.sort(forwardRouteList, new Comparator<List<Integer>>() {
	                public int compare(List<Integer> f1, List<Integer> f2) {
	                    return f1.get(1).compareTo(f2.get(1));
	                }	              
	            });
	    Collections.sort(returnRouteList, new Comparator<List<Integer>>() {
	                public int compare(List<Integer> f1, List<Integer> f2) {
	                    return f1.get(1).compareTo(f2.get(1));
	                }	              
	            });
	    int max = -1;
	    for(int i = forwardRouteList.size() - 1; i >=0; i--)
	        for(int j = returnRouteList.size() - 1; j >=0; j--) {
	            int dist = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
	            if(dist <= maxTravelDist) {
	                if(dist < max)
	                    break;
	                if (dist > max) {
	                    res.clear();
	                    max = dist;
	                }
	                List<Integer> pair = new ArrayList<>();
	                pair.add(forwardRouteList.get(i).get(0));
	                pair.add(returnRouteList.get(j).get(0));
	                res.add(pair);
	            }
	        }
	   return res;
    }
	
	public static void main(final String[] args) {
		List<List<Integer>> forw = new ArrayList<List<Integer>>();
		List<Integer> pair = new ArrayList<>();
		pair.add(1);
		pair.add(3000);
		forw.add(pair);
		pair = new ArrayList<>();
		pair.add(2);
		pair.add(5000);
		forw.add(pair);
		pair = new ArrayList<>();
		pair.add(3);
		pair.add(7000);
		forw.add(pair);
		pair = new ArrayList<>();
		pair.add(4);
		pair.add(10000);
		forw.add(pair);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		pair = new ArrayList<>();
		pair.add(1);
		pair.add(2000);
		ret.add(pair);
		pair = new ArrayList<>();
		pair.add(2);
		pair.add(3000);
		ret.add(pair);
		pair = new ArrayList<>();
		pair.add(3);
		pair.add(4000);
		ret.add(pair);
		pair = new ArrayList<>();
		pair.add(4);
		pair.add(5000);
		ret.add(pair);
		int max = 10000;
		List<List<Integer>> res = optimalUtilization(max, forw, ret);
		for(int i = 0 ; i < res.size(); i++)
			System.out.println(res.get(i).get(0) + " " + res.get(i).get(1));
	}
}

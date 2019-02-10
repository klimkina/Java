import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
	
	    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	    List<List<Integer>> ClosestXdestinations(int numDestinations, 
	                                             List<List<Integer>> allLocations,
	                                             int numDeliveries)
		{
	        // WRITE YOUR CODE HERE
	        if(numDeliveries >= numDestinations)
	            return allLocations;
	        Collections.sort(allLocations, new Comparator<List<Integer>>() {
	                public int compare(List<Integer> loc1, List<Integer> loc2) {
	                    Integer sqDist1 = sqDist(loc1);
	                    Integer sqDist2 = sqDist(loc2);
	                    return sqDist1.compareTo(sqDist2);
	                }	              
	            });
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        for(int i = 0; i < Math.min(numDeliveries, allLocations.size()); i++)
	            res.add(allLocations.get(i));
	        return res;
	    }
	    // METHOD SIGNATURE ENDS
	    private Integer sqDist(List<Integer> loc)
	    {
	        if(loc.isEmpty() || loc.size() != 2)
	            throw new IllegalArgumentException("Bad location!");
	        Integer x = loc.get(0);
	        Integer y = loc.get(1);
	        return x*x + y*y;    
	    }
	}
	
	public static void main(final String[] args) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
	}
}

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Amazon1 //23280666983745
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> closestLocations(int totalCrates, 
                                         List<List<Integer>> allLocations, 
                                         int truckCapacity)
	{
        // WRITE YOUR CODE HERE
    	Collections.sort(allLocations, new Comparator<List<Integer>>() {
    	    public int compare(List<Integer> p1, List<Integer> p2) {
    	    	Integer sqDist1 = 0;
    	    	Integer sqDist2 = 0;
    	    	if(!(p1.isEmpty() || p2.isEmpty())) {
	    	    	int x1 = p1.get(0);
	                int y1 = p1.get(1);
	                sqDist1 = x1*x1 + y1*y1;
	                int x2 = p2.get(0);
	                int y2 = p2.get(1);
	                sqDist2 = x2*x2 + y2*y2;
    	    	}
    	        return sqDist1.compareTo(sqDist2);
    	    }
    	});
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for (int i = 0; i < Math.min(truckCapacity, allLocations.size()); i++)
    		res.add(allLocations.get(i));
    	return res;
    }
    // METHOD SIGNATURE ENDS
    
    
    public class Point implements Comparable<Point> {
        private final int x;     // x-coordinate of this point
        private final int y;     // y-coordinate of this point
        private final int z;     // square distance

        /**
         * Initializes a new point.
         *
         * @param  x the <em>x</em>-coordinate of the point
         * @param  y the <em>y</em>-coordinate of the point
         */
        public Point(List<Integer> p) {
            /* DO NOT MODIFY */
            this.x = p.get(0);
            this.y = p.get(1);
            this.z = x*x + y*y;
        }
        public int compareTo(Point that) {
            /* YOUR CODE HERE */
            if (this.z < that.z) return -1;
            if (this.z > that.z) return +1;
            return 0;
        }
    }

	public static void main(final String[] args) {
		int numCrates = 3;
		int truckCapasity = 2;
		List<List<Integer>> locations = new ArrayList<List<Integer>>();
		List<Integer> point1 = new ArrayList();
		point1.add(1);
		point1.add(2);
		List<Integer> point2 = new ArrayList();
		point1.add(3);
		point1.add(4);
		List<Integer> point3 = new ArrayList();
		point1.add(1);
		point1.add(-1);
		locations.add(point1);
		locations.add(point2);
		locations.add(point3);
		Amazon1 sol = new Amazon1();
		List<List<Integer>> res = sol.closestLocations(numCrates, locations, truckCapasity);
		if( res != null)
			System.out.println(res.get(0).get(0));
		else
			System.out.println("Not found");
	}
}

import java.util.Map;
import java.util.TreeMap;


public class RangeModule {
	
	TreeMap<Integer, Integer> left_ends;
	public RangeModule() {
		left_ends = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
    	if(left_ends.isEmpty()) 
    		left_ends.put(left, right);
    	else {
	    	Integer next_left = left_ends.higherKey(left);
	    	Integer prev_left = left_ends.floorKey(left);
	    	Integer next_right = null;
	    	Integer prev_right = null;
	    	if(prev_left != null)
	    		prev_right = left_ends.get(prev_left);
	    	if(prev_left != null && prev_right >= left)  // glue
	    		left_ends.put(prev_left, Math.max(prev_right, right));
	    	else
	    		left_ends.put(left, right);
	    	
	    	while(next_left != null && next_left <= right) { //remove rights
	    		
	    		next_right = left_ends.get(next_left);
	    		left_ends.remove(next_left);
	    		if(next_right >= right)  // glue
	    			left_ends.put(prev_left == null || prev_right < left ? left : prev_left, next_right);
	    		
	    		next_left = left_ends.higherKey(left);
	    	}
	    	
    	}
    	System.out.println("Adding range:" + left + "-" + right);
    	printIntervals();
    }
    
    public boolean queryRange(int left, int right) {
    	if(left_ends.isEmpty())
    		return false;
    	Integer prev_left = left_ends.floorKey(left);
    	
    	if(prev_left != null) {
    		Integer prev_right = left_ends.get(prev_left);
    		if(left < prev_right && right <= prev_right) { 
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public void removeRange(int left, int right) {
    	Integer next_left = left_ends.higherKey(left);
    	Integer prev_left = left_ends.floorKey(left);
    	Integer prev_right = null;
    	Integer next_right = null;
    	
    	if(next_left != null) 
    		next_right = left_ends.get(next_left);
    	
    	if(prev_left != null) 
    		prev_right = left_ends.get(prev_left);;
    	 	
    	
    	if(prev_left != null && prev_right > left) { // 
			left_ends.put(prev_left, left);
			if(right < prev_right)
				left_ends.put(right, prev_right);
    	}
    	while(next_left != null && next_left < right) {
    		left_ends.remove(next_left);
    		if(next_right >= right) { // replace
    			if(next_right > right)
    				left_ends.put(right, next_right);
    			next_left = null;
    		}
    		else {
    			next_left = left_ends.higherKey(left);
    			if(next_left != null) 
    	    		next_right = left_ends.get(next_left);
    		}
    		
    	}
    	System.out.println("Removing range:" + left + "-" + right);  	
    	printIntervals();
    }
    
    private void printIntervals() {
    	for(Map.Entry<Integer,Integer> entry : left_ends.entrySet()) {
    		  Integer key = entry.getKey();
    		  Integer value = entry.getValue();
    		  System.out.print(key + " => " + value + ",");
		}
    	System.out.println();
    }
    
	public static void main(String[] args) {
		RangeModule obj = new RangeModule();
		obj.addRange(44,53);obj.addRange(69,89);
		System.out.println(obj.queryRange(23,26));
		System.out.println(obj.queryRange(80,84));
		System.out.println(obj.queryRange(11,12));
		obj.removeRange(86,91);obj.addRange(87,94);
		obj.removeRange(34,52);obj.addRange(1,59);
		obj.removeRange(62,96);obj.removeRange(34,83);
		System.out.println(obj.queryRange(11,59));
		System.out.println(obj.queryRange(59,79));
		System.out.println(obj.queryRange(1,13));
		System.out.println(obj.queryRange(21,23));
		obj.removeRange(9,61);
		obj.addRange(17,21);
		obj.removeRange(4,8);
		System.out.println(obj.queryRange(19,25));
		obj.addRange(71,98);
		obj.addRange(23,94);
		obj.removeRange(58,95);
		System.out.println(obj.queryRange(12,78));
		obj.removeRange(46,47);obj.removeRange(50,70);
		obj.removeRange(84,91);
		obj.addRange(51,63);obj.removeRange(26,64);obj.addRange(38,87);
		System.out.println(obj.queryRange(41,84));
		System.out.println(obj.queryRange(19,21));
		System.out.println(obj.queryRange(18,56));
		System.out.println(obj.queryRange(23,39));
		System.out.println(obj.queryRange(29,95));
		obj.addRange(79,100);obj.removeRange(76,82);
		obj.addRange(37,55);obj.addRange(30,97);obj.addRange(1,36);
		System.out.println(obj.queryRange(18,96));
		obj.removeRange(45,86);obj.addRange(74,92);
		System.out.println(obj.queryRange(27,78));
		obj.addRange(31,35);
		System.out.println(obj.queryRange(87,91));
		obj.removeRange(37,84);obj.removeRange(26,57);
		obj.addRange(65,87);obj.addRange(76,91);
		System.out.println(obj.queryRange(37,77));
		System.out.println(obj.queryRange(18,66));
		obj.addRange(22,97);obj.addRange(2,91);obj.removeRange(82,98);
		obj.removeRange(41,46);obj.removeRange(6,78);
		System.out.println(obj.queryRange(44,80));
		obj.removeRange(90,94);obj.removeRange(37,88);
		obj.addRange(75,90);
		System.out.println(obj.queryRange(23,37));
		obj.removeRange(18,80);obj.addRange(92,93);obj.addRange(3,80);
		System.out.println(obj.queryRange(68,86));
		obj.removeRange(68,92);
		System.out.println(obj.queryRange(52,91));

	}

}

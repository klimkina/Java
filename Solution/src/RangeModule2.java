import java.util.Map;
import java.util.TreeMap;

public class RangeModule2 {
	    private TreeMap<Integer, Integer> range = new TreeMap<>();
	    public RangeModule2() {
	        
	    }
	    
	    public void addRange(int left, int right) {
	        if (range.isEmpty())
                range.put(left, right);
            else
            {
                Integer lk = range.floorKey(left);
                if (lk != null && range.get(lk) >= left)
                {                    
                    left = lk;
                    right = Math.max(range.get(lk), right);
                    range.put(lk, right);                    
                }
                else
                    range.put(left, right);
                Integer rk = range.higherKey(left);
                while (rk != null && rk <= right)
                {
                    right = Math.max(range.get(rk), right);
                    range.put(left, right);
                    range.remove(rk);
                    rk = range.higherKey(left);
                }
                
            }
	    }
	    
	    public boolean queryRange(int left, int right) {
	    	
            Integer lk = range.floorKey(left);
            return (lk != null && range.get(lk) >= right);
                
	    }
	    
	    public void removeRange(int left, int right) {
	    	if (!range.isEmpty())
            {
                Integer lk = range.lowerKey(left);
                if (lk != null)
                {
                    int lk_r = range.get(lk);
                    if (lk_r > left)
                    {
                        range.put (lk, left);
                        if (lk_r > right)
                            range.put(right, lk_r);
                    }                
                }
                Integer rk = range.ceilingKey(left);
                while (rk != null && rk < right)
                {
                    int rk_r = range.get(rk);
                    if (rk_r > right)
                        range.put (right, rk_r);
                    range.remove(rk);
                    
                    rk = range.ceilingKey(left);
                }
            }
	    }
        private void printIntervals() {
	    	for(Map.Entry<Integer,Integer> entry : range.entrySet()) {
	    		  System.out.print(entry.getKey() + " => " + entry.getValue() + ",");
			}
	    	System.out.println();
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeModule2 obj = new RangeModule2();
		obj.addRange(9,10);
		obj.addRange(25,27);
		obj.addRange(30,73);
		obj.addRange(99,100);
		obj.addRange(10,73);
		obj.removeRange(1,40);
		obj.removeRange(8,9);
		obj.addRange(8,9);
		obj.removeRange(1,3);
		obj.addRange(1,8);
		obj.queryRange(2,4);
		obj.queryRange(2,9);
		obj.queryRange(4,6);

	}

}

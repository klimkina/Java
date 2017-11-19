import java.util.HashMap;
import java.util.TreeMap;

public class MyCalendar {
	TreeMap<Integer, Integer> myCal;
	TreeMap<Integer, Integer> myCal2;
	public MyCalendar() {
		myCal = new TreeMap<>(); 
		myCal2 = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
    	Integer prev_start = myCal.floorKey(start);
    	Integer prev_end = 0;
    	if(prev_start != null)
    		prev_end = myCal.get(prev_start);
    	Integer next_start = myCal.higherKey(start);
    	if((prev_start != null && prev_end != null && prev_end > start) || (next_start != null && next_start < end)) {
    		if (prev_start != null && prev_end != null && prev_end > start)//need to add start to prev_end
    			if(!checkBook2(start, Math.min(end, prev_end)))
    				return false;
    		if((next_start != null && next_start < end)) //need to add next_start to end
    			if(!checkBook2(Math.max(start, next_start), end))
    				return false;
    		if (prev_start != null && prev_end != null && prev_end > start) {//need to add start to prev_end
    			book2(start, Math.min(end, prev_end));
    			if(end > prev_end) {
    				myCal.put(prev_start, end);
    			}
    		}
    		if((next_start != null && next_start < end)) {//need to add next_start to end
    			book2(Math.max(start, next_start), end);
    			if(start < next_start) {
    				Integer next_end = myCal.get(next_start);
        			myCal.remove(next_start);
        			myCal.put(start, next_end);
    			}
    		}
    		if((prev_start != null && prev_end != null && prev_end > start) && (next_start != null && next_start < end)) {
    			//prev_end to next_start
    			Integer next_end = myCal.get(next_start);
    			myCal.remove(next_start);
    			myCal.put(prev_start, next_end);
    		}
    		return true;
    	}
    	if(prev_start != null && prev_end != null && prev_end == start)
    		myCal.put(prev_start, end);
    	else if (next_start != null && next_start == end) {
    		Integer next_end = myCal.get(next_start);
    		myCal.remove(next_start);
    		myCal.put(start, next_end);
    	}
    	else
    		myCal.put(start,  end);
        return true;
    }
    public boolean checkBook2(int start, int end) {
    	Integer prev_start = myCal2.floorKey(start);
    	Integer prev_end = 0;
    	if(prev_start != null)
    		prev_end = myCal2.get(prev_start);
    	Integer next_start = myCal2.higherKey(start);
    	if((prev_start != null && prev_end != null && prev_end > start) || (next_start != null && next_start < end))
    		return false;
        return true;
    }
    public boolean book2(int start, int end) {
    	Integer prev_start = myCal2.floorKey(start);
    	Integer prev_end = 0;
    	if(prev_start != null)
    		prev_end = myCal2.get(prev_start);
    	Integer next_start = myCal2.higherKey(start);
    	if((prev_start != null && prev_end != null && prev_end > start) || (next_start != null && next_start < end))
    		return false;
    	if(prev_start != null && prev_end != null && prev_end == start)
    		myCal2.put(prev_start, end);
    	else if (next_start != null && next_start == end) {
    		Integer next_end = myCal2.get(next_start);
    		myCal2.remove(next_start);
    		myCal2.put(start, next_end);
    	}
    	else
    		myCal2.put(start,  end);
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalendar cal = new MyCalendar();
		
		if(!cal.book(47, 50))
			System.out.println("Error 1!"); // returns true
		if(!cal.book(1, 10))
			System.out.println("Error 2!"); // returns true
		if(!cal.book(27, 36))
			System.out.println("Error 3!"); // returns false
		if(!cal.book(40, 47))
			System.out.println("Error 4!"); // returns true
		if(!cal.book(20, 27))
			System.out.println("Error 5!"); // returns true
		if(!cal.book(15, 23))
			System.out.println("Error 6!"); // returns true
		if(!cal.book(10, 18))
			System.out.println("Error 7!"); // returns true
		if(!cal.book(27, 36))
			System.out.println("Error 8!"); // returns true
		if(cal.book(17, 25))
			System.out.println("Error 9!"); // returns true
		if(cal.book(8, 17))
			System.out.println("Error 10!"); // returns true
		System.out.println("Good!");
	}

}

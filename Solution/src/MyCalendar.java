import java.util.HashMap;
import java.util.TreeMap;

public class MyCalendar {
	TreeMap<Integer, Integer> cal1 = new TreeMap<>();
    TreeMap<Integer, Integer> cal2 = new TreeMap<>();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if (intersect(cal2, start, end))
            return false;
        add(cal1, start, end);
        return true;
    }
    private boolean intersect(TreeMap<Integer, Integer> cal, int start, int end)
    {
        Integer u = cal.lowerKey(end);
        if (u != null && (cal.get(u) > start))
            return true;
        return false;
    }
    private void add(TreeMap<Integer, Integer> cal, int start, int end)
    {
        Integer u = cal.lowerKey(end);
        while(u != null && cal.get(u) > start)
        {
            cal2.put(Math.max(start, u), Math.min(end,cal.get(u)));
            cal1.put(u, Math.max(end,cal.get(u)));
            end = u;
            if (end > start)
                u = cal.lowerKey(end);
            else
                return;
        }
        cal1.put(start, end);        
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

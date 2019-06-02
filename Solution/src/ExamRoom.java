import java.util.TreeMap;

class ExamRoom {
	TreeMap<Integer, Integer> map = new TreeMap<>();
    int max = 0;
    public ExamRoom(int N) {
        max = N;
    }
    
    public int seat() {
        if (map.size() == 0)
        {
            map.put(0, 1);
            return 0;
        }
        Integer min = map.firstKey();
        int start = 0;
        int prev = 0;
        
        Integer next = map.higherKey(0);
        
        while (next != null)
        {
            if ((next - prev)/2 > min)
            {
                start = prev;
                min = (next - prev)/2;
            }
            prev = next;
            next = map.higherKey(next);
        }
        if (min == 0 || (max - prev-1) > min)
        {
        	map.put(max-1, 1);
            return max-1;
        }
        else if (start == 0 && map.firstKey() != 0)
        {
        	map.put(0, 1);
        	return 0;
        }
        else
            next = map.higherKey(start);
        int res = start + (next-start)/2;
        map.put(res, 1);
        return res;
    }
    
    public void leave(int p) {
        if (map.containsKey(p))
            map.remove(p);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExamRoom obj = new ExamRoom(4);
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		obj.leave(1);
		obj.leave(3);
		System.out.println(obj.seat());
	}

}

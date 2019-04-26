import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
private HashMap<String, Integer> map = new HashMap<>();
    
    public int numberOfPatterns(int m, int n) {
        map.put("1 3", 2); map.put("1 9", 5); map.put("1 7", 4);
        map.put("3 1", 2); map.put("3 7", 5); map.put("3 9", 6);
        map.put("7 1", 4); map.put("7 3", 5); map.put("7 9", 8);
        map.put("9 1", 5); map.put("9 3", 6); map.put("9 7", 8);
        map.put("2 8", 5); 
        map.put("4 6", 5); 
        map.put("8 2", 5); 
        map.put("6 4", 5); 
        
        int res = numberOfPatterns(m, n, new HashSet<>(), 1);
        res += numberOfPatterns(m, n, new HashSet<>(), 2);
        res *= 4;
        res += numberOfPatterns(m, n, new HashSet<>(), 5);
        return res;
    }
    private int numberOfPatterns(int m, int n, HashSet<Integer> set, int curr)
    {       
        set.add(curr);
        if (set.size() == n)
            return 1;
        int res = 0;
        if (set.size() >= m)
            res++;
        for (int i = 1; i <= 9; i++)
        {
            if (!set.contains(i))
                if (map.get(curr + " " + i) == null || set.contains(map.get(curr + " " + i)))
                { 
                    res += numberOfPatterns(m, n, set, i);
                    set.remove(i);
                }
            
        }
        return res;
    }
	
	public static void main(final String[] args) {
		
	}
}

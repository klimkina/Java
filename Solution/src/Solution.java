import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static class LRUCache {
		static Map<Integer, Integer> map;
		static int capacity;
	    public LRUCache(int capacity) {
	        this.capacity =  capacity;
	        map = new LinkedHashMap<>();
	    }
	    
	    public static int get(int key) {
	        Integer val = map.get(key);
	        if (val == null)
	            return -1;
	        map.remove(key);
	        map.put(key, val);
	        return val;
	    }
	    
	    public static void put(int key, int value) {
	        if (map.containsKey(key))
	            map.remove(key);
	        else if(map.size() == capacity)
	        {
	            int k = map.keySet().iterator().next();
	            map.remove(k);
	        }
	        map.put(key, value);
	    }
	}
		
    public static void main(String[] args) {
    	LRUCache obj = new LRUCache(2);
    	obj.put(2,6);
    	System.out.println(obj.get(1));
    	obj.put(1,5);
    	System.out.println(obj.get(1));
    	obj.put(1,2);
    	System.out.println(obj.get(2));
    	
    	System.out.println(obj.get(1));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

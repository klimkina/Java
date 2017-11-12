import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MapSum {
	 private HashMap hm;
    /** Initialize your data structure here. */
    public MapSum() {
    	hm = new HashMap();
    }
    
    public void insert(String key, int val) {
    	hm.put(key, val);
    }
    
    public int sum(String prefix) {
    	int res = 0;
    	Pattern p = Pattern.compile("^" + prefix +".*");
    	// Get a set of the entries
        Set set = hm.entrySet();
        
        // Get an iterator
        Iterator i = set.iterator();
        
        // Display elements
        while(i.hasNext()) {
           Map.Entry me = (Map.Entry)i.next();
           String str = me.getKey().toString();
           Matcher m = p.matcher(str);
           if(m.matches())
           		res += (int)me.getValue();
        }
        return res;
    }
    public static void main(String[] args) {
    	MapSum obj = new MapSum();
    	obj.insert("a", 3);
    	System.out.println(obj.sum("ap"));
    	obj.insert("b", 2);
    	System.out.println(obj.sum("ap"));
    	obj.insert("app", 2);
    	System.out.println(obj.sum("a"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

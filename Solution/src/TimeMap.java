import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tree = map.get(key);
        if (tree == null)
        {
            tree = new TreeMap<>();
            map.put(key, tree);
        }
        tree.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tree = map.get(key);
        if (tree == null)
            return null;
        Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
        if(entry == null)
        	return "";
        return entry.getValue();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeMap obj = new TimeMap();
		obj.set("love","high",10);
		obj.set("love","low",20);
		System.out.println(obj.get("love", 5));
		System.out.println(obj.get("love", 10));
		System.out.println(obj.get("love", 15));
		System.out.println(obj.get("love", 20));
		System.out.println(obj.get("love", 25));
	}

}

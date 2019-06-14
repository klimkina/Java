import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;


class Solution {
	public int shortestWay(String source, String target) {
		int m = source.length(), n = target.length();
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < m;i++) {
            char c = source.charAt(i);
            if(!map.containsKey(c)) map.put(c,new TreeSet<>());
            map.get(c).add(i);
        }
        int curr = -1, res = 0;
        for(int i = 0; i < n;i++) {
            TreeSet<Integer> ts = map.get(target.charAt(i));
            if(ts == null) return -1;
            Integer temp = ts.higher(curr);
            if(temp == null) {
                res++;
                curr = ts.first();
            } else {
                curr = temp;    
            }
        }
        return res+1;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String source = "xyz", target = "xzyxz";
		System.out.println(obj.shortestWay(source, target));
		
	}
}

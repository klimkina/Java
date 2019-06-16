import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> prevs = new HashMap<>();
        for(int i = 0; i < values.length; i++)
        {
            TreeMap tree;
            if (map.containsKey(labels[i]))
            {
                tree = map.get(labels[i]);
                int k = 0;
                if(tree.get(values[i]) != null)
                    k = (int)tree.get(values[i]);
                tree.put(values[i], k +1);
            }
            else
            {
                tree = new TreeMap<>();
                map.put(labels[i], tree);
                tree.put(values[i], 1);
                prevs.put(labels[i], Integer.MAX_VALUE);
            }
        }
        HashMap<Integer, Integer> used = new HashMap<>();
        
        int sum = 0;
        for (int i = 0; i < num_wanted; i++)
        {
            int max = Integer.MIN_VALUE;
            int max_label = -1;
            for(int j : map.keySet())
                if(used.getOrDefault(j,  0) < use_limit)
                {
                    Integer t = (Integer)map.get(j).floorKey(prevs.get(j));
                    if (t != null && t > max)
                    {
                        max = t;
                        max_label = j;
                    }
                }
            if (map.get(max_label).get(max) == 1)
                map.get(max_label).remove(max);
            else
            	map.get(max_label).put(max, map.get(max_label).get(max) - 1);
            prevs.put(max_label, max);
            sum += max;
            used.put(max_label, used.getOrDefault(max_label, 0)+1);
        }
        return sum;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[] values = {0,6,7,5,7}, labels = {2,0,2,0,2};
		int num_wanted = 3, use_limit = 4;
		System.out.println(obj.largestValsFromLabels(values, labels, num_wanted, use_limit));
		
	}
}

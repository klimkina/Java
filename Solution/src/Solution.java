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

// Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.

// In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].

// If there is no way to make arr1 strictly increasing, return -1.
class Solution {
	public List<Integer> classifySignals(List<Integer> freq_standard, List<Integer> freq_signals) {
	    // Write your code here
		List<Integer> res = new ArrayList<>();
		if (freq_standard.isEmpty() || freq_signals.isEmpty())
			return res;
		TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int i =0; i < freq_standard.size(); i++)
            tree.put(freq_standard.get(i), i + 1);
        
        for (int f : freq_signals)
        {
            Integer low = tree.floorKey(f);
            Integer high = tree.ceilingKey(f);
            if (low == null)
                res.add(tree.get(high));
            else if (high == null)
                res.add(tree.get(low));
            else
            {
                if (high - f <= f - low)
                    res.add(tree.get(high));
                else
                    res.add(tree.get(low));
            }
        }
        return res;
    }

    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		Integer[] arr1 = {7, 1 ,12, 9 ,15};
		Integer[] arr2 = {2, 9, 2000, 13, 4};
		List<Integer> res = obj.classifySignals(Arrays.asList(arr1),Arrays.asList(arr2));
		for (int i: res)
			System.out.print(i + " ");
	}
}

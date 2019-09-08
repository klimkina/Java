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
	public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i : arr2)
            tree.put(i, tree.getOrDefault(i, 0) + 1);
        Arrays.sort(arr2);
        int n = arr1.length;
        
        HashMap<Integer, Integer> ends = new HashMap<>();
        ends.put(arr1[0], 0);
        if (arr2[0] < arr1[0])
            ends.put(arr2[0], 1);
        
        for (int i = 1; i < n; i++)
        {
            HashMap<Integer, Integer> ends2 = new HashMap<>();
            for (int k : ends.keySet())
            {
                if (arr1[i] > k &&(!ends2.containsKey(arr1[i]) || ends2.get(arr1[i]) > ends.get(k)))
                    ends2.put(arr1[i], ends.get(k));
                Integer next = tree.higherKey(k);
                if (next != null)
                {
                    if (!ends2.containsKey(next) || ends2.get(next) > ends.get(k))
                        ends2.put(next, ends.get(k) + 1);
                }
            }
            if (ends2.isEmpty())
                return -1;
            ends = ends2;
        }
        int min = arr2.length + 1;
        for (int k : ends.keySet())
            if (ends.get(k) < min)
                min = ends.get(k);
        return min;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[] arr1 = {1,5,3,6,7};
		int[] arr2 = {3,1,4};
		System.out.println(obj.makeArrayIncreasing(arr1, arr2));
	}
}

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
	public int countPowerfulSubarrays(List<Integer> arr) {
	    // Write your code here
		int[] masks = new int[32];
        int mask = 1;
        for (int i = 0; i < 32; i++)
        {
            masks[i] = mask;
            mask <<= 1;
        }
            
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int cumm = 0;
        map.put(0,  1);
        for (int i : arr)
        {
            cumm ^= i;
            for (int j = 0; j < 32; j++)
            {
                int res = masks[j]^cumm;
                if (map.containsKey(res))
                    count += map.get(res);
            }
            map.put(cumm, map.getOrDefault(cumm, 0) + 1);
        }
        return count;
	}	
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		Integer[] arr = {1,2,3,4,5};
		
		System.out.println(obj.countPowerfulSubarrays(Arrays.asList(arr)));
	}
}

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
	public String validate(List<List<Integer>> data) {
	    // Write your code here
			
			Set<Integer> rows[] = new HashSet[9];
			Set<Integer> cols[] = new HashSet[9];
			Set<Integer> squares[] = new HashSet[9];
			for (int i = 0; i < 9; i++)
			{
				rows[i] = new HashSet<>();
				cols[i] = new HashSet<>();
				squares[i] = new HashSet<>();
						
			}
			for (List<Integer> l : data)
			{
				int r = l.get(0)-1;
				int c = l.get(1)-1;
				int v = l.get(2);
				int sq = 3*(r/3) + c/3;
				if (rows[r].contains(v) || cols[c].contains(v) || squares[sq].contains(v))
					return "WRONG INPUT";
				rows[r].add(v);
				cols[c].add(v);
				squares[sq].add(v);
			}
			return "OK";
	    }

    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		List<Integer> arr1 = Arrays.asList(3,1,3);
		List<Integer> arr2 = Arrays.asList(2, 8,3);
		List<Integer> arr3 = Arrays.asList(1,4,3);
		List<Integer> arr4 = Arrays.asList(7,2,3);
		List<Integer> arr5 = Arrays.asList(6,3,3);
		List<Integer> arr6 = Arrays.asList(5,5,3);
		List<Integer> arr7 = Arrays.asList(4,7, 3);
		List<Integer> arr8 = Arrays.asList(8,6,3);
		List<Integer> arr9 = Arrays.asList(9,9,3);
		
		List<List<Integer>> arr = Arrays.asList(arr1, arr2, arr3, arr4,arr5,arr6,arr7,arr8,arr9);
		System.out.println(obj.validate(arr));
	}
}

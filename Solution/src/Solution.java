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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        HashMap<Integer, Integer> used = new HashMap<>();
        for(int i = 0; i < values.length; i++)
        {
            pq.offer(new int[]{values[i],labels[i]});
            
        }
        int sum = 0;
        int i = 0;
        while (i < num_wanted && !pq.isEmpty())
        {
            int[] max = pq.poll();
            if (used.getOrDefault(max[1], 0) < use_limit)
            {
                sum += max[0];
                used.put(max[1], used.getOrDefault(max[1], 0) + 1);
                i++;
            }
        }
        return sum;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String str1 = "abac", str2 = "cab";
		int[] values = {0,6,7,5,7}, labels = {2,0,2,0,2};
		int num_wanted = 3, use_limit = 4;
		System.out.println(obj.shortestCommonSupersequence(str1, str2));
		
	}
}

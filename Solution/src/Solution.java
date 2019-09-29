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
	public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++)
            costs[i] = Math.abs(t.charAt(i) - s.charAt(i));
        int len = 0;
        int start = 0;
        int cost = 0;
        for (int i = 0; i < n; i++)
        {
            cost += costs[i];
            while(cost > maxCost)
            {
                cost -= costs[start++];
            }
            len = Math.max(len, i-start+1);
        }
        return len;
    }

	public static void main(String[] args) {   	
		Solution obj = new Solution();
		
		System.out.println(obj.equalSubstring("abcd", "acde", 0));
	}
}

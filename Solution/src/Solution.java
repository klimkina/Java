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
	public String removeDuplicates(String s, int k) {
        int n = s.length();
        int[] pos = new int[n+1];
        for (int i = 0; i <= n; i++)
            pos[i] = i;
        boolean removed = true;
        while (removed)
        {
            removed = false;
            int start = pos[0];
            int prev = 0;
            while (start < n)
            {
                char ch = s.charAt(pos[start]);
                int count = 1;
                while (start < n && count < k)
                {
                    start = pos[start+1];
                    if (s.charAt(start) != ch)
                    {
                        count = 1;
                        ch = s.charAt(start);
                        prev = start;
                    }
                    else
                        count++;
                }
                if (count == k)
                {
                    pos[prev] = pos[start+1];
                    removed = true;
                    start = pos[start+1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = pos[0];
        while (start < n)
        {
            sb.append(s.charAt(start));
            start = pos[start+1];
        }
        return sb.toString();
    }

	public static void main(String[] args) {   	
		Solution obj = new Solution();
		
		System.out.println(obj.removeDuplicates("pbbcggttciiippooaais", 2));
	}
}

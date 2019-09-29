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
	private class Sound implements Comparable<Sound>
	{
		Integer strength;
		Integer dist;
		public Sound(int s, int d)
		{
			strength = s;
			dist = d;
		}
		@Override
	    public int compareTo(Sound other){
			return -this.strength + other.strength;
		}
	}
	
	public long minSound(List<Integer> strengths, List<Integer> threshold_dist) {
	    // Write your code here
		int res = 0;
		PriorityQueue<Sound> pq = new PriorityQueue<>();
		int n = strengths.size();
		for (int i = 0; i < strengths.size(); i++)
		{
			int s = strengths.get(i);
			int t = threshold_dist.get(i);
			if (t < 1)
				continue;
			if (t > strengths.size())
			{
				res += s;
				n--;
			}
			else
				pq.offer(new Sound(s, t));
		}
		int[] dists = new int[n];
		int start = 0;
		while (!pq.isEmpty())
		{
			Sound s = pq.poll();
			if (!found(s, dists))
			{
				res += s.strength;
				while(dists[start] == 1)
					start++;
				dists[start++] = 1;
			}
		}
		
		return res;
	}	
    private boolean found(Sound s, int[] dists)
    {
    	int idx = s.dist-1;
    	while (idx < dists.length && dists[idx] > 0)
    		idx++;
    	if (idx >= dists.length)
    		return false;
    	dists[idx] = 1;
    	return true;
    }
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		Integer[] str = {2, 3, 2, 2, 5};
		Integer[] thr = {2, 3, 4, 5, 5};
		
		System.out.println(obj.minSound(Arrays.asList(str), Arrays.asList(thr)));
	}
}

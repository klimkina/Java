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
        for (int i = 0; i < n; i++)
        {
            int s = strengths.get(i);
            int t = threshold_dist.get(i);
            
            pq.offer(new Sound(s, t));
        }
        TreeSet<Integer> dists = new TreeSet<>();
        for (int i = 0; i < strengths.size(); i++)
            dists.add(i);
        int start = 0;
        while (!pq.isEmpty())
        {
            Sound s = pq.poll();
            Integer low = dists.ceiling(s.dist);
            if (low == null)
            {
                res += s.strength;
                dists.pollFirst();
            }
            else
                dists.remove(low);
        }
        
        return res;
	}

	public static void main(String[] args) {   	
		Solution obj = new Solution();
		
		System.out.println(obj.removeDuplicates("pbbcggttciiippooaais", 2));
	}
}

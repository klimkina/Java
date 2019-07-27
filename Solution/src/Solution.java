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
	public int minimumCost(int N, int[][] conections) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < conections.length; i++)
        {
            int[] conn = conections[i];
            if (!graph.containsKey(conn[0]))
                graph.put(conn[0], new HashMap<>());
            graph.get(conn[0]).put(conn[1], conn[2]);
            if (!graph.containsKey(conn[1]))
                graph.put(conn[1], new HashMap<>());
            graph.get(conn[1]).put(conn[0], conn[2]);
        }
        Set<Integer> min_cut = new HashSet<>();
        min_cut.add(1);
        int res = 0;
        while (min_cut.size() < N)
        {
            int min_v = 0;
            int min_w = Integer.MAX_VALUE;
            for(int w : min_cut)
            {
                for(int adj : graph.get(w).keySet())
                {
                    if (!min_cut.contains(adj))
                    {
                        if (graph.get(w).get(adj) < min_w)
                        {
                            min_w = graph.get(w).get(adj);
                            min_v = adj;
                        }
                    }
                }
            }
            if (min_w == Integer.MAX_VALUE)
                return -1;
            min_cut.add(min_v);
            res += min_w;
        }
        return res;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] arr = {{}};
		System.out.println(obj.minimumCost(5120, arr));
	}
}

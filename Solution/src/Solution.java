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
	public int minimumSemesters(int N, int[][] relations) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        HashMap<Integer, Set<Integer>> di_graph = new HashMap<>();
        for (int[] rel : relations)
        {
            if (!graph.containsKey(rel[1]))
                graph.put(rel[1], new HashSet<>());
            graph.get(rel[1]).add(rel[0]);
            if (!di_graph.containsKey(rel[0]))
                di_graph.put(rel[0], new HashSet<>());
            di_graph.get(rel[0]).add(rel[1]);
        }
        int start = -1;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            if (!di_graph.containsKey(i))
                q.offer(i);
        if (q.isEmpty())
            return -1;
        int rank = 0;
        HashSet<Integer> passed = new HashSet<>();
        while (!q.isEmpty())
        {
            int sz = q.size();
            for(int i = 0; i < sz; i++)
                System.out.print(q.get(i) + " ");
            System.out.println();
            for(int i = 0; i < sz; i++)
            {
                int next = q.poll();
                boolean pre = true;
                if (di_graph.containsKey(next))                    
                {
                    for(int p : di_graph.get(next))
                        if (!passed.contains(p))
                        {
                            pre = false;
                            break;
                        }
                    
                }
                if (pre)
                {
                    passed.add(next);
                    if (graph.containsKey(next))
                        for(int w : graph.get(next))
                            if (!passed.contains(w))
                                q.offer(w);
                }
                else
                    q.offer(next);
            }
            rank++;
        }
        return passed.size() == N ? rank : -1;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] arr = {{}};
		System.out.println(obj.minimumCost(5120, arr));
	}
}

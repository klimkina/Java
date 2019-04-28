import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class Solution {
	public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashMap<Integer, Set<Integer>> blocked_map = new HashMap<>();
        for (int i = 0; i < blocked.length; i++)
        {
            if (blocked_map.get(blocked[i][0]) == null)
                blocked_map.put(blocked[i][0], new HashSet<Integer>());
            blocked_map.get(blocked[i][0]).add(blocked[i][1]);
        }
        return bfs(blocked_map, source, target) && bfs(blocked_map, target, source);
    }
    private static boolean bfs(HashMap<Integer, Set<Integer>> blocked, int[] s, int[] t)
    {
    	HashMap<Integer, Set<Integer>> visited = new HashMap<>();
    	Queue<int[]> queue = new LinkedList<>();
        queue.add(s);
        int steps = 0;
        Set<Integer> set0 = new HashSet<>();
        set0.add(s[1]);
        visited.put(s[0], set0);
        
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()) {
            Queue<int[]> nextQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                //System.out.println(cur[0] + "," + cur[1]);
                
                for(int k = 0; k < dirs.length; ++k) {
                    int nextx = cur[0] + dirs[k][0];
                    int nexty = cur[1] + dirs[k][1];
                    if(inBound(nextx, nexty) && !contains(blocked, nextx, nexty))
                    {	                    	                    
	                    if(nextx == t[0] && nexty == t[1]) 
	                        return true;
	                    
	                    if(!contains(visited, nextx, nexty)) {
                            if (visited.get(nextx) == null)
                            	visited.put(nextx, new HashSet<>());
                            visited.get(nextx).add(nexty);
                        }
                        nextQueue.add(new int[]{nextx, nexty});	                    
                    }
                }        
            }
            queue = nextQueue;
            steps++;
            if(steps > 20000) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean contains(HashMap<Integer, Set<Integer>> map, int x, int y)
    {
        if (map.get(x) != null)
            return map.get(x).contains(y);
        return false;
    }
    private static boolean inBound(int x, int y)
    {
        return x >= 0 && y >= 0 && x < 1000000 && y < 1000000;
    }
	
	public static void main(final String[] args) {
		int[][] blocked = {{0,1},{1,0}};
		int[] source = {0,0}, target = {0,2};
		System.out.println(isEscapePossible(blocked, source, target));
	}
}

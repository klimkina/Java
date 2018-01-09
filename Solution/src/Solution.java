import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	private Set<Integer>[] adj;
	private boolean[] marked;
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<>();
		marked = new boolean[n];
		adj = (Set<Integer>[])new HashSet[n];
		for(int i = 0; i < edges.length; i++) {
			if(adj[edges[i][0]] == null)
				adj[edges[i][0]] = new HashSet();
			if(adj[edges[i][1]] == null)
				adj[edges[i][1]] = new HashSet();
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}
		int min = Integer.MAX_VALUE;
		int[] heights = new int[n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(marked, false);
			heights[i] = findHeight(i);
			if(heights[i] < min)
				min = heights[i];
		}
		for(int i = 0; i < n; i++)
			if(heights[i] == min)
				res.add(i);
        return res;
    }
	private int findHeight(int i) { // dfs
		marked[i] = true;
		int max = 0;
		int temp;
		for(int v: adj[i])
			if(!marked[v]) {
				temp = findHeight(v) + 1;
				if(max < temp)
					max = temp;
			}
		return max;
	}
	    
    public static void main(String[] args) {   	
    	int[][] edges = {{0, 1}};
    	Solution obj = new Solution();
    	List<Integer> res = obj.findMinHeightTrees(2, edges);
    	if(res != null)
	    	for(int i : res)
	    		System.out.print(i + " ");
    }
}
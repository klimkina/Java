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
		if(n == 1) {
			res.add(0);
			return res;
		}
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
		int[] degree = new int[n];  //degree
        for(int i=0; i<n; i++) 
        	degree[i]=adj[i].size();
        
        for(int remain=n, j; remain>2;){
            ArrayList<Integer> del = new ArrayList<>(); // nodes to delete
            for(j=0; j<n; j++){
                if(degree[j]==1) { //find leaves
                    remain--;
                    del.add(j);
                    degree[j]=-1;
                }
            }
            for(int k: del){ //delete this node and its edges 
                for(int neigh: adj[k]) 
                	degree[neigh]--;
            }
        }
        for(int i=0; i<n; i++) 
        	if(degree[i]>=0) res.add(i);
        return res;
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
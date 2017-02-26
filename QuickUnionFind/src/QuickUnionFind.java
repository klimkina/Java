//import src.QuickUnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class QuickUnionFind {
	private int[] id;
	private int[] sz;
	private int[] max;
	private int n;
	
	 public QuickUnionFind(int N)
	 {
		 n = N;
		 id = new int[N];
		 sz = new int [N];
		 max = new int[N];
		 for (int i = 0; i < N; i++) {
			 id[i] = i;
			 sz[i] = 1;
			 max[i] = i;
		 }
	 }
	 
	 private int root(int i)
	 {
		 while (i != id[i]){
			 id[i] = id[id[i]];//path compression
			 i = id[i];
		 }
		 return i;
	 }
	 
	 public boolean connected(int p, int q)
	 {
		 return root(p) == root(q);
	 }
	 
	 public void union(int p, int q)
	 {
		 int i = root(p);
		 int j = root(q);
		 
		 int temp = Math.max(max[i], max[j]);	 
		 
		 if (i == j) return;
		 
		 if (sz[i] < sz[j]) { // balance tree
			 id[i] = j; sz[j] += sz[i]; 
			 max[j] = temp;
		 }
		 else { 
			 id[j] = i; sz[i] += sz[j]; 
			 max[i] = temp;
		 } 
		 
	 }
	 
	 public int find(int i)
	 {
	    return max[root(i)];
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of unions!");
		int N = StdIn.readInt();
		QuickUnionFind uf = new QuickUnionFind(N);
		
		 while (!StdIn.isEmpty())
		 {
			 int p = StdIn.readInt();
			 int q = StdIn.readInt();
			 if (!uf.connected(p, q))
			 {
				 uf.union(p, q);
				 //StdOut.println(p + " " + q);
			 }
			 StdOut.println(uf.find(p));
		 }
	}

}

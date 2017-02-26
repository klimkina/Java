
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class SuccessorDelete {
	private int[] id;
	private int[] sz;
	private int[] max;
	
	 public SuccessorDelete(int N)
	 {
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
	 
	 public int delete (int x)
	 {
		 if(x < id.length - 1)
		 {
			 union (x, x+1);
			 int res = find(x);
			 if (res < id.length - 1) 
				 return res;
		 }
		 return -1;//last element has no successors
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of unions!");
		int N = StdIn.readInt();
		SuccessorDelete sd = new SuccessorDelete(N);
		
		 while (!StdIn.isEmpty())
		 {
			 int x = StdIn.readInt();
			 
			 
			 StdOut.println(sd.delete(x));
		 }
	}

}
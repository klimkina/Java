import java.util.PriorityQueue;
/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.*/
public class KthSmallestSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j < n; j++) // build minHeap from the first row
        	pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) { // remove  k-1 smallest elements
            Tuple t = pq.poll();
            if(t.row == n-1) continue; // last row, just remove it
            pq.offer(new Tuple(t.row+1, t.col, matrix[t.row+1][t.col]));
        }
	        
        return pq.poll().val;
	}

    public static class Tuple implements Comparable<Tuple> {
	    int row, col, val;
	    public Tuple (int x, int y, int val) {
	        this.row = x;
	        this.col = y;
	        this.val = val;
	    }
	    
	    @Override
	    public int compareTo (Tuple that) {
	        return this.val - that.val;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2}, {1,3}}; //{{1,5,9},{10,11,13},{12,13,15}}; // -> 13
		int k = 2;
		KthSmallestSortedMatrix obj = new KthSmallestSortedMatrix();
		System.out.println(obj.kthSmallest(matrix, k));
	}

}

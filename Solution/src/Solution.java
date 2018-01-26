import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static class IndexedArray implements Comparable<IndexedArray>{
		int val;
		int idx;
		public IndexedArray(int v, int i) {
			val = v;
			idx = i;
		}
		@Override
		public int compareTo(IndexedArray that) {
			return this.val - that.val;
		}
	}
	public static class BeautySet{
		int start;
		int end;
		public BeautySet(int val) {
			start = val;
			end = val;
		}
		public void increment() {
			end++;
		}
		public int min() {
			return start;
		}
		public int max() {
			return end;
		}
		public int split(int val) {
			end = val-1;
			return end;
		}
	}
    static int arrayAndQueries(int[] A, int[][] queries) {
        // Complete this function
    	List<IndexedArray> list = new ArrayList<>();
    	for(int i = 0; i < A.length; i++)
    		list.add(new IndexedArray(A[i], i));
    	Collections.sort(list);
    	HashMap<Integer, Integer> idxToSet = new HashMap<>();
    	List<BeautySet> sets = new ArrayList<>();
    	for(int i = 0; i < list.size(); i++) {
    		
    	}
    	return 0;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextInt();
            }
        }*/
    	int[] A = {2, 2, 1, 1, 1};
    	int[][] queries = {{3, 2},
    			{5, 5}};
        int result = arrayAndQueries(A, queries);
        System.out.println(result);
        //in.close();
    }
}

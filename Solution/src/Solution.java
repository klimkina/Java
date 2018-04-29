import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[] merge (int[] A, int[] B)
	{
		int[] C = new int[A.length + B.length];
		int a_pos = 0;
		int b_pos = 0;
		for(int i = 0; i < C.length; i++)
			if (a_pos < A.length && (b_pos >= B.length || A[a_pos] < B[b_pos])) C[i] = A[a_pos++];
			else C[i] = B[b_pos++];
		return C;
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
    	int[] A = {1,5,7,12,18,32};

    	int[] B = {2,4,9,16,27,76,98};
    	Solution obj =  new Solution();
    	int[] C = obj.merge(A,  B);
    	for(int i = 0; i < C.length; i++)
    		System.out.println(C[i]);
        //in.close();
    }
}

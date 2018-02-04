import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int kthGrammar(int N, int K) {
		if(N == 1 && K == 1)
			return 0;
		int half_len = 1 << (N-2);
		if(K > half_len) // reverse
			return kthGrammar(N-1, K - half_len) == 0 ? 1 : 0;
        return kthGrammar(N-1, K);
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
    	Solution obj =  new Solution();
        int result = obj.kthGrammar(1, 1);
        System.out.println(result);
        //in.close();
    }
}

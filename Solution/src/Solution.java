import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	public String splitChunk(String str) {
		Stream<String> stream = Stream.of(str.split("\r"));
		return stream.collect(Collectors.joining("\r\n"));
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
    	String myStr = "Quick Brown Fox\rJumps over a red box\rMila";
    	Solution obj =  new Solution();
    	String res = obj.splitChunk(myStr);
    	System.out.println(res);
    }
}

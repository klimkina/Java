import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	private static int[] merge(int[] A, int[] B)
	{
		int currA = 0;
		int currB = 0;
		int[] C = new int[A.length + B.length];
		for(int i = 0; i < C.length; i++)
			if(currA < A.length)
			{
				if(currB < B.length && A[currA] > B[currB])
					C[i] = B[currB++];
				else
					C[i] = A[currA++];
			}
			else
				C[i] = B[currB++];
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
    	int[] C = merge(A, B);
    	String res = Arrays.stream(C).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	System.out.println(res);
    	for(int i = 0; i < C.length; i++)
    		System.out.print(C[i] + " ");
    }
}

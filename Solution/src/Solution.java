import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	private static int[] onesToRight(int[] A)
	{
		int l = 0;
		int r = A.length - 1;
		while (l < r)
		{			
			if(A[l] == 1 && A[r] == 0)
			{
				int t = A[l];
				A[l] = A[r];
				A[r] = t;
			}
			else
			{
				if(A[l] == 0) l++;
				if(A[r] == 1) r--;
			}
		}
		return A;
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
    	int[] input = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
    	String res = Arrays.stream(onesToRight(input)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	System.out.println(res);
    	
    }
}

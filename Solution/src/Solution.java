import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public void mix(int[] arr, int n) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < arr.length; i++)
		{
			if (!set.isEmpty())
			{
				if(set.contains(arr[i] + n))
					System.out.println(arr[i] + " " + (arr[i] + n));
				if(set.contains(arr[i] - n))
					System.out.println(arr[i] + " " + (arr[i] - n));
			}
			set.add(arr[i]);
		}
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
    	int[] input =  { 9, 29,10, 2, 50, 24, 100};
    	int n = 50;
    	Solution obj =  new Solution();
    	obj.mix(input, n);
    }
}

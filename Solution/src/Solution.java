import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public int[] mix(int[] arr) {
		int[] res = Arrays.copyOf(arr, arr.length);
		int left = 0;
		int right = res.length - 1;
		while(left < right)
		{
			if(res[left] == 0) left++;
			else if (res[right] == 1) right--;
			else
			{
				res[left] = 0;
				res[right] = 1;
				left++;
				right--;
			}
		}
        return res;
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
    	int[] input =  { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
    	Solution obj =  new Solution();
    	int[] res = obj.mix(input);
    	for (int i = 0; i < res.length; i++)

    		System.out.print(res[i] + " ");//in.close();
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	int[] match = new int[2];
	
	public void match3(int[] arr, int sum) {
		Arrays.sort(arr);
		int i = 0;
		while(  i < arr.length - 2)
			match2(arr, sum - arr[i], ++i);
    }
	
	private void match2(int[] arr, int sum, int left)
	{
		int right = arr.length - 1;
		int third = arr[left-1];
		while (left < right)
			if (arr[left] + arr[right] == sum)
			{
				System.out.println(third + " " + arr[left] + " " + arr[right]);
				left++;
				right--;
			}
			else if(arr[left] + arr[right] < sum) left++;
			else right--;
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
    	int[] arr = {1,2,3,4,2,-1,5};
    	int sum = 7;
    	Solution obj =  new Solution();
    	obj.match3(arr, sum);
    }
}

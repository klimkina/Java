import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static long countArray(int n, int k, int x) {
        // Return the number of ways to fill in the array.
		
		return (long)Math.pow(k-1, n-3) * (k-2) * 2 - 1;
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] A = new int[n];
        int[] rep = new int[n];
        Arrays.fill(rep, 0);
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
            if(map.containsKey(A[A_i])) {
            	for(; start <= map.get(A[A_i]); start++)
            		rep[start] = A_i - start;
            }
            map.put(A[A_i], A_i);
        }
        for(; start < n; start++)
    		rep[start] = n - start;
        
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            // Write Your Code Here
            int res = 0;
            for(int i = l - 1; i < r; i++)
        		res += Math.min(rep[i], r - i);
            System.out.println(res);
        }
        in.close();
    }
}
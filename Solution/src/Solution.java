import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	public void swap(int a, int b) {
		a = a^b;
		b = a^b;
		a = b^a;
		System.out.println(a + " " + b);
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
    	int[] fib = {1, 1};
    	int flag = 0;
    	for (int i = 0; i  < 50; i++)
    	{
    		fib[flag] = fib[0] + fib[1];
    		System.out.print(fib[flag] + " ");
    		flag = (flag + 1) % 2;
    	}
    }
}

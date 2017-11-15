import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void tripleRecursion(int n, int m, int k) {
        // Complete this function
    	int[][] matrix = new int[n][n];
    	init(matrix);
    	for(int i = 0; i < n; i++)
    		for(int j = 0; j < n; j++)
    			matrix[i][j] = getNext(matrix, i, j, m, k);
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++)
    			System.out.print(matrix[i][j] + " ");
		if(i < n-1)
    		System.out.println();
    	}
    }
    private static int getNext(int[][] matrix, int i, int j, int m, int k) {
    	if(matrix[i][j] > Integer.MIN_VALUE)
    		return matrix[i][j];
    	if(i == 0 && j == 0)
    		return m;
    	else if(i == j)
    		return matrix[i-1][j-1] + k;
    	else if (i > j)
    		return matrix[i-1][j] - 1;
    	else if (i < j)
    		return matrix[i][j-1] - 1;
    	else
    		return 0;
    }
    private static void init(int[][] matrix) {
    	for(int i = 0; i < matrix.length; i++)
    		Arrays.fill(matrix[i], Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();*/
    	int n = 5;
        int m = 10;
        int k = 7;
        tripleRecursion(n, m, k);
        //in.close();
    }
}
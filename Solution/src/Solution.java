/*You are playing a matrix-based game with the following setup and rules:

You are given a matrix  with  rows and  columns. Each cell contains some points. When a player passes a cell their score increases by the number written in that cell and the number in the cell becomes . (If the cell number is positive their score increases, otherwise it decreases.)
The player starts from any cell in the first row and can move left, right or down.
The game is over when the player reaches the last row and stops moving.*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
		
	static int matrixLand(int[][] A) {
        // Complete this function
    	if(A.length < 1)
    		return 0;
    	int[][] distTo = new int[2][A[0].length];   	
    	Arrays.fill(distTo[0], 0);
    	
    	int[] leftMaxes = new int[A[0].length];
    	int[] rightMaxes = new int[A[0].length];
    	for(int row = 0; row < A.length; row++) { //find alternative paths
    		initLeft(A[row], leftMaxes);
			initRight(A[row], rightMaxes);
    		for(int col = 0; col < A[0].length; col++) {
    			int leftSum = findLeftMax(leftMaxes, col);
    			int rightSum = findRightMax(rightMaxes, col);
    			int leftPath = findLeftPath(A[row], leftMaxes, distTo[row&1], col);
    			int rightPath = findRightPath(A[row], rightMaxes, distTo[row&1], col);
    			if(distTo[row&1][col] + leftSum + rightSum >= Math.max(leftPath, rightPath))
    				distTo[row&1^1][col] = distTo[row&1][col] + A[row][col] + leftSum + rightSum;
    			else if(leftPath == rightPath)
    				distTo[row&1^1][col] = leftPath + A[row][col] + Math.max(leftSum, rightSum);
    			else if(leftPath > rightPath)
    				distTo[row&1^1][col] = leftPath + A[row][col] + rightSum;
    			else
    				distTo[row&1^1][col] = rightPath + A[row][col] + leftSum;
    		}
    	}
    	int max = Integer.MIN_VALUE;
    	for(int col = 0; col < A[0].length; col++)
    		max = Math.max(max, distTo[A.length&1][col]);
    	return max;	
    } 
	private static int findLeftMax(int[] maxes, int col) {
		if(col < 1)
			return 0;
		return maxes[col-1];
	}
	private static int findRightMax(int[] maxes, int col) {
		if(col > maxes.length - 2)
			return 0;
		return maxes[col+1];
	}
	private static void initLeft(int[] a, int[] maxes) {
		maxes[0] = a[0];
		for(int j = 1; j < a.length; j++) {
			if(maxes[j-1] > 0)
				maxes[j] = a[j] + maxes[j-1];
			else
				maxes[j] = a[j];
		}
	}
	private static void initRight(int[] a, int[] maxes) {
		maxes[a.length-1] = a[a.length-1];
		for(int j = a.length-2; j >= 0; j--) {
			if(maxes[j+1] > 0)
				maxes[j] = a[j] + maxes[j+1];
			else
				maxes[j] = a[j];
		}
	}
	
	
	private static int findLeftPath(int[] a, int[] maxes, int[]distTo, int col) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int j = col-1; j >= 0; j--) {
			sum += a[col];
			max = Math.max(max, distTo[j] + maxes[j] + sum);
		}
		
		return max;
	}
	private static int findRightPath(int[] a, int[] maxes, int[]distTo, int col) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int j = col+1; j < maxes.length; j++){
			sum += a[col];
			max = Math.max(max, distTo[j] + maxes[j] + sum);
		}
		return max;
	}
	
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] A = new int[n][m];
        for(int A_i = 0; A_i < n; A_i++){
            for(int A_j = 0; A_j < m; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }*/
    	int[][] A = //{{1, 2, 3, -8},{ 5, 2, -1, 4}};
    	
    			{{1, 2, 3, -1, -2},
    		{-5, -8, -1, 2, -150},
    		{1, 2, 3, -250, 100},
    		{1, 1, 1, 1, 20}};
    	int result = matrixLand(A);
        System.out.println(result);
        //in.close();
    }
}
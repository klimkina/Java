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
    	int[][] normal = normalize(A);
    	int max = Integer.MIN_VALUE;
    	for(int col = 0; col < A[0].length; col++)
    		max = Math.max(max, sum(normal, col));
    	return max;	
    } 
	
	private static int sum(int[][] A, int col) {
		int res = 0;
		for(int i = 0; i < A.length; i++)
			res += A[i][col];
		return res;
	}
	private static int[][] normalize(int[][] A) {
		int[][] res = new int[A.length][A[0].length];
		for(int i = 0; i < A.length; i++) {
			
			for(int j = 0; j < A[0].length; j++) 
				res[i][j] = findMax(A, i, j);
		}
		return res;
	}	
	private static int findMax(int[][] A,int row, int col) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int res = A[row][col];
		for(int j = col-1; j >= 0; j--) {
			sum += A[row][j];
			if(sum > max)
				max = sum;
		}
		res += Math.max(max, 0);
		max = Integer.MIN_VALUE;
		sum = 0;
		for(int j = col+1; j < A[0].length; j++){
			sum += A[row][j];
			if(sum > max)
				max = sum;
		}
		res += Math.max(max, 0);
		return res;
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
    	int[][] A = {{2}};/*{{1, 2, 3, -1, -2},
    		{-5, -8, -1, 2, -150},
    		{1, 2, 3, -250, 100},
    		{1, 1, 1, 1, 20}};*/
    	int result = matrixLand(A);
        System.out.println(result);
        //in.close();
    }
}
//Madison, is a little girl who is fond of toys. 
//Her friend Mason works in a toy manufacturing factory . 
//Mason has a 2D board  of size  with  rows and  columns. 
//The board is divided into cells of size  with each cell indicated by it's coordinate . 
//The cell  has an integer  written on it. To create the toy Mason stacks number of cubes of size  on the cell .
//Given the description of the board showing the values of  and that the price of the toy is equal to the 3d surface area find the price of the toy.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int surfaceArea(int[][] A) {
        // Complete this function
    	if(A.length < 1)
    		return 0;
    	int res = 0;
    	for(int i = 0; i < A.length; i++)
    		for(int j = 0; j < A[0].length; j++) {
    			res += A[i][j] * 4 + 2 - neighbours(A, i, j);
    		}
    	return res;
    }
    static int neighbours(int[][] A, int i, int j) {
    	int dx[] = {0, 0, -1, 1};
		int dy[] = {-1, 1, 0, 0};
		
		int res = 0;
		
		for(int k = 0; k < 4; k++) {
			int new_x = i + dx[k];
			int new_y = j + dy[k];
			if (new_x >= 0 && new_x < A.length
					&& new_y >= 0 && new_y < A[0].length) 
				res += Math.min(A[i][j], A[new_x][new_y]);			
		}		  
		
		return res;
    }
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }*/
    	int[][] A = {{1, 3, 4},
    			{2, 2, 3},
    			{1, 2, 4}};
        int result = surfaceArea(A);
        System.out.println(result);
        //in.close();
    }
}
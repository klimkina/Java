import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



class Solution {
	public static  int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[m*n];
        int pos_x = 0;
        int pos_y = 0;
        int dir = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[pos_x][pos_y];
            if ( dir > 0) { // moving up
                if      (pos_y == m-1) { pos_x++; dir = -dir;}
                else if (pos_x == 0)     { pos_y++; dir = -dir;}
                else            { pos_x-=dir; pos_y+=dir; }
            } else {                // moving down
                if      (pos_x == n - 1) { pos_y++; dir = -dir; }
                else if (pos_y == 0)     { pos_x++; dir = -dir; }
                else            { pos_x-=dir; pos_y+=dir; }
            }   
        }
        return res;
    }
	
	public static void main(final String[] args) {
		int[][] matrix = {{1,2,3},
				{4,5,6},
				{7,8,9}};
		
		int[] res = findDiagonalOrder(matrix);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
		//System.out.print(queryString("110101011011000011011111000000", 15));
	}
}

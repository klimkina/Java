import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
	public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean first_row = false;
        for (int i = 0; i < n; i++)
            if (matrix[i][0] == 0)
                first_row = true;
        boolean first_col = false;
        for (int i = 0; i < m; i++)
            if (matrix[0][i] == 0)
                first_col = true;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        for (int i = 0; i < n; i++)
            if (matrix[i][0] == 0)
            {
                System.out.println("row:" + i);
                for (int j = 0; j < m; j++)
                    matrix[i][j] = 0;
            }
        for (int j = 0; j < m; j++)
            if (matrix[0][j] == 0)
            {
                System.out.println("col:" + j);
                for (int i = 0; i < n; i++)
                    matrix[i][j] = 0;
            }
        if (first_row)
            for (int j = 1; j < m; j++)
                matrix[0][j] = 0;
        if (first_col)
            for (int i = 1; i < n; i++)
                matrix[i][0] = 0;
        if (first_row || first_col)
            matrix[0][0] = 0;
    }
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] matrix = {{1,0,3}};
		obj.setZeroes(matrix);
		for (int i = 0 ; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}

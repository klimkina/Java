import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        boolean isTopZero = false;
        boolean isLeftZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0)
                isLeftZero = true;
        
        for (int i = 0; i < n; i++)
            if (matrix[0][i] == 0)
                isTopZero = true;
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
        for (int i = 1; i < m; i++)
            if (matrix[i][0] == 0)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;
        
        for (int j = 1; j < n; j++)
            if (matrix[0][j] == 0)
                for (int i = 0; i < m; i++)
                    matrix[i][j] = 0;
        
        if (isTopZero)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        if (isLeftZero)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
    }
	
    public static void main(String[] args) {
    	int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    	setZeroes(matrix);
    	for (int i = 0; i < matrix.length; i++)
    	{
            for (int j = 0; j < matrix[0].length; j++)
            	System.out.print(matrix[i][j] + " ");
            System.out.println();
    	}
    	
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static boolean rotate (int[][] matrix) 
	{
		if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		int n = matrix.length;
		for(int l = 0; l < n/2; l++)
		{
			int last = n - l - 1;
			for(int i = l; i < last; i++)
			{
				int offset = i - l;
				// save top
				int top = matrix[l][i];
				// top = left
				matrix[l][i] = matrix[last - offset][l];
				// left = bottom
				matrix[last - offset][l] = matrix[last][last - offset];
				// bottom = right
				matrix[last][last - offset] = matrix[i][last]; 
				//right = top
				matrix[i][last] = top; 
			}
		}
        return true;
    }
	
    public static void main(String[] args) {
    	int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9, 10,11,12}, {13,14,15,16}};
    	if(rotate(matrix))
    		for(int i = 0; i < matrix.length; i++)
    		{
    			for (int j = 0; j < matrix[0].length; j++)
    				System.out.print(matrix[i][j] + " ");
    			System.out.println();
    		}
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

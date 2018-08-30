import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0; int h = m * n -1;
        while (l < h)
        {
            int mid = l + (h-l)/2;
            if (matrix[mid/n][mid%n] == target)
                return true;
            if (matrix[mid/n][mid%n] > target)
                h = mid;
            else 
                l = mid +1;
        }
        if (matrix[l/n][l%n] == target)
            return true;
        return false;
    }
    public static void main(String[] args) 
    {
    	int[][] matrix = {{1}
    					};
    	System.out.println(searchMatrix(matrix, 0));;
    }
}

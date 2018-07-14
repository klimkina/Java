import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int[][] spiral(int n) {
		int[][] res = new int[n][n];
		int curr = 1;
		for (int i = 0; i <= (n+1)/2; i++)
		{
			int start = i;
			int end = n - i - 1;
			for(int j = start; j <= end; j++)
				res[i][j] = curr++;
			for(int j = start+1; j <= end; j++)
				res[j][end] = curr++;
			for(int j = end - 1; j >= start; j--)
				res[end][j] = curr++;
			for(int j = end - 1; j > start; j--)
				res[j][start] = curr++;
		}
			
		return res;
   }
	
	
    public static void main(String[] args) {
    	int[][] res = spiral(1);
    	for (int i = 0; i < 1; i++)
    	{
    		for (int j = 0; j < 1; j++)
    			System.out.print(res[i][j] + " ");
    		System.out.println();
    	}
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

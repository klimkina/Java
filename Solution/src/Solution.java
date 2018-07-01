import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int maxA(int N) {
		if(N <= 6)
			return N;
		int[] max = new int[N + 1];
		max[0] = 0;
		for(int i = 1; i <= 6; i++)
			max[i] = i;
		for(int i = 7; i <= N; i++)
			max[i] = Math.max(max[i-1] + 1, maxA(max, i));
		
        return max[N];
    }
	private static int maxA(int[]max, int i)
	{
		int res = max[i-3] * 2;
		for(int j = i-4; j >= i/2; j--)
			res = Math.max(res, max[j] * (i-j-1));
		return res;
	}
	
    public static void main(String[] args) {
    	System.out.println(maxA(3));
    	System.out.println(maxA(9));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

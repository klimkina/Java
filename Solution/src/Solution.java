import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int trap(int[] height) {
		int l = 0, r = height.length-1, level = 0, water = 0;
	    while (l < r) {
	        int lower = height[height[l] < height[r] ? l++ : r--];
	        level = Math.max(level, lower);
	        water += level - lower;
	    }
	    return water;
    }
	
    public static void main(String[] args) {
    	int[] height = {4,2,3};
    	System.out.println(trap(height));
    	
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

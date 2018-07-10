import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int curr = 0;
        while (l <= r && curr <= r)
        {
        	if (nums[curr] == 0)
        	{
        		nums[curr] = nums[l];
        		nums[l++] = 0;
        		curr++;
        	} else if (nums[curr] == 2)
        	{
        		nums[curr] = nums[r];
        		nums[r--] = 2;
        	} else
        		curr++;
        }
    }
	
	
    public static void main(String[] args) {
    	int[] input = {2,0,2,1,1,0};
    	sortColors(input);
    	for(int i = 0; i < input.length; i++)
    		System.out.print(input[i] + " ");
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

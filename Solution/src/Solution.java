import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int[] max = new int[nums.length + 1];
        max[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i ; j++)
                if(nums[j] < nums[i] && max[i] < max[j])
                    max[i] = max[j];
            max[i]++;
        }
        for(int j = 0; j < nums.length ; j++)
            if(max[nums.length] < max[j])
                max[nums.length] = max[j];
        return max[nums.length];
    }
	
    public static void main(String[] args) {
    	int[] input = {1,3,6,7,9,4,10,5,6};
    	System.out.print(lengthOfLIS(input));
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

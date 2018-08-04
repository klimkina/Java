import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            if(map.containsKey(target - nums[i]))
            {
                int[] res = new int[2];
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            else
                map.put(nums[i], i);
        return null;
    }
	
    public static void main(String[] args) {
    	int[] nums = {2, 7, 11, 15};
    	int target = 9;
    	int[] res = twoSum(nums, target);
    	for(int i = 0; i < 2; i++)
    		System.out.print(res[i]);
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

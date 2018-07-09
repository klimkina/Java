import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int search(int[] nums, int target) {
		int pivot = findPivot (nums);
		if (pivot < 0)
			return (binarySearch(nums, target, 0, nums.length - 1));
		if (nums[pivot] == target)
			return pivot;
		if (nums[0] <= target)
			return (binarySearch(nums, target, 0, pivot - 1));
        return (binarySearch(nums, target, pivot +1, nums.length - 1));
    }
	
	public static int binarySearch(int[] nums, int target, int start, int end) {
		int lo = start;
		int hi = end;
		while (lo <= hi)
		{
			int m = lo + (hi-lo)/2;
			if ( nums[m] == target)
				return m;
			if (nums[m] < target)
				lo = m + 1;
			else
				hi = m - 1;			
		}
		return -1;
	}
	
	private static int findPivot(int[] nums)
	{
		int lo = 0;
		int hi = nums.length-1;
		while (lo <= hi)
		{
			int m = lo + (hi-lo)/2;
			if ( m < hi && nums[m + 1] < nums[m])
				return m;
			if (m > lo && nums[m] < nums[m-1])
				return m;
			if (nums[lo] >= nums[m])
				hi = m - 1;
			else
				lo = m + 1;
		}
		return -1;
	}
		
    public static void main(String[] args) {
    	int[] nums = {4,5,6,7,8,1,2};
    	int target = 8;
    	System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

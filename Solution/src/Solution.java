import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int temp;
        for(int i = 0; i < k; i++)
        {
        	temp = nums[nums.length - 1];
        	for(int j = nums.length - 1; j >0 ; j--)
        		nums[j] = nums[j-1];
        	nums[0] = temp;
        }
    }
	
    public static void main(String[] args) {
    	int[] Input = {1,2,3,4,5,6,7};
    	rotate(Input, 7);
    		for(int i = 0; i < Input.length; i++)
    		{
    			System.out.print(Input[i]);
    		}
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static void ThreeSum (int[] arr, int n) {
       Arrays.sort(arr);
       for(int i = 0; i < arr.length - 2; i++)
       {
    	   int sum = n - arr[i];
    	   int l = i+1;
    	   int r = arr.length - 1;
    	   while (l < r)
    	   {
    		   if(arr[l] + arr[r] == sum)
    		   {
    			   System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
    			   l++;
    			   r--;
    		   }
    		   else if(arr[l] + arr[r] < sum)
    			   l++;
    		   else
    			   r--;
    	   }
    	   
       }
    }
	
	
    public static void main(String[] args) {
        int[] arr = {6, 8, 12, 4, 5, 9, 23};
        int n = 26;
        ThreeSum(arr, n);
    	//System.out.println(mirrorReflection(p, q));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

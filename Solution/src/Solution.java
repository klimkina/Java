import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] a, b;
		if(nums1.length <= nums2.length)
		{
			a = nums1;
			b = nums2;
		}
		else
		{
			a = nums2;
			b = nums1;
		}
		int n = a.length;
		int m = b.length;
		int min_index = 0, max_index = n, i = 0, j = 0, median = 0;
		int index = (n + m + 1) / 2;         
        while (min_index <= max_index)
        {
            i = (min_index + max_index) / 2;
            j = index - i;
         
            // if i = n, it means that Elements 
            // from a[] in the second half is an 
            // empty set. and if j = 0, it means 
            // that Elements from b[] in the first
            // half is an empty set. so it is 
            // necessary to check that, because we
            // compare elements from these two 
            // groups. Searching on right
            if (i < n && j > 0 && b[j - 1] > a[i])     
                min_index = i + 1;
                     
            // if i = 0, it means that Elements
            // from a[] in the first half is an 
            // empty set and if j = m, it means 
            // that Elements from b[] in the second
            // half is an empty set. so it is 
            // necessary to check that, because 
            // we compare elements from these two
            // groups. searching on left
            else if (i > 0 && j < m && b[j] < a[i - 1])     
                max_index = i - 1;
     
            // we have found the desired halves.
            else
            {
                // this condition happens when we 
                // don't have any elements in the 
                // first half from a[] so we
                // returning the last element in 
                // b[] from the first half.
                if (i == 0)         
                    median = b[j - 1];         
                 
                // and this condition happens when 
                // we don't have any elements in the
                // first half from b[] so we 
                // returning the last element in 
                // a[] from the first half.
                else if (j == 0)         
                    median = a[i - 1];         
                else       
                    median = Math.max(a[i - 1], b[j - 1]);         
                break;
            }
        }
         
        // calculating the median.
        // If number of elements is odd 
        // there is one middle element.
        if ((n + m) % 2 == 1)
            return (double)median;
             
        // Elements from a[] in the second 
        // half is an empty set. 
        if (i == n)
            return (median+b[j]) / 2.0;
             
        // Elements from b[] in the second 
        // half is an empty set.
        if (j == m)
            return (median + a[i]) / 2.0;
         
        return (median + Math.min(a[i], b[j])) / 2.0;
    }
	
    public static void main(String[] args) {
    	int[] nums1 = {1, 2};
    	int[] nums2 = {3, 4};
    	System.out.println(findMedianSortedArrays(nums1, nums2));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

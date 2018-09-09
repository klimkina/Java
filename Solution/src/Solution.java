import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2 == null || (nums1 != null && nums1.length  > nums2.length))
        	return findMedianSortedArrays(nums2, nums1);
        int idx1 = 0; 
        int idx2 = 0;
        int m = nums1 == null ? 0 : nums1.length;
        int n = nums2 == null ? 0 : nums2.length;
        int l = 0;
        int h = m;
        while (l < h)
        return calcMedian(nums1, nums2, idx1, idx2);
    }
    
    private static double calcMedian (int[] nums1, int[] nums2, int idx1, int idx2)
    {
    	return 0;
    }
    public static void main(String[] args) 
    {
    	int[] nums1 = {1, 2, 3,5};
    	int[] nums2 = {4, 5, 6};
    	System.out.println(findMedianSortedArrays(nums1, nums2));;
    }
}

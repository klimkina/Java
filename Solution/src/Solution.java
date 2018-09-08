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
        while (l <= h)
        {
        	idx1 = l + (h-l)/2;
        	idx2 = (n + m + 1)/2 - idx1;
        	if (idx1 > 0 && idx2 < n && nums1[idx1-1] > nums2[idx2])
    			h = idx1-1;
        	else if (idx2 > 0 && idx1 < m && nums2[idx2-1] > nums1[idx1])
    			l = idx1 + 1;  
        	else
        		break;
        }
        return calcMedian(nums1, nums2, idx1, idx2);
    }
    
    private static double calcMedian (int[] nums1, int[] nums2, int idx1, int idx2)
    {
    	double median = 0;
    	if (idx1 == 0)
    		median = nums2[idx2-1];
    	else if (idx2 == 0)
    		median = nums1[idx1-1];
    	else
    		median = Math.max(nums1[idx1-1], nums2[idx2-1]);
    	if ((nums1.length + nums2.length) % 2 == 0)
    	{
    		if (idx1 == nums1.length)
    			median += nums2[idx2];
    		else if (idx2 == nums2.length)
    			median += nums1[idx1];
    		else
    			median += Math.min(nums1[idx1], nums2[idx2]);
    		median /= 2;
    	}
    	return median;
    }
    public static void main(String[] args) 
    {
    	int[] nums1 = {1, 2, 3,5};
    	int[] nums2 = {4, 5, 6};
    	System.out.println(findMedianSortedArrays(nums1, nums2));;
    }
}

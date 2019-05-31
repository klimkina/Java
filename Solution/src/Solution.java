import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            throw new IllegalArgumentException("The arrays are empty.");
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length;
        int n = nums2.length;
        int lo = 0;
        int hi = m;
        int count = (m + n + 1)/2;
        int mid1 = 0;
        int mid2 = 0;
        while (lo <= hi)
        {
            mid1 = lo + (hi-lo)/2;
            mid2 = count - mid1;
            int max1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int max2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int min1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int min2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
            if (max1 > min2)
                hi = mid1-1;
            else if (max2 > min1)
                lo = mid1+1;
            else
            {
                int res = Math.max(max1, max2);
                if ((m + n) % 2 > 0)
                    return res;
                return  (double) (res + Math.min(min1, min2))/2;
            }
        }
        throw new IllegalArgumentException();
    }
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}
}

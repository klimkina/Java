import java.util.HashMap;

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int idx = (nums1.length + nums2.length)>>1;
        int count = (nums1.length + nums2.length + 1)&1;
        int l = 0;
        int r = 0;
        int curr = 0;
        for(; curr <= idx - count; curr++) {
        	if(l >= nums1.length)        	res = nums2[r++];
        	else if (r >= nums2.length)     res = nums1[l++];
        	else if(nums2[r] < nums1[l])   	res = nums2[r++];
	        else							res = nums1[l++];
        }
        if(count > 0){
        	if(l >= nums1.length)        	res += nums2[r++];
        	else if (r >= nums2.length)     res += nums1[l++];
        	else if(nums2[r] < nums1[l])   	res += nums2[r++];
	        else							res += nums1[l++];
        	res = res/2;
        }
        return res;
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[] nums1 = {1,3};
    	int[] nums2 = {2};
    	//System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    	int[] nums3 = {1,2};
    	int[] nums4 = {3,4};
    	//System.out.println(obj.findMedianSortedArrays(nums3, nums4));
    	int[] nums5 = {3,4};
    	int[] nums6 = {};
    	System.out.println(obj.findMedianSortedArrays(nums5, nums6));
    	
    }
}
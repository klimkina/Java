/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.*/

class Solution {
	public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid;
        while(low < high) {
        	mid = low + (high - low)/2;
        	if(nums[mid] < nums[high]) 
        		high = mid; // min is at the left        	
        	else
        		low = mid + 1; // min is at the right
        }
        return nums[low];
    }
    
	
    public static void main(String[] args) { 
    	Solution obj = new Solution();
    	int[] nums = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(obj.findMin(nums));
    }
}
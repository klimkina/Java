/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.*/

class Solution {
	public int findDuplicate(int[] nums) {
		if (nums.length > 1)
		{
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) // slow meets fast in a loop
			{
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0; // set to the beginning so they meet at the beginning of the loop
			while (fast != slow)
			{
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
    }
    
	
    public static void main(String[] args) { 
    	Solution obj = new Solution();
    	int[] nums = {2, 2, 2, 2, 2};
    	System.out.println(obj.findDuplicate(nums));
    }
}
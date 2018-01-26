import java.util.Arrays;

/*Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2.*/

public class Sum3Smaller {
	public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        int diff;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2 && nums[i] * 3 < target; i++)
        	for(int j = i+1; j < nums.length; j++) {
        		diff = target - nums[i] - nums[j];
        		int k = j + 1;
        		while(k < nums.length && nums[k] < diff ) {
        			res++;
        			k++;
        		}
        	}
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2, 0, 1, 3};
		int target = 2;
		Sum3Smaller obj = new Sum3Smaller();
		System.out.println(obj.threeSumSmaller(nums, target));
	}

}

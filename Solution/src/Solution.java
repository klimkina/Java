import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(nums.length < 3) return result;
	        Arrays.sort(nums);
	        int i = 0;
	        while(i < nums.length - 2) {
	            if(nums[i] > 0) break;
	            int j = i + 1;
	            int k = nums.length - 1;
	            while(j < k) {
	                int sum = nums[i] + nums[j] + nums[k];
	                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
	                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
	                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
	            }
	            while(nums[i] == nums[++i] && i < nums.length - 2);
	        }
	        return result;
    }
	
    public static void main(String[] args) {
    	int[] nums = {-1, 0, 1, 2, -1, -4};
    	Solution obj = new Solution();
    	
    	List<List<Integer>> res = obj.threeSum(nums);
    	Iterator itr = res.iterator();
    	while (itr.hasNext()) {
    		Iterator inner = ((List<Integer>)itr.next()).iterator();
    		while(inner.hasNext()) {
    			System.out.print(inner.next() + " ");
    		}
    		System.out.println();
        }
    }
}
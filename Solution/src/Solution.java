import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
	
	public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        while(start < nums.length && nums[start] <=0)
            start++;
        if (nums.length == 0 || start >= nums.length || nums[start] > 1)
            return 1;
        start++;
        while (start < nums.length) {
            if (nums[start] - nums[start-1] > 1)
                return nums[start-1] + 1;
            start++;
        }
        return nums[start-1] + 1;
    }
	
	public static void main(final String[] args) {
		int[] M = {1,1,3};
		System.out.print(firstMissingPositive(M));
	}
}

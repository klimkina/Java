import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
	
	public static int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[][] memo = new int[n][n];
        for (int len = 1; len <= n; len++)
            for (int start = 0; start <= n-len; start++) {
            	int finish = start + len -1;
            	int left = 1;
            	int right = 1;
            	if (start > 0)
            		left = nums[start-1];
            	if (finish < n-1)
            		right = nums[finish +1];
            	
            	for(int k = start; k <= finish; k++)
            	{
            		int before = 0;
            		int after = 0;
            		if (k > start)
            			before = memo[start][k-1];
            		if (k < finish)
            			after = memo[k+1][finish];
            		memo[start][finish] = Math.max(memo[start][finish], before + after + nums[k] * left * right);
            	}
            }
                
        return memo[0][n-1];
    }    
	
	public static void main(final String[] args) {
		int[] nums = {3,1,5,8};
		System.out.println(maxCoins(nums));
	}
}

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
class Solution {
	
	public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] arr = new int[nums[n-1]+1];
        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                arr[Math.abs(nums[i] - nums[j])]++;
        int sum = 0;
        for (int i = 0; i < nums[n-1]; i++){
            if (sum + arr[i] >= k)
                return i;
            else
                sum += arr[i];
        }
        return -1;
    }
	
	public static void main(final String[] args) {
		int[][] grid = {{1,2,0},{0,0,0},{0,0,0}};
		System.out.print(shortestDistance(grid));
	}
}

import java.util.List;
import java.util.ListIterator;
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
import java.util.Iterator;
import java.util.LinkedList;
class Solution {
	public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int n = nums.length;
        int[] res = new int[n];
        int l = 0;
        int r = n-1;
        int pos = (a > 0 ? n-1 : 0);
        while (l <= r)
        {
            int left = func(nums[l], a, b,c);
            int right = func(nums[r], a, b,c);
            if (a > 0)
            {
                if (left > right)
                    l++;
                else
                    r--;
                res[pos--] = left > right ? left : right;
            }
            else
            {
                if (left < right)
                    l++;
                else
                    r--;
                res[pos++] = left < right ? left : right;
            }
        }
            
        return res;
    }
	private static int func(int x, int a, int b, int c)
    {
        return a * x*x + b*x + c;
    }
	
	public static void main(final String[] args) {
		int[] nums = {-4,-2,2,4};
		nums = sortTransformedArray(nums,-1,3,5);
		//System.out.print(shortestDistance(grid));
	}
}

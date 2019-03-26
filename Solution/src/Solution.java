import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



class Solution {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i--)
        {
            stack.push(nums2[i]);
            if (i == nums2.length - 1)
            	map.put(nums2[i], -1);
            else
            {
            	int last = -1;
            	while (!stack.isEmpty())
            	{
            		if (nums2[i] >= stack.peek()) stack.pop();
            		else
            		{
            			last = stack.peek();
            			break;
            		}
            	}
            	map.put(nums2[i], last);
    			stack.push(nums2[i]);
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
        {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
	
	public static void main(final String[] args) {
		int[] nums1 = {1,3,5,2,4};
		int[] nums2 = {6,5,4,3,2,1,7};
		
		int[] res = nextGreaterElement(nums1, nums2);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
		//System.out.print(queryString("110101011011000011011111000000", 15));
	}
}

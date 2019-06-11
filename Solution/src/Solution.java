import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


class Solution {
	public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
    private List<List<Integer>> subsets(int[] nums, int start)
    {
    	List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length)
            res.add(new ArrayList<>());
        else
        {
	        int i = nums[start];
	        List<List<Integer>> sub = subsets(nums, start+1);
	        for (List<Integer> l : sub)
	        {
	        	List<Integer> t = new ArrayList<>();
	        	t.addAll(l);
	            l.add(i);
	            res.add(t);
	            res.add(l);
	        }
        }
        
        return res;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[] nums = {1,2,3};
		obj.subsets(nums);
		//System.out.println(obj.frequencySort("tree"));
	}
}

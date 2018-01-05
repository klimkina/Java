import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return new ArrayList<>();
        List<List<Integer>> subs = new ArrayList<>();
        int maxId = 0;
        boolean inserted;
        boolean divisible;
        for(int i = 0; i < nums.length; i++) {
        	inserted = false;
        	List<Integer> l = new ArrayList<>();
        	for(int j = 0; j < subs.size(); j++) {
        		divisible = true;
        		for(Integer num : subs.get(j)) {
        			if(Math.max(nums[i], num)%Math.min(nums[i], num) != 0) 
        				divisible = false;
        			else
        				l.add(num);
        		}
        		if(divisible) {
        			inserted = true;
        			subs.get(j).add(nums[i]);
        			if(subs.get(maxId).size() < subs.get(j).size())
        				maxId = j;
        		}
        	}
        	if(!inserted) {
        		l.add(Integer.valueOf(nums[i]));
        		if(!subs.isEmpty() && subs.get(maxId).size() < l.size())
    				maxId = subs.size();
        		subs.add(l);
        	}
        }
        return subs.get(maxId);
    }

   

    public static void main(String[] args) {
    	int[] nums = {1,2,3};
    	Solution obj = new Solution();
    	
    	List<Integer> res = obj.largestDivisibleSubset(nums);
    	for(Integer i:res)
    		System.out.print(i + " ");
        
    }
}
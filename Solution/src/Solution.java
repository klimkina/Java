import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		List<Integer> start = new ArrayList<>();
		res = helper(map, start);
		return res;
    }
	
	private static List<List<Integer>> helper(HashMap<Integer, Integer> map, List<Integer> start)
	{
		List<List<Integer>> res = new ArrayList<>();
		if (map.values().stream().allMatch(x -> x == 0))
			res.add(start);
		else
			for(int key : map.keySet())
			{
				if(map.get(key) > 0)
				{
					List<Integer> new_start = new ArrayList<Integer>(start);
					new_start.add(key);
					map.put(key, map.get(key) - 1);
					res.addAll(helper(map, new_start));
					map.put(key, map.getOrDefault(key, 0) + 1);
				}
			}
		return res;
	}
    public static void main(String[] args) {
    	int[] nums = {1,1,2};
    	List<List<Integer>> res = permuteUnique(nums);
    	for (List<Integer> perm : res)
    		System.out.println(perm.stream().map(i -> i.toString()).collect(Collectors.joining(", ")));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

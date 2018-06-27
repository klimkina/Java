import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static List<List<Integer>> GetCombinations (List<Integer> list) 
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(list == null || list.size() == 0)
		{
			res.add(list);
			return res;
		}
		
		int first = list.get(0);
		list = list.subList(1, list.size());
		List<List<Integer>> sub_comb = GetCombinations(list);
		res.addAll(sub_comb);
		for(List<Integer> sub : sub_comb)
		{
			List<Integer> to_add = new ArrayList<Integer>();
			if(sub == null || sub.size() == 0)
			{
				to_add.add(first);
				res.add(to_add);
			}
			else
			{
				to_add.add(first);
				to_add.addAll(sub);
				res.add(to_add);
			}
		}
		return res;
    }
	
    public static void main(String[] args) {
    	List<Integer> list = Arrays.asList(1,2,3);
    	List<List<Integer>> res = GetCombinations(list);
    		for(int i = 0; i < res.size(); i++)
    		{
    			List<Integer> sub = res.get(i);
    			for (int j = 0; j < sub.size(); j++)
    				System.out.print(sub.get(j) + " ");
    			System.out.println();
    		}
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

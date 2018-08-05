import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++)
        {
            String code = helper(strs[i]);
            if (!map.containsKey(code))
            {
                List<String> list = new ArrayList<>();
                map.put(code, list);
            }
            map.get(code).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet())
            res.add(map.get(key));
        return res;
    }
    private static String helper(String s)
    {
        char[] charr = s.toCharArray();
        Arrays.sort(charr);
        return String.valueOf(charr);
    }
	
    public static void main(String[] args) {
    	String[] s = {"eat", "tea", "tan", "ate", "nat", "bat", "tab"};
    	List<List<String>> res = groupAnagrams(s);
    	for (List<String> list : res)
    	{
    		for(String str : list)
    			System.out.print(str + " ");
    		System.out.println();
    	}
    	
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

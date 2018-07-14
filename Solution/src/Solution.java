import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static String lookNSay(int n) {
		if(n == 1) return "1";
		if (n==2) return "11";
		Object[] start = {2,1};
		for(int i = 3; i < n; i++)
		{
			List<Integer> arr = new ArrayList<>();
			int prev = 0;
			int curr = 1;
			while(curr < start.length)
			{
				if (start[curr] != start[prev])
				{
					arr.add(curr-prev);
					arr.add((Integer)start[prev]);
					prev = curr;					
				}
				curr++;
			}
			if (curr <= start.length)
			{
				arr.add(curr-prev);
				arr.add((Integer)start[prev]);
				prev = curr;					
			}
			start = arr.toArray();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < start.length; i++)
			sb.append(String.valueOf((Integer)start[i]));
		return sb.toString();
   }
	
	
    public static void main(String[] args) {
    	System.out.println(lookNSay(5));
    	
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

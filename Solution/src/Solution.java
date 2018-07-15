import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static String countAndSay(int n) {
		if (n <= 0)
			return "";
        if (n == 1)
        	return "1";
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++)
        {
        	StringBuilder next = new StringBuilder();
        	int prev = 0;
        	int curr = 1;
        	for (int j = 1; j < sb.length(); j++)
        	{
        		if (sb.charAt(j) != sb.charAt(prev))
        		{
        			next.append(curr - prev);
        			next.append(sb.charAt(prev));
        			prev = curr;
        		}
        		curr++;
        	}
        	next.append(curr - prev).append(sb.charAt(prev));
			sb = next;
        }
        return sb.toString();
    }
	
    public static void main(String[] args) {
    	System.out.println(countAndSay(6));
    	
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static String longestNonRepeating (String s) {
		if(s == null || s.length() < 2)
			return s;
		char[] charr = s.toCharArray();
		int start = 0;
		int maxend = 0;
		int maxstart = 0;
		HashMap<Character, Integer> lastpos = new HashMap<>();
		for(int i = 0; i < charr.length; i++)
		{
			int prev = lastpos.getOrDefault(charr[i], -1);
			if(prev >= start)
			{
				if(i - start > maxend - maxstart)
				{
					maxend = i;
					maxstart = start;
				}
				start = prev+1;
			}
			lastpos.put(charr[i], i);
		}
		if(charr.length - start > maxend - maxstart)
		{maxend = charr.length; maxstart = start;}
		return s.substring(maxstart, maxend);
    }
	
    public static void main(String[] args) {
        System.out.println(longestNonRepeating("aabcabcddabacdfvgb"));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

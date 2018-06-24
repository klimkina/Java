import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static boolean isAnagramm (String s1, String s2) {
		if(s1 == null && s2 == null || s1.length() ==0 && s2.length() == 0)
			return true;
		if(s1.length() != s2.length())
			return false;
		char[] charr = s1.toCharArray();
		char[] charr2 = s2.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s1.length(); i++)
			map.put(charr[i], map.getOrDefault(charr[i], 0) + 1);
		for(int i = 0; i < s2.length(); i++)
			if(!map.containsKey(charr2[i]) || map.get(charr2[i]) == 0)
				return false;
			else
				map.put(charr2[i], map.get(charr2[i])-1);
		return true;
    }
	
    public static void main(String[] args) {
        String s1 = "Red fox jumped over the red rock";
        String s2 = "Red red jumped over the sock rock";
    	System.out.println(isAnagramm(s1, s2));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

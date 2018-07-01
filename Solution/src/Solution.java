import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	static HashMap<Character, Integer> romans = new HashMap<>();
	
	public static int romanToInt(String s) {
		romans.put('I', 1);
		romans.put('V', 5);
		romans.put('X', 10);
		romans.put('L', 50);
		romans.put('C', 100);
		romans.put('D', 500);
		romans.put('M', 1000);
		
		char[] charr = s.toCharArray();
		int res = 0;
		int prev = 0;
		int curr = 0;
		for(int i = 0; i < charr.length; i++)
		{
			curr = romans.get(charr[i]);
			if (prev < curr)
			{
				curr = curr - prev;
				prev = 0;
			}
			res += prev;
			prev = curr;
		}
		res += prev;
		return res;
	}
	
    public static void main(String[] args) {
    	System.out.println(romanToInt("LVIII"));
    	System.out.println(romanToInt("MCMXCIV"));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

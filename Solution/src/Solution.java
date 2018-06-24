import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	private static boolean isSwap(String a, String b)
	{
		if(a == null || b == null || a.length() != b.length() || a.length() < 2)
			return false;
		char[] charra = a.toCharArray();
		char[] charrb = b.toCharArray();
		HashSet<Character> set = new HashSet<>();
		boolean hasTwo = false;
		int diff = -1;
		for (int i = 0; i < charra.length; i++)
		{
			if(set.contains(charra[i]))
				hasTwo = true;
			set.add(charra[i]);
			if(charra[i] != charrb[i]) {
				if(diff >= 0)
					return charrb[i] == charra[diff] && charra[i] == charrb[diff] && 
					(i == charra.length - 1 || b.endsWith(a.substring(i + 1)));
				else
					diff = i;
			}
		}
		return hasTwo;
	}
	
    public static void main(String[] args) {
        String a = "aa";
        String b = "aa";
    	System.out.println(isSwap(a, b));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

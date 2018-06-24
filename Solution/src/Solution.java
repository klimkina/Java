import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static String ReverseWords (String s) {
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++)
			words[i] = reverse(words[i]);
       return reverse(Arrays.stream(words).collect(Collectors.joining(" ")));
    }
	
	private static String reverse (String s)
	{
		char[] charr = s.toCharArray();
		for(int i = 0; i < charr.length/2; i++)
		{
			char t = charr[i];
			charr[i] = charr[charr.length - i - 1];
			charr[charr.length - i - 1] = t;
		}
		return String.valueOf(charr);
	}
	
	
    public static void main(String[] args) {
        String s = "Red fox jumped over the hard rock";
    	System.out.println(ReverseWords(s));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

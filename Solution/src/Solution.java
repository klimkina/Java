import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	private static String vowels = "aeiouAEIOU";
	public static HashMap<String, Integer> groupConsonants(String s) {
		HashMap<String, Integer> consonants = new HashMap<>();
		char[] charr = s.toCharArray();
		int startPos = 0;
		int endPos = 0;
		for(int i = 0; i < charr.length; i++)
		{
			if(vowels.indexOf(charr[i]) >= 0)
				endPos++;
			else
			{
				helper(charr, startPos, endPos, consonants);
				startPos = i+1;
				endPos = i+1;
			}
		}
		helper(charr, startPos, endPos, consonants);
		return consonants;
    }
	private static void helper(char[] charr, int startPos, int endPos, HashMap<String, Integer> consonants)
	{
		if(endPos - startPos > 1 && endPos - startPos < 4)
		{
			String consonant = String.valueOf(charr, startPos, endPos - startPos);
			if(!consonants.containsKey(consonant))
				consonants.put(consonant, 0);
			consonants.put(consonant, consonants.get(consonant)+1);
		}
	}	
	
    public static void main(String[] args) {
    	HashMap<String, Integer> map = groupConsonants("aei eauoi   this       oooh aeiouaeiouthis  oho");
    	for(String s : map.keySet())
    		System.out.println(s.length() + " - " + map.get(s));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static String reverseWords(String s) {
        int prev = 0;
        char[] charr = s.toCharArray();
        for(int i = 1; i < charr.length; )
        {
            if(charr[i] == ' ')
            {
                reverse(charr, prev, i);
                while(i < charr.length && charr[i++] == ' ')
                prev = i;
            }
            else
                i++;
        }
        if (prev < charr.length)
        	reverse(charr, prev, charr.length);
        reverse(charr, 0, charr.length);
        String str = String.valueOf(charr).replaceAll("\\s{2,}", " ");
        return str;
    }
    
    private static void reverse(char[] charr, int start, int end)
    {
        char c;
        for (int i = 0; i < (end - start)/ 2; i++)
        {
            c = charr[start+i];
            charr[start+i] = charr[end-1-i];
            charr[end-1-i] = c;
        }
    }
	
    public static void main(String[] args) {
    	System.out.print(reverseWords("hello       world"));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

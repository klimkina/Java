import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int compress(char[] chars) {
        int prev = 0;
        int end = 0;
        for(int i = 1; i <= chars.length; i++)
        {
            if(i == chars.length || chars[i] != chars[prev])
            {
            	chars[end++] = chars[prev];
                if( i - prev > 1)
                {
                	char[] num = String.valueOf(i-prev).toCharArray();
                    for(int j = 0; j < num.length; j++)
                        chars[end + j] = num[j];
                    end += num.length;
                }
                prev = i;
            }
        }
        return end;
    }
	
    public static void main(String[] args) {
    	String s = "b";
    	char[] chars = s.toCharArray();
    	int n = compress(chars);
    	for(int i = 0; i < n; i++)
    		System.out.print(chars[i]);
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

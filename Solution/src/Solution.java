import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static void reverseWords(char[] str) {
        if(str.length < 2)
            return;
        int start = 0;
        for(int i = 1; i < str.length; i++)
            if(str[i] == ' ')
            {
                reversePos(str, start, i);
                start = i + 1;
            }
        if(start < str.length - 1)
            reversePos(str, start, str.length);
        reversePos(str, 0, str.length);
        return;
    }
    
    private static void reversePos(char[] str, int start, int end)
    {
        char temp;
        for(int i = 0; i < (end - start)/2; i++)
        {
            temp = str[start + i];
            str[start + i] = str[end-1-i]; 
            str[end-1-i] = temp;
        }
    }
	
    public static void main(String[] args) {
    	char[] Input = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
    	reverseWords(Input);
    		for(int i = 0; i < Input.length; i++)
    		{
    			System.out.print(Input[i]);
    		}
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

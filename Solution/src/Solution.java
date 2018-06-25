import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static void parenthesis (int n) {
		parenthesis("", n, n);
    }
	public static void parenthesis(String sofar, int open, int closed)
	{
		if(open == 0 && closed == 0)
			System.out.println(sofar);
		else
		{
			if(open == closed)
				parenthesis(sofar + "(", open -1, closed);
			else
			{
				if(open > 0)
					parenthesis(sofar + "(", open - 1, closed);
				parenthesis(sofar + ")", open, closed - 1);
			}
		}
	}
    public static void main(String[] args) {
    	parenthesis(3);
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

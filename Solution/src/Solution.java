import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static int scoreOfParentheses(String S) {
        int res = 0;
        String s;
        char[] charr = S.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < charr.length; i++)
        {
        	if(charr[i] == '(')
        		stack.push("(");
        	if(charr[i] == ')')
        	{
        		res = 0;
        		do
        		{
        			s = stack.pop();
        			if(s != "(")
        				res = res + Integer.valueOf(s);
        			
        		} while (s != "(");
        		if(res > 0)
        			res *= 2;
        		else
        			res = 1;
        		stack.push(String.valueOf(res));
        	}
        }
        res = 0;
        while(!stack.isEmpty())
        {
        	s = stack.pop();
        	res = res + Integer.valueOf(s);
        }
        return res;
    }
	
    public static void main(String[] args) {
        String a = "(()(()))";
    	System.out.println(scoreOfParentheses(a));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

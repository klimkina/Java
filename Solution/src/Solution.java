import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        int block = 0;
    	int line = 0;
    	int last = 0;
    	String temp;
        for(String s : source)
        {
        	temp = "";
        	if(inBlock)
        	{
        		block = s.indexOf("*/");
        		if(block >= 0)
        		{
        			temp = s.substring(block+2, s.length());
        			inBlock = false;
        		}
        	}
        	else
        	{
	        	block = s.indexOf("/*");
	        	line = s.indexOf("//");
	        	if(block >= 0 && (line < 0 || block < line))
	        	{
	        		last = s.indexOf("*/");
	        		if(last >= 0)
	        		{
	        			temp = s.substring(0, block);
	        			if (last < s.length() - 2)
	        				temp += s.substring(last + 2, s.length());
	        		}
        			else
        				inBlock = true;
	        	}
	        	
	        	if (block >= 0 && inBlock || line >= 0)
	        		temp = (s.substring(0, Math.min(Math.max(0, block), Math.max(0, line))));
	        	else if (block < 0)
	        		temp = s;
	        	if(temp != null && temp != "")
	        		res.add(temp);
        	}
        }
        return res;
    }
	
    public static void main(String[] args) {
    	String[] input = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
    			
    	List<String> output = removeComments(input);
    	for (String s : output)
    		System.out.println(s);
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

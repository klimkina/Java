import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static String convertToTitle(int n) {
        String res = "";
        
        while(n > 0)
        {
        	n--;
        	res = (char)('A' + n % 26 ) + res;
        	n = n/26;
        }
        return res;
    }
	
    public static void main(String[] args) {
    	System.out.println(convertToTitle(701));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

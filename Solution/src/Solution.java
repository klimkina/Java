import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int myAtoi(String str) {
		str = str.trim();
        if (str.matches("\\s*[a-zA-Z]+.*"))
            return 0;
        long res = 0;
        if(str.length() > 0)
        {
            boolean isNeg = str.charAt(0) == '-';
            int cur = 0;
            if(str.charAt(0) == '-' || str.charAt(0) == '+')
                cur++;
            if(cur >= str.length() || str.charAt(cur) < '0' || str.charAt(cur) > '9')
                return 0;
            for(; cur < str.length(); cur++)
            {
                if(str.charAt(cur) >= '0' && str.charAt(cur) <= '9')
                    res = 10 * res + (int)(str.charAt(cur) - '0');
                else 
                    break;
                if (res > Integer.MAX_VALUE)
                {
                    if (isNeg)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
            }
            if(isNeg)
                res = -res;
        }
        if (res > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        return (int)res;
    
    }
	
    public static void main(String[] args) {
    	System.out.print(myAtoi("18446744073709551617"));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

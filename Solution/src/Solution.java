import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static int primePalindrome(int N) {
		List<Integer> next = nextPalindrome(N);
        while (true)
        {
        	for(int i : next)
	            if(isPrime(i))
	                return i;
            next = nextPalindrome(next.get(0) + 1);
        }
    }
    
    private static List<Integer> nextPalindrome(int n)
    {
    	List<Integer> res = new ArrayList<>();
    	if (n < 10)
    	{
    		res.add(n);
    		return res;
    	}
    	char[] charr = String.valueOf(n).toCharArray();
        for(int i = 0; i < charr.length/2; i++)
        {
        	char max = charr[i];
            charr [charr.length - i - 1] = max;
        }
        int num = Integer.valueOf(String.valueOf(charr));
        if (num >= n)
        	res.add(num);
        for (int i = 0; i < (charr.length + 1)/2; i++)
        {
        	char max = charr[(charr.length - 1)/2 - i];
        	while (max != '9')
        	{
        		max++;
        		charr[(charr.length - 1)/2 - i] = max;
        		charr[(charr.length)/2 + i] = max;
        		num = Integer.valueOf(String.valueOf(charr));
                if (num >= n)
                	res.add(num);
        	}
        }
        return res;        
    }
    
    private static boolean isPrime(int n)
    {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
		
    public static void main(String[] args) {
    	System.out.println(primePalindrome(192));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

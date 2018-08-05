import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static String longestPalindrome(String s) {
        if (s.isEmpty())
            return s;
        char[] charr = s.toCharArray();
        int n = charr.length;
        int l = 0;
        int r = 0;
        boolean[][] memo = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            memo[i][i] = true;
            if (i < n-1 && charr[i] == charr[i+1])
            {
                memo[i][i+1] = true;
                l = i; r = i+1;
            }
        }
        for (int diff = 1; diff < n; diff++)
            for (int j = 0; j + diff < n ; j++)
                if (charr[j] == charr[j + diff] && (diff == 2 || memo[j+1][j+diff-1]))
                {
                    memo[j][j+diff] = true;
                    if (r - l < diff)
                    { l = j; r = j+diff; }
                }
        return s.substring(l, r+1);
    }
	
    public static void main(String[] args) {
    	String s = "abcba";
    	System.out.print(longestPalindrome(s));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

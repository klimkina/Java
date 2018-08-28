import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] memo = new boolean[n+1][m+1];
        memo[0][0] = true;
        for (int i = 0; i < m; i++)
            memo[0][i+1] = (p.charAt(i) == '*') && memo[0][i];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    memo[i+1][j+1] = memo[i][j];
                else if (p.charAt(j) == '*')
                    memo[i+1][j+1] = memo[i+1][j] || memo[i][j+1];
        return memo[n][m];
    }
    public static void main(String[] args) 
    {
    	
    	System.out.println(isMatch("", "?"));
    }
}

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
	public static int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        int[] res = new int[1];
        dfs("", l, r, res);
        for (int i = 0; i < 10; i++) {
            String next = "" + i;
            dfs(next, l, r, res);
        }
        return res[0];
    }
    
    private static void dfs(String s, long l, long r, int[] res) {
        if (s.length() > 9) {
            return;
        }
        
        if (s.length() > 0 && s.charAt(0) != 0) {
            long num = Long.parseLong(s);
            num *= num;
            if (num >= l && num <= r && isPalindrome("" + num)) {
                res[0]++;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            String next = "" + i + s + i;
            dfs(next, l, r, res);
        }
    }
    
    private static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
    public static void main(String[] args) 
    {
    	System.out.println(superpalindromesInRange("9558",
    			"82926"));
    }
}

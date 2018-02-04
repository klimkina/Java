import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumPalindromes {
	private static int[] letter_match;
	private static int[] letters;
    static void initialize(String s) {
        // This function is called once before all queries.
    	letter_match = new int[s.length()];
    	letter_match[0] = 1 << (s.charAt(0)-'a');
    	letters[0] = letter_match[0];
    	for(int i = 1; i < s.length(); i++) {
    		int pos = s.charAt(i)-'a';
    		int val = (letter_match[i-1] &(1<<pos)) == 0 ? 1 : 0;
    		int mask = ~(1 << pos);
    		letter_match[i] = (letter_match[i-1] & mask) | (val << pos) ;
    		letters[i] = letters[i-1]|(1<<pos);
    	}
    }

    static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
    	long res = 0;
    	int temp = letter_match[r-1]^(l > 1 ? letter_match[l-2] : 0);
    	res += count_ones(temp)% 1000000007;
    	if (res == 0)
    		res = 1;
    	return (int)res;
    }
    private static int count_ones(int n) {
    	int res = 0;
    	for(int i = 0; i < 26; i++) {
    		res += (n&1);
    		n >>>= 1;
    	}
    	return res;
    }

    public static void main(String[] args) {
        String s = "abab";
        initialize(s);
        System.out.println(answerQuery(1, 4));
        System.out.println(answerQuery(2, 3));
    }
}


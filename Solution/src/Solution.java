import java.util.ArrayList;

/*Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".*/

class Solution {
	public String shortestPalindrome(String s) {
		int i = 0, end = s.length() - 1, j = end; 
		char chs[] = s.toCharArray();
	    while(i < j) {
	         if (chs[i] == chs[j]) {
	             i++; j--;
	         } else { 
	             i = 0; end--; j = end;
	         }
	    }
	    return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
    }
    
	
    public static void main(String[] args) { 
    	Solution obj = new Solution();
    	String s1 = "aacecaaa";
    	String s2 = "abcd";
    	System.out.println(obj.shortestPalindrome(s1));
    	System.out.println(obj.shortestPalindrome(s2));
    }
}
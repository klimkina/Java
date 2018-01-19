import java.util.ArrayList;

/*Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".*/

class Solution {
	public String shortestPalindrome(String s) {
		if(s == null || s.isEmpty() || s.length() == 1)
			return s;
		ArrayList<Character> pref = new ArrayList<>();
		char[] charr = s.toCharArray();
		int count = 1;
		while(!isPalindrome(pref, charr)) 
			pref.add(charr[charr.length - count++]);
		StringBuilder builder = new StringBuilder(pref.size());
	    for(Character ch: pref)
	    {
	        builder.append(ch);
	    }
		return builder.toString() + s;
    }
    
	private boolean isPalindrome(ArrayList<Character> arr, char[] charr) {
		for(int i = 0; i < (arr.size() + charr.length) /2; i++)
			if((i < arr.size() ? arr.get(i) : charr [i - arr.size()]) != charr[charr.length - i - 1])
				return false;
		return true;
	}
    public static void main(String[] args) { 
    	Solution obj = new Solution();
    	String s1 = "aacecaaa";
    	String s2 = "abcd";
    	System.out.println(obj.shortestPalindrome(s1));
    	System.out.println(obj.shortestPalindrome(s2));
    }
}
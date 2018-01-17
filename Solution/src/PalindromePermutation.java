import java.util.HashMap;

// Given a string, determine if a permutation of the string could form a palindrome.

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        char[] charr = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();// character and if odd
        for(char ch : charr) {
        	if(map.containsKey(ch))
        		map.put(ch, !map.get(ch));
        	else
        		map.put(ch, true);
        }
        boolean isOdd = false;
        for(Character c : map.keySet()) {
        	if(map.get(c)) {
        		if(isOdd)
        			return false;
        		else
        			isOdd = true;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePermutation obj = new PalindromePermutation();
		System.out.println(obj.canPermutePalindrome("code"));
		System.out.println(obj.canPermutePalindrome("AaBb//a"));
	}

}

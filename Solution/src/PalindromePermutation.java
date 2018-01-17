// Given a string, determine if a permutation of the string could form a palindrome.

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        int freq = 0; // 26 letters map to bits
        char[] charr = s.toLowerCase().toCharArray();
        for(char ch : charr) {
        	int pos = ch - 'a';
        	int mask = 1 << (pos+1);
        	int prev = freq & mask;
        	if(prev > 0) // set 0
        		freq &= ~mask;
        	else
        		freq |= mask;
        }
        boolean isOdd = false;
        while(freq > 0) {
        	if((freq&1) > 0) {
        		if(isOdd)
        			return false;
        		else
        			isOdd = true;
        	}
        	freq >>>= 1;
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

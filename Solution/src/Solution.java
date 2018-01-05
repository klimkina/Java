import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int maxProduct(String[] words) {
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() != s2.length())
					return s1.length() - s2.length();
				return s1.compareTo(s2);
			}
		});
		int res = 0;
		char[][] word_letters = new char[words.length][];
		for(int i = 0; i < words.length; i++) {
			word_letters[i] = words[i].toCharArray();
			Arrays.sort(word_letters[i]);
		}
		for(int i = words.length-1; i > 0; i--) {
			if(word_letters[i].length * word_letters[i-1].length <= res)
				break;
			for(int j = i-1; j >= 0; j--) {
				if(word_letters[i].length * word_letters[j].length <= res)
					break;
				if(!hasCommonLetter(word_letters[i], word_letters[j])) {
					if(word_letters[i].length * word_letters[j].length > res)
						res = word_letters[i].length * word_letters[j].length;
					break;
				}
			}
			
		}
        return res;
    }
	private boolean hasCommonLetter(char[] chars1, char[] chars2) {
		int idx1 = 0;
		int idx2 = 0;
		while(idx1 < chars1.length && idx2 < chars2.length) {
			if(chars1[idx1] == chars2[idx2])
				return true;
			if(chars1[idx1] < chars2[idx2])
				idx1++;
			else
				idx2++;
		}
		return false;
	}
    public static void main(String[] args) {
    	String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    	Solution obj = new Solution();
    	
    	System.out.println(obj.maxProduct(words));
        
    }
}
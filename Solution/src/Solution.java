import java.util.HashMap;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s.length() < 2)
			return s.length();
		int max = 0;
		int curr = 0;
		HashMap<Character, Integer> sub = new HashMap<>();
		
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if(sub.containsKey(chars[i])) {
				if(max < curr)
					max = curr;
				curr = Math.min(curr+1, i - sub.get(chars[i]));
			}
			else 
				curr++;			
			sub.put(chars[i], i);
		}
		if(max < curr)
			max = curr;
		return max;
        
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	String s = "abba";
    	System.out.println(obj.lengthOfLongestSubstring(s));
    	
    }
}
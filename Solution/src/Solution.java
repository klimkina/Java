
class Solution {
	public String longestPalindrome(String s) {
		if(s.isEmpty())
			return s;
		char[] chars = s.toCharArray();
		boolean[][] memo = new boolean[s.length()][s.length()];
		int l = 0, r = 0;
		for(int i = 0; i < s.length()-1; i++) {
			memo[i][i] = true;
			memo[i][i+1] = chars[i]==chars[i+1];
			if(memo[i][i+1]) {
				l = i; r = i+1;
			}
		}
		
		memo[s.length()-1][s.length()-1] = true;
		for(int k = 2; k < s.length(); k++) 
			for(int i = 0; i < s.length()-k; i++) {
				memo[i][i+k] = (chars[i]==chars[i+k]) && memo[i+1][i+k-1];
				if(memo[i][i+k]) {
					l = i; r = i+k;
				}
			}
		
		//printMatrix(memo, s.length());
        return s.substring(l, r+1);
    }
	private void printMatrix(boolean[][] memo, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(memo[i][j]==true ? 1:0);
			System.out.println();
		}
	}
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	String s = "cbbdb";
    	System.out.println(obj.longestPalindrome(s));
    	
    }
}
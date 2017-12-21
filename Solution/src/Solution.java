

class Solution {
	public int reverse(int x) {
		char[] chars = String.valueOf(x).toCharArray();
		char[] res = new char[chars.length];
		int idx = 0;
		if(chars[0] == '-')
			res[idx++] = '-';
		for(int i = chars.length-1; i >= idx; i--)
			res[chars.length - i + idx-1] = chars[i];
		return Integer.valueOf(String.valueOf(res));        
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int num = -527;
    	System.out.println(obj.reverse(num));
    	
    }
}
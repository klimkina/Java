

class Solution {
	public int myAtoi(String str) throws NumberFormatException{ 
		str = str.trim();
		if(str.isEmpty())
			return 0;
		char[] chars = str.toCharArray();
		boolean isNeg = chars[0] == '-';
		int res = 0;
		int start = (isNeg || chars[0] == '+'? 1:0);
		long temp = 0;
		for(; start < chars.length; start++) {
			if(chars[start] < '0' || chars[start] > '9')
				break;
			temp = ((long)res)*10 + (chars[start] - '0');
			if(temp > Integer.MAX_VALUE) //operation overflows
				return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			res = (int)temp;
		}
		if(isNeg)
			res = -res;
        return res;
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	String s = "2147483648";
    	System.out.println(obj.myAtoi(s));
    	
    }
}
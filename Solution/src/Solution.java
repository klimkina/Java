import java.lang.reflect.Array;
import java.util.ArrayList;

class Solution {
	public String convert(String s, int numRows) {
		if(numRows <= 1)
			return s;
		char[] chars = s.toCharArray();
		char[] res = new char[chars.length];
		int idx = 0;
		int period = numRows+numRows - 2;
		int tail = chars.length%period;
		for(int row = 0; row < numRows; row++) {			
			for(int i = 0; i < chars.length/period + (tail > 0 ? 1:0); i++) {
				if(row + (period)*i <chars.length)
					res[idx++] = chars[row + (period)*i];
				if(row > 0 && row < numRows-1)
					if((period)*(i+1) - row < chars.length)
						res[idx++] = chars[(period)*(i+1) - row];
			}
			
		}
        return String.valueOf(res);
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	String s = "PAYPALISHIRING";
    	int num = 5;
    	System.out.println(obj.convert(s, num));
    	
    }
}
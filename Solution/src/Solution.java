import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
	public int myAtoi(String str) {
        int res = 0;
        if (str == null || str.length() == 0)
            return res;
        
        char[] charr = str.toCharArray();
        int start = 0;
        while(start < charr.length && charr[start] == ' ')
            start++;
        int sign = 1;
        if (start < charr.length && (charr[start] == '-' || charr[start] == '+'))
        {
            
            sign = charr[start++] == '-' ? -1 : 1;
        }
        
        while(start < charr.length)
        {
            if (charr[start] < '0' || charr[start] > '9')
                return res*sign;
            int next = charr[start++] - '0';
            if (sign > 0 && (Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE - next < res * 10))
                return Integer.MAX_VALUE;
            if (sign < 0 && (Integer.MIN_VALUE/10 > - res || Integer.MIN_VALUE + next > -res * 10))
                return Integer.MIN_VALUE;
            res = res * 10 + next;
        }
        res = sign*res;
        return res;
    }
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		System.out.println(obj.myAtoi("-2147483648"));
		
	}
}

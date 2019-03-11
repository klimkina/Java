import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
	
	public static boolean isNumber(String s) {
        char[] charr = s.trim().toCharArray();
        int n = charr.length;
        if (n == 0)
            return false;
        int idx = 0;
        if (charr[idx] == '+' || charr[idx] == '-')
            idx++;
        boolean isDot = false;
        boolean isDouble = false;
        while (idx < n && charr[idx] != 'e') // valid double to the left
        {
            if (charr[idx] == '.')
            {
                if (isDot)
                    return false;
                isDot = true;
                if (!isDouble && (idx < n-1 && !isNumber(charr[idx+1])))
                    return false;
            }
            else if (isNumber(charr[idx]))
                isDouble = true;
            else
                return false;
            idx++;
        }
        boolean isE = true;
        if (idx < n && charr[idx] == 'e' && isDouble)
        {
            if (!isDouble || idx == n-1)
                return false;
            if (charr[idx+1] == '-' || charr[idx+1] == '+')
                idx++;
            idx++;
            isE = false;
            while (idx < n)
            {
                if (isNumber(charr[idx]))
                    isE = true;
                else
                    return false;
                idx++;
            }
        }
        return isDouble && isE;
    }
    
    private static boolean isNumber(char ch)
    {
        return ch >= '0' && ch <= '9';
    }
	
	public static void main(final String[] args) {
		System.out.println(isNumber("4e3."));
		System.out.println(isNumber("+90e3.5"));
	}
}

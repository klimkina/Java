import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
	static String str1 = "aa";
	static String str2 = "a";
	static String str3 = "b";
	static String str4 = "bb";
	public static String strWithout3a3b(int A, int B) {
        if (B > A)
        {
        	str1 = "bb";
        	str2 = "b";
        	str3 = "a";
        	str4 = "aa";
            return strWithout3a3b(B, A);
        }
        int an = A/2;
        int bn = B - an;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < an; i++) 
        {
            sb.append(str1);
            if (bn-- > 0)
            {
            	if(B > 0)
            		sb.append(str4);
            	B -= 2;
            }
            else if (B > 0)
            {
            	B --;
            	sb.append(str3);
            }
        }
        
        if (A % 2 > 0)
            sb.append(str2);
        if (B > 0)
        	sb.append(str3);
        return sb.toString();
    }
	
	public static void main(final String[] args) {
		System.out.println(strWithout3a3b(4,2));
	}
}

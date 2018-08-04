import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charr = s.toCharArray();
        for(int i = 0; i < charr.length; i++)
        {
            if(map.containsKey(charr[i]))
                map.put(charr[i], -1);
            else
                map.put(charr[i], i);
        }
        int res = -1;
        for(int i:map.values())
            if(res == -1 || (i >= 0 && i < res))
                res = i;
        return res;
    }
	
    public static void main(String[] args) {
    	System.out.println(firstUniqChar("leetcolde"));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

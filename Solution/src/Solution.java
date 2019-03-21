import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
class Solution {
	
	public static String minWindow(String s, String t) {
		int min_start = -1;
        int min_len = -1;
        HashMap<Character, Integer> set = new HashMap<>();
        char[] charr = t.toCharArray();
        int counter = charr.length;
        for (int i = 0; i < charr.length; i++)
            set.put(charr[i], set.getOrDefault(charr[i], 0)+1);
        charr = s.toCharArray();
        int begin=0, end=0;
        while (end < charr.length)
        {            
            if(set.get(charr[end]) != null) {
                set.put(charr[end], set.get(charr[end]) - 1);
                if (set.get(charr[end]) >= 0)
                	counter--;
                
            }
            end++;
            while (counter == 0)
            {
                if (min_len == -1 || end - begin < min_len)
                {
                    min_len = end - begin;
                    min_start = begin;
                }
                if (set.get(charr[begin]) != null) {
                	set.put(charr[begin], set.get(charr[begin]) + 1);
	                if (set.get(charr[begin]) == 1)
	                	counter++;
                }
            	begin++;                      
            }   
        }
        if (min_len == -1)
            return "";
        return s.substring(min_start, min_len+min_start);
    }
	
	public static void main(final String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.print(minWindow(s,t));
	}
}

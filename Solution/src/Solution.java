import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++)
        {
            if (map.getOrDefault(chars[j], 0) == 0)
                k--;
            map.put(chars[j], map.getOrDefault(chars[j], 0) + 1);
            while(k < 0) {
                if(map.getOrDefault(chars[i], 0) == 1)
                    k++;
                map.put(chars[i], map.getOrDefault(chars[i], 0) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);        
        }
        return max;
    }
	
	public static void main(final String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
	}
}

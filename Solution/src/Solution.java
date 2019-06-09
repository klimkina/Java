import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


class Solution {
	public String smallestSubsequence(String text) {
		TreeMap<Character, Integer> map = new TreeMap<>();
        TreeMap<Integer, Character> reverse = new TreeMap<>();
        char[] charr = text.toCharArray();
        for (int i = 0; i < charr.length; i++)
            map.put(charr[i], i);
        for (char ch: map.keySet())
            reverse.put(map.get(ch), ch);
        StringBuilder sb = new StringBuilder();
        int left = 0;
        while(!map.isEmpty())
        {
            int right = reverse.firstEntry().getKey();
            char ch = reverse.get(right); 
            if (!map.containsKey(ch)) // already used this
                reverse.remove(right);
            else
            {
                char min = ch; // if we can find smaller letter before
                int min_pos = right; //min pos of this letter
                int i = left;
                left = right + 1;
                for (; i < right; i++)
                {
                    char c = text.charAt(i);
                    if (map.containsKey(c) && c < min)
                    {
                        min = c;
                        left = i + 1;
                    }
                    else if (c == ch && i < min_pos)
                        min_pos = i;
                }
                if (min < ch) //found smaller letter
                	ch = min;
                else
                	left = min_pos+1; //found smaller pos
                if (reverse.containsKey(left-1))
                    reverse.remove(left-1);
                map.remove(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		System.out.println(obj.smallestSubsequence("bdfecedcbfcfeaaffdbaeeabadbbbddddcafdfeeeebfcdabcfaadecddccdefcabedbebbdcbdfefeffcbbeaefaeefeeceadea"));
	}
}

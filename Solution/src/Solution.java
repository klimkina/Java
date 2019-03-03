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
	
	public static int characterReplacement(String s, int k) {
        if (s.length() < k)
            return s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        int K = k;
        for(Character alpha = 'A'; alpha <= 'Z'; alpha++)
        {
            int start = 0;
            k = K;
            for(int i = 0; i < chars.length; i++)
            {
                if (chars[i] != alpha)
                    k--;
                while (k < 0)
                {
                    if (chars[start++] != alpha)
                        k++;
                }
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }
	
	public static void main(final String[] args) {
		System.out.println(characterReplacement("ABBB", 2));
	}
}

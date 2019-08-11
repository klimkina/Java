import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

//Given a string text, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.
class Solution {
	public int maxRepOpt1(String text) {
        HashMap<Character, Integer> firsts = new HashMap<>();
        HashMap<Character, Integer> lasts = new HashMap<>();
        int[] counts = new int[26];
        int n = text.length();
        for(int i = 0; i < n; i++)
        {
            char ch = text.charAt(i);
            counts[ch-'a']++;
            lasts.put(ch, i);
            if (!firsts.containsKey(ch))
                firsts.put(ch, i);
        }
        int start = 0;
        int max = 0;
        int skipped = -1;
        for(char ch:firsts.keySet())
        {
            start = firsts.get(ch);
            skipped = -1;
            for (int i = start+1; i < n; i++)
            {
                if (text.charAt(i) == ch)
                    continue;
                if (skipped < 0)
                {
                    skipped = i;
                    if (i - start+1 > max)
                    {
                        if (counts[ch-'a'] > i - start)
                            max = i -start+1;
                        else
                            max = i - start ;
                    }
                }
                else
                {

                    if (counts[ch-'a'] >= i - start)
                    {
                        max = Math.max(max,i -start);
                    }
                    else
                    {
                        max = Math.max(max,i - start - 1);

                    }
                    if (text.charAt(skipped+1) == ch)
                        start = skipped+1;
                    else
                        start = i;
                    skipped = i;
                }
            }
            if (text.length() - start > max)
            {
                if (counts[ch-'a'] >= text.length() - start)
                    max = text.length() -start;
                else
                    max = text.length() - start - 1;
            }
        }
        return max;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		System.out.println(obj.maxRepOpt1("ababa"));
	}
}

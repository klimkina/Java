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

// Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

// Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
class Solution {
	class Word implements Comparable<Word>
    {
        int freq = 0;
        Word(String s)
        {
            int[] count = new int[26];
            for (char ch: s.toCharArray())
                count[ch - 'a']++;
            for (int i = 0; i < 26; i++)
                if (count[i] > 0)
                {
                    freq = count[i];
                    break;
                }
        }
        @Override
        public int compareTo(Word other){
            // compareTo should return < 0 if this is supposed to be
            // less than other, > 0 if this is supposed to be greater than 
            // other and 0 if they are supposed to be equal
            return this.freq - other.freq;
        }
    }
    
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (String s: words)
        {
            Word w = new Word(s);
            freq.put(w.freq, freq.getOrDefault(w.freq, 0) + 1);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            Word w = new Word(queries[i]);
            Iterator<Map.Entry<Integer, Integer>> it = freq.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry<Integer, Integer> entry = it.next();
                if (entry.getKey() > w.freq)
                    res[i] += entry.getValue();
            }
        }
        return res;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String[] queries = {"bbb","cc"};
		String[] words = {"a","aa","aaa","aaaa", "bb"};
		System.out.println(obj.numSmallerByFrequency(queries, words));
	}
}

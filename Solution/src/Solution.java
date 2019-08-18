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

// You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
class Solution {
	public static class Trie
    {
        int val = 0;
        String str = "";
        Trie[] kids = new Trie[26];
    }
    Trie root = new Trie();
    private void add(String word)
    {
        Trie node = root;
        for (int i = 0; i < word.length(); i++)
        {
            if (node.kids[word.charAt(i) - 'a'] == null)
                node.kids[word.charAt(i) - 'a'] = new Trie();
            node  = node.kids[word.charAt(i) - 'a'];
        }
        node.val++;
        node.str = word;
    }
    private Trie find(Trie node, char ch)
    {
        return node.kids[ch - 'a'];
    }
    public List<Integer> findSubstring(String s, String[] words) 
    {
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        if (n == 0)
        	return res;
        for (int i = 0; i < n; i++)
            add(words[i]);
        int len = words[0].length();
        int str_len = s.length();
        for (int j = 0; j <= str_len - len*n; j++)
        {
            boolean found = true;
            Trie node = root;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = j; i < j + len*n; i++)
            {
                char ch = s.charAt(i);
                node = find(node, ch);
                if(node != null)
                {
                    if(node.val > 0)
                    {
                        int count = map.getOrDefault(node.str, 0);
                        if (count == node.val)
                        {
                            found = false;
                    break;
                        }
                        map.put(node.str, count +1);
                        node = root;
                    }
                }
                else
                {
                    found = false;
                    break;
                }
            }
            if (found)
                res.add(j);
        }
        return res;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String[] words = {};
		System.out.println(obj.findSubstring("", words));
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
*/
class Solution {
	class Trie
    {
        Trie[] kids = new Trie[26];
    }
    private Trie root = new Trie();
    private void add(String s)
    {
        Trie node = root;
        char[] charr = s.toCharArray();
        for (int i = 0; i < charr.length; i++)
        {
            if (node.kids[charr[i] - 'a'] == null)
                node.kids[charr[i] - 'a'] = new Trie();
            node = node.kids[charr[i] - 'a'];
        }
    }
    private boolean find(String s)
    {
        Trie node = root;
        char[] charr = s.toCharArray();
        for (int i = 0; i < charr.length; i++)
        {
            if (node.kids[charr[i] - 'a'] == null)
                return false;
            node = node.kids[charr[i] - 'a'];
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || !wordList.contains(endWord))
            return 0;
        if (beginWord.equals(endWord))
            return 0;
        for(String s: wordList)
            add(s);
        HashSet<String> visited = new HashSet<>();
        HashSet<String> q = new HashSet<>();
        q.add(beginWord);
        HashSet<String> q2 = new HashSet<>();
        q2.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int steps = 1;
        while (!q.isEmpty()&&!q2.isEmpty())
        {
            HashSet<String> qu = new HashSet<>();
            for (String w : q)
            {
                char[] word = w.toCharArray();               
                
                for (int l = 0; l < word.length; l++)
                {
                    char old = word[l];
                    for (char ch = 'a'; ch <= 'z'; ch++)
                    {
                        word[l] = ch;
                        String t = String.valueOf(word);
                        if (q2.contains(t))
                            return steps +1;
                        if (!visited.contains(t) && find(t))
                        {
                            qu.add(t);
                            visited.add(t);
                        }
                    }
                    word[l] = old;
                }
            }
            steps++;  
            if (qu.size() > q2.size())
            {
                q = q2;
                q2 = qu;
            }
            else
                q = qu;
        }
        return 0;
    }
	public static void main(String[] args) {   	

		String begin = "hit";
		String end = "cog";
		String[] dict = {"hot","dot","dog","lot","log","cog"};
		int res = ladderLength(begin, end, dict);
	}
}

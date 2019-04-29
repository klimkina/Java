import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class Solution {
	class Trie{
        String word = "";
        Trie[] kids = new Trie[26];
    }
    private Trie root = new Trie();
    private void add(String word)
    {
        char[] charr = word.toCharArray();
        Trie node = root;
        for (int i = 0; i < charr.length; i++)
        {
            if (node.kids[charr[i]-'a'] == null)
                node.kids[charr[i]-'a'] = new Trie();
            node = node.kids[charr[i]-'a'];
        }
        node.word = word;
    }
    private Trie find (Trie node, char ch)
    {
        return node.kids[ch-'a'];
    }
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < words.length; i++)
            add(words[i]);
        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                int[][] visited = new int[m][n];
                dfs(board,i,j,root,visited, res);
            }
        return new ArrayList<String>(res);
    }
    private void dfs(char[][] board, int i, int j, Trie root, int[][] visited, Set<String> res)
    {
        Trie node = find(root, board[i][j]);        
        if (node != null)
        {
            if (!node.word.isEmpty())
                res.add(node.word);
            visited[i][j] = 1;
            int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
            for (int k = 0; k < d.length; k++)
            {
                int new_i = i+ d[k][0];
                int new_j = j + d[k][1];
                if (inBound(board, new_i, new_j) && visited[new_i][new_j] == 0)
                    dfs(board, new_i, new_j, node, visited, res);
            }
            visited[i][j] = 0;
        }
    }
    private boolean inBound(char[][] board, int i, int j)
    {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    
    }
	
	public static void main(final String[] args) {
		Solution obj = new Solution();
		
		System.out.println();
	}
}

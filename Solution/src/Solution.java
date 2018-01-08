import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	private boolean[][] marked;
	HashSet<String> res_words;
	private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }
	private static final int R = 26;
	 // R-way trie node
	private class TrieST26<Value> {
        
        private Node root;      // root of trie
        private int n;          // number of keys in trie

        

       /**
         * Initializes an empty string symbol table.
         */
        public TrieST26() {
        }


        /**
         * Returns the value associated with the given key.
         * @param key the key
         * @return the value associated with the given key if the key is in the symbol table
         *     and {@code null} if the key is not in the symbol table
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public Value get(String key) {
            Node x = get(root, key, 0);
            if (x == null) return null;
            return (Value) x.val;
        }

        /**
         * Does this symbol table contain the given key?
         * @param key the key
         * @return {@code true} if this symbol table contains {@code key} and
         *     {@code false} otherwise
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public boolean contains(String key) {
            return get(key) != null;
        }

        private Node get(Node x, String key, int d) {
            if (x == null) return null;
            if (d == key.length()) return x;
            char c = key.charAt(d);
            return get(x.next[c - 'a'], key, d+1);
        }

        /**
         * Inserts the key-value pair into the symbol table, overwriting the old value
         * with the new value if the key is already in the symbol table.
         * If the value is {@code null}, this effectively deletes the key from the symbol table.
         * @param key the key
         * @param val the value
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public void put(String key, Value val) {
            if (val == null) delete(key);
            else root = put(root, key, val, 0);
        }

        private Node put(Node x, String key, Value val, int d) {
            if (x == null) x = new Node();
            if (d == key.length()) {
                if (x.val == null) n++;
                x.val = val;
                return x;
            }
            char c = key.charAt(d);
            x.next[c - 'a'] = put(x.next[c - 'a'], key, val, d+1);
            return x;
        }

        /**
         * Returns the number of key-value pairs in this symbol table.
         * @return the number of key-value pairs in this symbol table
         */
        public int size() {
            return n;
        }

        /**
         * Is this symbol table empty?
         * @return {@code true} if this symbol table is empty and {@code false} otherwise
         */
        public boolean isEmpty() {
            return size() == 0;
        }

        /**
         * Returns all keys in the symbol table as an {@code Iterable}.
         * To iterate over all of the keys in the symbol table named {@code st},
         * use the foreach notation: {@code for (Key key : st.keys())}.
         * @return all keys in the symbol table as an {@code Iterable}
         */
        public Iterable<String> keys() {
            return keysWithPrefix("");
        }

        /**
         * Returns all of the keys in the set that start with {@code prefix}.
         * @param prefix the prefix
         * @return all of the keys in the set that start with {@code prefix},
         *     as an iterable
         */
        public Iterable<String> keysWithPrefix(String prefix) {
            Queue<String> results = new LinkedList<String>();
            Node x = get(root, prefix, 0);
            collect(x, new StringBuilder(prefix), results);
            return results;
        }

        private void collect(Node x, StringBuilder prefix, Queue<String> results) {
            if (x == null) return;
            if (x.val != null) results.add(prefix.toString());
            for (char c = 0; c < R; c++) {
                prefix.append((char)(c + 'a'));
                collect(x.next[c], prefix, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }

        /**
         * Returns all of the keys in the symbol table that match {@code pattern},
         * where . symbol is treated as a wildcard character.
         * @param pattern the pattern
         * @return all of the keys in the symbol table that match {@code pattern},
         *     as an iterable, where . is treated as a wildcard character.
         */
        public Iterable<String> keysThatMatch(String pattern) {
            Queue<String> results = new LinkedList<String>();
            collect(root, new StringBuilder(), pattern, results);
            return results;
        }

        private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
            if (x == null) return;
            int d = prefix.length();
            if (d == pattern.length() && x.val != null)
                results.add(prefix.toString());
            if (d == pattern.length())
                return;
            char c = pattern.charAt(d);
            if (c == '.') {
                for (char ch = 0; ch < R; ch++) {
                    prefix.append(ch + 'a');
                    collect(x.next[ch], prefix, pattern, results);
                    prefix.deleteCharAt(prefix.length() - 1);
                }
            }
            else {
                prefix.append((char)(c + 'a'));
                collect(x.next[c], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }

        /**
         * Returns the string in the symbol table that is the longest prefix of {@code query},
         * or {@code null}, if no such string.
         * @param query the query string
         * @return the string in the symbol table that is the longest prefix of {@code query},
         *     or {@code null} if no such string
         * @throws NullPointerException if {@code query} is {@code null}
         */
        public String longestPrefixOf(String query) {
            int length = longestPrefixOf(root, query, 0, -1);
            if (length == -1) return null;
            else return query.substring(0, length);
        }

        // returns the length of the longest string key in the subtrie
        // rooted at x that is a prefix of the query string,
        // assuming the first d character match and we have already
        // found a prefix match of given length (-1 if no such match)
        private int longestPrefixOf(Node x, String query, int d, int length) {
            if (x == null) return length;
            if (x.val != null) length = d;
            if (d == query.length()) return length;
            char c = query.charAt(d);
            return longestPrefixOf(x.next[c - 'a'], query, d+1, length);
        }

        /**
         * Removes the key from the set if the key is present.
         * @param key the key
         * @throws NullPointerException if {@code key} is {@code null}
         */
        public void delete(String key) {
            root = delete(root, key, 0);
        }

        private Node delete(Node x, String key, int d) {
            if (x == null) return null;
            if (d == key.length()) {
                if (x.val != null) n--;
                x.val = null;
            }
            else {
                char c = key.charAt(d);
                x.next[c - 'a'] = delete(x.next[c - 'a'], key, d+1);
            }

            // remove subtrie rooted at x if it is completely empty
            if (x.val != null) return x;
            for (int c = 0; c < R; c++)
                if (x.next[c] != null)
                    return x;
            return null;
        }
    }
    private TrieST26<Boolean> dictionary;
	public List<String> findWords(char[][] board, String[] words) {
		res_words = new HashSet<String>();
		if(board.length != 0) {
			this.dictionary = new TrieST26<Boolean>();
			for(int i = 0; i < words.length; i++)
				dictionary.put(words[i], true);
	        for (int row = 0; row < board.length; row++)
	            for (int col = 0; col < board[0].length; col++)
	            {
	                marked = new boolean[board.length][board[0].length];
	                String s = "" + board[row][col];
	                /*if (s.equals("Q"))
	                    s = "QU";*/
	                dfs(row, col, board, s);
	            }
		}
		List<String> list = new ArrayList<String>(res_words);
        return list;
    }
	private void dfs(int row, int col, char[][] board, String prefix)
    {
         marked[row][col] = true;
         if(dictionary.contains("" + board[row][col]))
        		 res_words.add("" + board[row][col]);
         if(res_words.size() == dictionary.size())
        	 return;
         int[] dx = {-1, 1, 0, 0};
         int[] dy = {0, 0, -1, 1};
         for (int i = 0; i < 4; i++) {
        	 int new_row = row + dy[i];
        	 int new_col = col + dx[i];
             if (new_row >= 0 && new_row < board.length &&
            		 new_col >= 0 && new_col < board[0].length &&
            		 !marked[new_row][new_col]) {
                 String s = "" + board[new_row][new_col];
                 /*if (s.equals("Q"))
                     s = "QU";*/
                 String str = dictionary.keysWithPrefix(prefix + s).toString();
                 if (!str.isEmpty())
                 {
                     if (dictionary.contains(prefix + s) && (prefix + s).length() > 0)
                    	 res_words.add(prefix + s);
                     dfs(new_row, new_col, board, prefix + s);
                 }
             }
         }
         marked[row][col] = false;
    }
	
	    
    public static void main(String[] args) {
    	String[] words = {"abbbababaa"};
    	char[][] board = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},
    			{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},
    			{'a','b','a','a','b','b'}};
    			
    	Solution obj = new Solution();
    	List<String> strs = obj.findWords(board, words);
    	for(String s: strs)
    		System.out.println(s);
    }
}
import java.util.ArrayList;
import java.util.HashSet;
import edu.princeton.cs.algs4.Queue;

public class BoggleSolver
{
    private class Coordinate {
        private int x;
        private int y;
        private Coordinate(int row, int col)
        {
            x = row;
            y = col;
        }
    }
    private static final int R = 26;
 // R-way trie node
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }
    
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
            return get(x.next[c - 'A'], key, d+1);
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
            x.next[c - 'A'] = put(x.next[c - 'A'], key, val, d+1);
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
            Queue<String> results = new Queue<String>();
            Node x = get(root, prefix, 0);
            collect(x, new StringBuilder(prefix), results);
            return results;
        }

        private void collect(Node x, StringBuilder prefix, Queue<String> results) {
            if (x == null) return;
            if (x.val != null) results.enqueue(prefix.toString());
            for (char c = 0; c < R; c++) {
                prefix.append((char)(c + 'A'));
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
            Queue<String> results = new Queue<String>();
            collect(root, new StringBuilder(), pattern, results);
            return results;
        }

        private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
            if (x == null) return;
            int d = prefix.length();
            if (d == pattern.length() && x.val != null)
                results.enqueue(prefix.toString());
            if (d == pattern.length())
                return;
            char c = pattern.charAt(d);
            if (c == '.') {
                for (char ch = 0; ch < R; ch++) {
                    prefix.append(ch + 'A');
                    collect(x.next[ch], prefix, pattern, results);
                    prefix.deleteCharAt(prefix.length() - 1);
                }
            }
            else {
                prefix.append((char)(c + 'A'));
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
            return longestPrefixOf(x.next[c - 'A'], query, d+1, length);
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
                x.next[c - 'A'] = delete(x.next[c - 'A'], key, d+1);
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
    private boolean[][] marked;
    private HashSet<String> words;
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary)
    {
        if (dictionary == null)
            throw new java.lang.NullPointerException("Empty Dictionary");
        this.dictionary = new TrieST26<Boolean>();
        for (String s : dictionary)
            this.dictionary.put(s, true);
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
        words = new HashSet<String>();
        for (int row = 0; row < board.rows(); row++)
            for (int col = 0; col < board.cols(); col++)
            {
                marked = new boolean[board.rows()][board.cols()];
                String s = "" + board.getLetter(row, col);
                if (s.equals("Q"))
                    s = "QU";
                dfs(row, col, board, s);
            }
        return words;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word)
    {
        int res = word.length();
        if (res > 2 && dictionary.contains(word))
            switch (res) {
            case 3: 
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            default:
                return 11;
            }
        return 0;
    }
    private Iterable<Coordinate> adj(int row, int col, int rows, int cols)
    {
        ArrayList<Coordinate> res = new ArrayList<Coordinate>();
        if (row > 0)
            res.add(new Coordinate(row - 1, col));
        if (row < rows - 1)
            res.add(new Coordinate(row + 1, col));
        if (col > 0) {
            res.add(new Coordinate(row, col - 1));
            if (row > 0)
                res.add(new Coordinate(row - 1, col - 1));
            if (row < rows - 1)
                res.add(new Coordinate(row + 1, col - 1));
        }
        if (col < cols - 1) {
            res.add(new Coordinate(row, col + 1));
            if (row > 0)
                res.add(new Coordinate(row - 1, col + 1));
            if (row < rows - 1)
                res.add(new Coordinate(row + 1, col + 1));
        }
        return res;
    }
    
    private void dfs(int row, int col, BoggleBoard board, String prefix)
    {
         marked[row][col] = true;
         for (Coordinate cor : adj(row, col, board.rows(), board.cols()))
             if (!marked[cor.x][cor.y]) {
                 String s = "" + board.getLetter(cor.x, cor.y);
                 if (s.equals("Q"))
                     s = "QU";
                 String str = dictionary.keysWithPrefix(prefix + s).toString();
                 if (!str.isEmpty())
                 {
                     if (dictionary.contains(prefix + s) && (prefix + s).length() > 2)
                         words.add(prefix + s);
                     dfs(cor.x, cor.y, board, prefix + s);
                 }
             }
         marked[row][col] = false;
    }
    
}
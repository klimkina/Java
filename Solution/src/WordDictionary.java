
public class WordDictionary {
	class Trie
    {
        boolean word = false;
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
        node.word = true;
    }
    private boolean search(Trie trie, String s)
    {
        Trie node = trie;
        if (s.isEmpty())
            return trie.word;
        char[] charr = s.toCharArray();
        for (int i = 0; i < charr.length; i++)
        {
            if (charr[i] == '.')
            {
                String t = new String(charr, i+1, charr.length-i-1);
                for (Trie kid : node.kids)
                    if (kid != null && search(kid, t))
                        return true;
                return false;
            }
            if (node.kids[charr[i] - 'a'] == null)
                return false;;
            node = node.kids[charr[i] - 'a'];
        }
        return node.word;
    }
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary dict = new WordDictionary();
		dict.addWord("at");
		dict.addWord("add");
		dict.addWord("an");
		dict.addWord("and");
		System.out.println(dict.search("a"));// -> false
		System.out.println(dict.search(".at"));// -> true
		dict.addWord("bat");
		System.out.println(dict.search(".at"));// -> true
		System.out.println(dict.search("an."));// -> true
		System.out.println(dict.search("a.d."));// -> false
		System.out.println(dict.search("b."));// -> true
		System.out.println(dict.search("a.d"));// -> true
		System.out.println(dict.search("."));// -> true
	}

}

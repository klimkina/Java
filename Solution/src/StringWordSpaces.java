
public class StringWordSpaces {
	private static final int R = 26;
	// R-way trie node
	private static class TrieNode {
		String word = "";
		TrieNode[] kids = new TrieNode[R];
		public void insert(char[] charr, int start) {
			if(start == charr.length)
				word = String.valueOf(charr);
			else {
				if(kids[charr[start] - 'a'] == null)
					kids[charr[start] - 'a'] = new TrieNode();
				
				kids[charr[start] - 'a'].insert(charr, start+1);
			}
		}
		public boolean isPrefix(char[] charr, int start) {
			if(start == charr.length)
				return true;
			if(kids[charr[start] - 'a'] == null)
				return false;
			return kids[charr[start] - 'a'].isPrefix(charr, start+1);
		}
		public boolean contains(char[] charr, int start) {
			if(start == charr.length)
				return !word.isEmpty();
			if(kids[charr[start] - 'a'] == null)
				return false;
			return kids[charr[start] - 'a'].contains(charr, start+1);
		}
		public boolean isWord() {
			return !word.isEmpty();
		}
	}
	public static class Trie{
		TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String s) {
			char[] charr = s.toCharArray();
			root.insert(charr, 0);
		}
		public boolean isPrefix(String s) {
			char[] charr = s.toCharArray();
			return root.isPrefix(charr, 0);
		}
		public boolean contains(String s) {
			char[] charr = s.toCharArray();
			return root.contains(charr, 0);
		}
		private TrieNode get(TrieNode x, String key, int d) {
            if (x == null) return null;
            if (d == key.length()) return x;
            char c = key.charAt(d);
            return get(x.kids[c - 'a'], key, d+1);
        }
	}
	private Trie dict;
	public String breakString(String s, String[] dictionary) {
		dict = new Trie();
		for(String str:dictionary)
			dict.insert(str);
		//return dfs(s);
		return partitionWords(s, "", "", dict.root);
	}
	private String partitionWords(String lettersLeft, String wordSoFar, String wordBreaks, TrieNode trieNode){
	    // If you walked off the trie, this path fails.
	    if(trieNode == null) return "";

	    // If this trie node is a word, consider what happens if you split
	    // the word here.
	    if(trieNode.isWord()) {
	        // If there is no input left, you're done and have a partition.
	        if(lettersLeft.isEmpty())
	        	return wordBreaks + " " + wordSoFar;
	        else
	        // Otherwise, try splitting here.
	        	return partitionWords(lettersLeft, "", wordBreaks + wordSoFar, dict.root);
	    }
	    // Otherwise, consume the next letter and continue:
	    return partitionWords(lettersLeft.substring(1), wordSoFar + lettersLeft.charAt(0), 
	                   wordBreaks, trieNode.kids[lettersLeft.charAt(0) - 'a']);
	}
	
	private String dfs(String s) {
		if(dict.contains(s))
			return s;
		for(int i = 1; i < s.length(); i++)
			if(dict.contains(s.substring(0, i))) {
				String s2 = dfs(s.substring(i, s.length()));
				if(!s2.isEmpty())
					return s.substring(0, i) + " " + s2;
			}
		return "";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dictionary = {"apple", "pie", "orange"};
		StringWordSpaces obj = new StringWordSpaces();
		System.out.println(obj.breakString("applepie", dictionary));
	}

}

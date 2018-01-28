
public class Trie {

	    private static class Node {
	        String val;
	        Node[] kids = new Node[26];
	        
	    }

	    private Node root;
	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new Node();
	    }
	    
	    private Node put(Node node, String s, int idx) {
	        if(node == null)
	            node = new Node();
	        if(idx == s.length()) {
	            node.val = s;
	            return node;
	        }
	        node.kids[s.charAt(idx) - 'a'] = put(node.kids[s.charAt(idx) - 'a'], s, idx+1);
	        return node;
	    }
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        put(root, word, 0);
	    }
	    
	    private Node get(Node node, String s, int idx) {
	        
	        if(node == null || idx == s.length())
	            return node;
	        return get(node.kids[s.charAt(idx) - 'a'], s, idx+1);
	    }
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	Node res = get(root, word, 0);
	        return (res != null && res.val != null && res.val.equals(word));
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        return (get(root, prefix, 0) != null);
	    }
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Trie obj = new Trie();
			obj.insert("ab");
			System.out.println(obj.search("a"));
			System.out.println(obj.startsWith("a"));
		}
	
}

class StreamChecker {
	class Trie
    {
        boolean word = false;
        Trie[] kids = new Trie[26];
    }
    private void add(String s, Trie root)
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
    List<Trie> current = new ArrayList<>();
    Trie root = new Trie();
    public StreamChecker(String[] words) {
        for (int i = 0; i < words.length; i++)
            add(words[i], root);
    }
    
    public boolean query(char letter) {
        
        //System.out.println(root);
        
        Iterator<Trie> iter = current.iterator();
        boolean res = false;
        List<Trie> toAdd = new ArrayList<>();
        if (root.kids[letter-'a'] != null)
        {
            toAdd.add(root.kids[letter-'a']);
            if (root.kids[letter-'a'].word)
                res = true;
        }
        while(iter.hasNext())
        {
            Trie node = iter.next();
            node = node.kids[letter-'a'];
            if (node != null)                
            {
                toAdd.add(node);
                if (node.word)
                    res = true;
            }
        }
        current = toAdd;
        return res;
    }
}
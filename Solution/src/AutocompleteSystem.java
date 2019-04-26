import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class AutocompleteSystem {
	class Trie
    {
        int inputs = 0;
        HashMap<Character, Trie> kids = new HashMap<>();
        String sentence = "";
    }
    private void add(String s, int rep)
    {
        char[] charr = s.toCharArray();
        Trie node = root;
        for (int i = 0; i < charr.length; i++)
        {
            if (node.kids.get(charr[i]) == null)
                node.kids.put(charr[i], new Trie());
            node = node.kids.get(charr[i]);
        }
        node.inputs += rep;
        node.sentence = s;
        
    }
    private List<String> find(String s)
    {
        List<String> res = new ArrayList<>();
        char[] charr = s.toCharArray();
        Trie node = root;
        for (int i = 0; i < charr.length; i++)
        {
            if (node.kids.get(charr[i]) == null)
                return res;
            node = node.kids.get(charr[i]);
        }
        PriorityQueue<Trie> pq = new PriorityQueue<Trie>(3, new Comparator<Trie>() {
            public int compare(Trie t1, Trie t2) {
                if (t2.inputs != t1.inputs)
                    return t2.inputs - t1.inputs;
                else
                    return t1.sentence.compareTo(t2.sentence);
            }
        });
        Stack<Trie> stack = new Stack<>();
        stack.push(node);
        
        while (!stack.isEmpty())
        {
            node = stack.pop();
            if (node != null)
            {
                
                if (node.inputs > 0)
                    pq.offer(node);             
                
                for (char ch: node.kids.keySet())                    
                    stack.push(node.kids.get(ch));
                
            }
        }
        for (int i = 0; i < 3; i++)
            if (!pq.isEmpty())
                res.add(pq.poll().sentence);
            
        return res;
    }
    
    private StringBuilder sb = new StringBuilder();
    private Trie root = new Trie();
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++)
            add(sentences[i], times[i]);
    }
    
    public List<String> input(char c) {
        if (c == '#')
        {
            add(sb.toString(), 1);
            sb.setLength(0);
            return new ArrayList<String>();
        }
        sb.append(c);
        return find(sb.toString());
        
    }
    
    public static void main(final String[] args) {
    	String[] sents = {"i love you","island","iroman","i love leetcode"};
    	int[] times = {5,3,2,2};
    	AutocompleteSystem obj = new AutocompleteSystem(sents, times);
    	List<String> l = obj.input('i');
		System.out.print(l.get(0));
	}
}

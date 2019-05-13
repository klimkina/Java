import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

class FreqStack {
    TreeMap<Integer, List<Integer>> tree = new TreeMap<>(); // freq -> list of vals
    HashMap<Integer, Integer> map = new HashMap<>();// val -> freq
    public FreqStack() {
        
    }
    
    public void push(int x) {
        int freq = 1;
        if (map.containsKey(x))
        {
            freq = map.get(x) + 1;
            List<Integer> l = tree.get(freq);
            Iterator<Integer> it = l.iterator();
            while(it.hasNext())
                if (it.next() == x)
                {
                    it.remove();
                    break;
                }
        }
        map.put(x, freq);
        if (tree.get(freq) == null)
            tree.put(freq, new ArrayList<>());
        tree.get(freq).add(0, x);
    }
    
    public int pop() {
        int freq = tree.lastKey();
        List<Integer> l = tree.get(freq);
        int res = l.get(0);
        freq--;
        if (freq > 0)
            map.put(res, freq-1);
        else
        {
            map.remove(res);
            Iterator<Integer> it = l.iterator();
            it.next();
            it.remove();
        }
        return res;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FreqStack obj = new FreqStack();
		obj.push(5);
		obj.push(7);
		obj.push(5);
		obj.push(7);
		obj.push(4);
		obj.push(5);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
	}

}

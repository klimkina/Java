import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
    public static class ListElem
    {
        public int val;
        public ListElem next;
        public ListElem prev;
        public ListElem(int val)
        {
            this.val = val;
        }
        public ListElem insert(int val)
        {
            ListElem elem = new ListElem (val);
            ListElem nextnext = this.next;
            this.next = elem;
            elem.next = nextnext;
            elem.prev = this;
            if (nextnext != null)
                nextnext.prev = elem;
            return elem;
        }
    }
    private TreeMap<Integer, ListElem> freq2x = new TreeMap<>();
    private HashMap<Integer, Integer> x2freq = new HashMap<>();
    ListElem head = null;
    ListElem tail = null;
    public Solution() {
        
    }
    
    public void push(int x) {
        int freq = x2freq.getOrDefault(x, 0) + 1;
        x2freq.put(x, freq);
        if (head == null)
        {
            head = new ListElem(x);
            tail = head;
            freq2x.put(freq, head);
        }
        else
        {
            ListElem elem = freq2x.floorEntry(freq).getValue();
            freq2x.put(freq, elem.insert(x));
            if (elem == tail)
                tail = elem.next;
        }
    }
    
    public int pop() {
        int res = tail.val;        
        if (freq2x.get(x2freq.get(res)) == tail)
        	freq2x.put(x2freq.get(res), tail.prev);
    	x2freq.put(res, x2freq.get(res) - 1);
        tail = tail.prev;
        return res;
    }

    public static void main(String[] args) 
    {
    	Solution obj = new Solution();
    	obj.push(2);
    	obj.push(2);
    	obj.push(2);
    	obj.push(2);
    	obj.push(2);
    	obj.push(2);
    	obj.push(3);
    	obj.push(3);
    	obj.push(3);
    	obj.push(4);
    	obj.push(4);
    	System.out.println(obj.pop());
    	System.out.println(obj.pop());
    	obj.push(1);
    	System.out.println(obj.pop());
    	obj.push(1);
    	System.out.println(obj.pop());
    	obj.push(4);
    	System.out.println(obj.pop());
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


class Solution {
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	};
	public Node flatten(Node head) {
        Node node = head;
        node = flat(node);
        //printNext(head);
        //printPrev(node);
        return head;
    }
    public Node flat(Node head) {
        while (head != null)
        {
            if (head.child != null)
            {
                Node next = head.next;
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                head = flat(head.next);
                head.next = next;
                if (next != null)
                    next.prev = head;
            }
            if (head.next == null)
                return head;
            else
                head = head.next;
        }
        return head;
    }
    private void printNext(Node head)
    {
        while (head != null)
        {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
    private void printPrev(Node head)
    {
        while (head != null)
        {
            System.out.print(head.val + "->");
            head = head.prev;
        }
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		//System.out.println(obj.frequencySort("tree"));
	}
}

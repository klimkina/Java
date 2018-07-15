import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static  class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
        LinkedList<TreeLinkNode> pq = new LinkedList<>();
        pq.offer(root);
        connect(pq);
    }
	public static void connect(LinkedList<TreeLinkNode> pq) {
		if (pq.isEmpty())
			return;
        
        int size = pq.size();
        int zeroes = 0;
        TreeLinkNode next;
        for (int i = 0; i < size; i++)
        {
        	TreeLinkNode node = pq.poll();
            if (i < size -1)
                next = pq.peek();
            else
                next = null;
        	if (node == null)
        		{pq.offer(null); pq.offer(null);zeroes++;}
        	else 
    		{
                node.next = next;
        		pq.offer(node.left);
        		pq.offer(node.right);
    		}
        }
        if (zeroes < size)
        	connect(pq);
    }
	
    public static void main(String[] args) {
    	TreeLinkNode node1 = new TreeLinkNode(1);
    	TreeLinkNode node2 = new TreeLinkNode(2);
    	TreeLinkNode node3 = new TreeLinkNode(3);
    	TreeLinkNode node4 = new TreeLinkNode(4);
    	TreeLinkNode node5 = new TreeLinkNode(5);
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
    	node3.right = node5;
    	connect(node1);
    	//System.out.println(oneEditApart("one", "onee"));
    	
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

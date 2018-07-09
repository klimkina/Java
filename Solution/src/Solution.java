import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
			
	private static HashMap<RandomListNode, RandomListNode> copied;
    public static RandomListNode copyRandomList(RandomListNode head) {
    	copied = new HashMap<>();
        RandomListNode node = copyNode(head);
        RandomListNode prev = node;
        RandomListNode res = node;
        RandomListNode next = head;
        while(prev != null && next != null)
        {
            next = next.next;
            node = copyNode(next);
            prev.next = node;
            prev = node;
        }
        return res;
    }

    private static RandomListNode copyNode (RandomListNode head)
    {
        if (head == null)
            return null;
        if(copied.containsKey(head))
            return copied.get(head);
        RandomListNode node = new RandomListNode(head.label);  
        if (copied.containsKey(head.next))
            node.next = copied.get(head.next);
        copied.put(head, node);
        if (head.random != null)
        {
            if (copied.containsKey(head.random))
                node.random = copied.get(head.random);
            else
            {
                RandomListNode random = copyNode(head.random);
                node.random = random;
            }
        }      
        
        return node;
    }
		
    public static void main(String[] args) {
    	RandomListNode node1 = new RandomListNode(1);
    	RandomListNode node2 = new RandomListNode(2);
    	node1.next = node2;
    	node1.random = node2;
    	node2.random = node1;
    	RandomListNode copy = copyRandomList(node1);
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

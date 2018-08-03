import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
		 }
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = null;
        if(l1 == null && l2 == null)
            return l;
        if(l1 == null)
            l = l2;
        else
        {
            if (l2 == null || l1.val < l2.val)
                l = l1;
            else
                l = l2;
        }
        if(l == l1)
            l1 = l1.next;
        else
            l2 = l2.next;
        ListNode start = l;
        while(l1 != null && l2 !=null)
        {
            if(l1.val < l2.val)
            {
                l.next = l1;
                l1 = l1.next;
            }
            else
            {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if(l1 != null)
        	l.next = l1;
        else
        	l.next = l2;
        return start;
    }
	
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(4);
    	l1.next = l2;
    	l2.next = l3;
    	ListNode l4 = new ListNode(1);
    	ListNode l5 = new ListNode(3);
    	ListNode l6 = new ListNode(4);
    	l4.next = l5; l5.next = l6;
    	ListNode l = mergeTwoLists(l1, l4);
    	while(l != null)
    	{
    		System.out.println(l.val);
    		l = l.next;
    	}
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

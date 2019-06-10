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
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
	public ListNode reverseKGroup(ListNode head, int k) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode prev = dummy;
	        ListNode node = head;
	        while(node != null && node.next != null)
	        {
	            int left = k;
	            ListNode start = node;
	            ListNode prev_start = prev;
	            ListNode t = node;
	            int i = 0;
	            for (; i < k; i++)
	                if (t == null)
	                    break;
	                else
	                    t = t.next;
	            if (i < k)
	                break;
	            while(node != null && left > 0)
	            {
	                ListNode next = node.next;
	                node.next = prev;
	                prev = node;
	                node = next;
	                left--;                
	            }
	            prev_start.next = prev;
	            prev = start;
	            start.next = node;
	        }
	        return dummy.next;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		obj.reverseKGroup(head, 3);
	}
}

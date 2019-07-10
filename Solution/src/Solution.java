import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;


class Solution {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head.next;
        ListNode prev = head;
        prev.next = null;
        //reverse while insert
        while (curr != null)
        {
            //System.out.print(curr.val + " ");
            ListNode node = curr.next;
            ListNode next = prev;
            ListNode t = prev;
            boolean moved = false;
            while (next != null && next.val > curr.val)
            {
                t = next;
                next = next.next;
                moved = true;
            }
            curr.next = next;
            if (moved)
            	t.next = curr;  
            if (curr.val >= prev.val)
            	prev = curr;
            curr = node;
        }
        //System.out.println();
        curr = prev;
        prev = null;
        // reverse back
        while (curr.next != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            //if (prev != null)
            //    prev.next = curr;
            prev = curr;
            curr = next;
            System.out.println(prev.val);
        }
        curr.next = prev;
        return curr;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(0);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		System.out.println(obj.insertionSortList(node1).val);
	}
}

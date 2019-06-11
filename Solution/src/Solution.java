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
	public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode node = head;
        int count = 0;
        while (node != null)
        {
            node = node.next;
            count++;
        }
        node = head;
        ListNode prev = node;
        for (int i = 0; i < count/2; i++)
        {
            prev = node;
            node = node.next;
        }
        
        while(node.next != null)
        {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        if (node != null)
            node.next = prev;
        for (int i = 0; i < count/2; i++)
        {
            if (node.val != head.val)
                return false;
            node = node.next;
            head = head.next;
        }
        return true;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		ListNode list = new ListNode(1);
		ListNode list1 = new ListNode(2);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(1);
		list.next = list1; list1.next = list2; list2.next = list3;
		obj.isPalindrome(list);
	}
}

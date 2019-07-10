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
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public void reorderList(ListNode head) {
        if (head != null)
        {
            ListNode slow = head;
            ListNode fast = head;
            //find mid
            while (fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next;
                if (fast.next != null)
                    fast = fast.next;
            }
            ListNode prev = null;            
            //reverse end
            while (slow != null)
            {
                ListNode node = slow.next;
                slow.next = prev;
                prev = slow;
                slow = node;
                
            }
            ListNode left = head;
            ListNode right = prev;
            while (left != null && right != null && right.next != null)
            {
                //System.out.println(left.val + " " + right.val);
                ListNode node = right.next;
                right.next = left.next;
                left.next = right;
                left = right.next;
                right = node;
            }
        }
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] books = {{9,9},{5,4},{3,1},{1,5},{7,3}};
		//System.out.println(obj.minHeightShelves(books, 10));
	}
}

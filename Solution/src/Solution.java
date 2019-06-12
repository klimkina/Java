import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


class Solution {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
	    /** @param head The linked list's head.
	        Note that the head is guaranteed to be not null, so it contains at least one node. */
	    ListNode head;
	    Random rand = new Random(); 
	    public Solution(ListNode head) {
	        this.head = head;
	    }
	    
	    /** Returns a random node's value. */
	    public int getRandom() {
	        ListNode node = head;
	        // Initialize result as first node 
	        int result = node.val;   
	        for (int n = 1; node != null; n++) { 
	  
	            // change result with probability 1/n 
	            if (rand.nextInt(n) == 0) { 
	                result = node.val; 
	            } 
	  
	            // Move to next node 
	            node = node.next; 
	        } 
	        return result;
	    }
	}
  
    
	public static void main(String[] args) {   	
		Solution obj = new Solution(new ListNode(0));
		int[] nums = {1,2,3};
		//System.out.println(obj.frequencySort("tree"));
	}
}

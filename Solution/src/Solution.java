/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		      ListNode(int[] x) {
		    	  val = x[0];
		    	  if(x.length == 1)
		    		  return;
		    	  ListNode prev = new ListNode(x[1]);
		    	  next = prev;
		    	  for(int i = 2; i < x.length; i++) {
		    		  ListNode temp = new ListNode(x[i]);
		    		  prev.next = temp;
		    		  prev = temp;
		    	  }
		      }
		      public String toString() { 
		    	  StringBuilder res = new StringBuilder();
		    	  res.append(val);
		    	  ListNode temp = next;
		    	  while(temp != null) {
		    		  res.append(temp.val);
		    		  temp = temp.next;
		    	  }
		    	  return res.toString();
		    	} 
		  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int res = l1.val + l2.val;
    	int mem = res /  10;
    	ListNode first = new ListNode(res % 10);
    	ListNode prev = first;
    	l1 = l1.next;
		l2 = l2.next;
    	while(l1 != null || l2 != null || mem > 0) {
    		res = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + mem % 10;
    		mem = mem/10 + res/10;
    		ListNode next = new ListNode(res % 10);
    		prev.next = next;
    		prev = next;
    		if(l1 != null)
    			l1 = l1.next;
    		if (l2 != null)
    			l2 = l2.next;
    	}
    
    	return first;
        
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[] x1 = {5};
    	int[] x2 = {5};
    	ListNode l1 = new ListNode(x1);
    	ListNode l2 = new ListNode(x2);
    	System.out.println(obj.addTwoNumbers(l1, l2));
    	
    }
}
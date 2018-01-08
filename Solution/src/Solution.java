import java.util.Random;

class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	private int size;
	private ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ListNode curr = head;
        size = 0;
        while(curr != null) {
        	size++;
        	curr = curr.next;
        }
        
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(size);
        ListNode curr = head;
        int count = 0;
        while(curr != null && count < index) {
        	count++;
        	curr = curr.next;
        }
        return curr.val;
    }
	
	    
    public static void main(String[] args) {   			
    	Solution obj = new Solution();
    }
}
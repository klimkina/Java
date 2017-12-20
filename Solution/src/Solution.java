
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
	public ListNode reverseList(ListNode list) {
		ListNode prev = null;
		ListNode curr = list;
		ListNode next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
        return prev;
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[] x = {1,2,3,4,5};
    	ListNode list = new ListNode(x);
    	System.out.println(obj.reverseList(list));
    	
    }
}
import java.util.Stack;

class Solution {
	 public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
		 }
	 public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
    		
    		int visited = 1;
    		while(!(stack.isEmpty() && root == null)) {
    			if(root != null) {
    				stack.push(root);
    				root = root.left;
    			}
    			else {
    				root = stack.pop();
    				if(visited++ == k)
    					return root.val;
    				root = root.right;
    			}
    		} 
            return 0;
        }
    }
	    
    public static void main(String[] args) {
    	
    	};
    	
        
    }
}
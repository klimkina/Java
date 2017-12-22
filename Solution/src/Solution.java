import java.util.Stack;

class Solution {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(int[] x) { 
			val = x[0];
			for(int i = 1; i < x.length; i++)
				insert(x[i]);
		}
		private void insert(int val) {
			if(val > this.val)
				if (right == null)
					right = new TreeNode(val);
				else
					right.insert(val);
			else if (val < this.val)
				if(left == null)
					left = new TreeNode(val);
				else
					left.insert(val);
		}
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
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[] arr = {5, 2, 7, 1, 3, 6, 8 };
    	TreeNode tree = new TreeNode(arr);
    	int k = 5;
    	System.out.println(obj.kthSmallest(tree, k));
    	
    }
}
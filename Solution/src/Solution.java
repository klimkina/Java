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
		int visited = 0;
		TreeNode node;
		int res = 0;
		while(root != null) {
			if(root.left != null) {
				node = findRightest(root);
				if(node.right == null) {
					node.right = root;
					root = root.left;
				}
				else {					
					node.right = null;
					if(++visited == k)
						return root.val;
					root = root.right;
				}
			}
			else {
				if(++visited == k)
					return root.val;
				root = root.right;
			}
		} 
        return res;
    }
	private TreeNode findRightest(TreeNode root) {
		TreeNode prev = root.left;
		while(prev.right != null && prev.right != root)
			prev = prev.right;
		return prev;
	}
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[] arr = {5, 2, 7, 1, 3, 6, 8 };
    	TreeNode tree = new TreeNode(arr);
    	int k = 5;
    	System.out.println(obj.kthSmallest(tree, k));
    	
    }
}
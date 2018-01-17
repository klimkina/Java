/*Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/
class Solution {
	public int closestValue(TreeNode root, double target) {
		if(root.val == target)
			return root.val;
		int res;
		int val = root.val;
		if(root.val > target) {
			if(root.left == null)
				return root.val;
			root = root.left;
		}
		else {
			if(root.right == null)
				return root.val;
			root = root.right;
		}
		res = closestValue(root, target);
		if(Math.abs(target - res) > Math.abs(target-val))
			return val;
		return res;
    }
	
    
    public static void main(String[] args) { 
    }
}
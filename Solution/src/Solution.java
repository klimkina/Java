/*Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/
class Solution {
	public int closestValue(TreeNode root, double target) {
		int val = root.val;
	    TreeNode kid = target < val ? root.left : root.right;
	    if (kid == null) return val;
	    int close = closestValue(kid, target);
	    return Math.abs(val - target) < Math.abs(close - target) ? val : close;
    }
	
    
    public static void main(String[] args) { 
    }
}
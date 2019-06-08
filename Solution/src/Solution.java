import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


class Solution {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public void flatten(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null)
        {
            if (curr.left == null)
                curr = curr.right;
            else
            {
                pre = curr.left;
                
                while (pre.right != null && pre.right != curr)
                    pre = pre.right;
                if (pre.right == null)
                {
                    pre.right = curr;                
                    curr = curr.left;
                }
                else
                {
                    pre.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                    curr = pre.right;
                }
            }
        }
	}
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(5);
		TreeNode left21 = new TreeNode(3);
		TreeNode right21 = new TreeNode(4);
		TreeNode right22 = new TreeNode(6);
		root.right = left1;
		//root.right = right1;
		//right1.right = right22;
		left1.left = left21;
		//left1.right = right21;
		obj.flatten(root);
	}
}

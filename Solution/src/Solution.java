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
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root != null)
            if (root.val == key)
            {
                if (root.left == null)
                    root = root.right;
                else if (root.right == null)
                    root = root.left;
                else
                {
                    TreeNode curr = root.left;
                    if (curr.right == null)
                        root.left = curr.left;
                    else
                    {
                        TreeNode prev = curr;
                        while(curr.right != null)
                        {
                            prev = curr;
                            curr = curr.right;
                        }
                        prev.right = curr.left;
                    }
                    root.val = curr.val;
                }
            }
            else
            {
                root.left = deleteNode(root.left, key);
                root.right = deleteNode(root.right, key);
            }
        return root;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution(new ListNode(0));
		int[] nums = {1,2,3};
		//System.out.println(obj.frequencySort("tree"));
	}
}

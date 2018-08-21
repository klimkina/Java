import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private static int idx = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd || inStart >= inorder.length || idx >= preorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        int newStart = inStart;
        while (inorder[inStart++] != root.val && inStart <= inEnd);
        root.left = buildTree(preorder, inorder, newStart+1, inStart-1);
        root.right = buildTree(preorder, inorder, inStart, inEnd);
        return root;
    }
    
    public static void main(String[] args) 
    {
    	int[] inorder = {1,2,3};
    	int[] preorder = {3,2,1};
    	System.out.println(buildTree(inorder, preorder).val);
    	
    }
}

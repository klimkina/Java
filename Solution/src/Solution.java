import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
		 }
	private static int in_pos, post_pos;
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length)
            return null;
        in_pos = inorder.length - 1;
        post_pos = in_pos;
        TreeNode root = buildTree(inorder, postorder, null);
        return root;
    }
    
    public static TreeNode buildTree(int[] inorder, int[] postorder, Integer val) {
        if (in_pos < 0 || (val != null && inorder[in_pos] == val))
            return null;
        TreeNode root = new TreeNode(postorder[post_pos]); 
        post_pos--;
        root.right = buildTree(inorder, postorder, root.val);
        in_pos--;
        root.left = buildTree(inorder, postorder, val);
        
        return root;
    }
		
    public static void main(String[] args) {
    	int[] inorder = {9,3,15,20,7};
    	int[] postorder = {9,15,7,20,3};
    	
    	System.out.println(buildTree(inorder, postorder).val);
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

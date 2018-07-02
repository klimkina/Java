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
	private static int min = Integer.MIN_VALUE;
	private static int min_level = 0;
	public static int findBottomLeftValue(TreeNode root) {
		min = root.val;
		findBottomLeftValue(root, 0);
	    return min;  
    }
		
	public static void findBottomLeftValue(TreeNode root, int level) {
		if(root.left == null && root.right == null)
		{
			if(level > min_level)
				min = root.val;
		}
	   if(root.left != null)
		   findBottomLeftValue(root.left, level + 1);
	   if(root.right != null)
		   findBottomLeftValue(root.left, level + 1);
    }
	
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	TreeNode node = new TreeNode(1);
    	root.right = node;
    	System.out.println(findBottomLeftValue(root));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

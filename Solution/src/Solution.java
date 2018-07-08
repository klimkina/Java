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
		
		    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
		        return findCommon(root);
		    }
		    
		    private static TreeNode findCommon(TreeNode root)
		    {
		        if(root == null || (root.left == null && root.right == null))
		            return root;
		        if(root.left == null)
		            return root.right;
		        if(root.right == null)
		            return root.left;
		        int left = subnodesMaxDepth(root.left);
		        int right = subnodesMaxDepth(root.right);
		        if (left == right)
		            return root;
		        if (left > right)
		            return findCommon(root.left);
		        return findCommon(root.right);
		    }
		    
		    private static int subnodesMaxDepth(TreeNode root)
		    {
		        if(root == null)
		            return 0;
		        if(root.left == null && root.right == null)
		            return 1;
		        int max = 0;
		        if(root.left != null)
		            max = Math.max(max, subnodesMaxDepth(root.left));
		        if(root.right != null)
		            max = Math.max(max, subnodesMaxDepth(root.right));
		        return max + 1;
		    }
		
    public static void main(String[] args) {
    	TreeNode node = new TreeNode(0);
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	node.right = node1; node1.right = node2; node2.right = node3;
    	System.out.println(subtreeWithAllDeepest(node).val);
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

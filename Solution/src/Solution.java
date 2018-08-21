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
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode curr = root;
        TreeNode qcurr = root;
        TreeNode res = root;
        ListIterator<TreeNode> pIterator = pPath.listIterator();
        ListIterator<TreeNode> qIterator = qPath.listIterator();
        while (qIterator.hasNext() && pIterator.hasNext())
        {
        	res = curr;
            curr = pIterator.next();
            qcurr = qIterator.next();
            if (curr != qcurr)
            	break;
        }
        return res;
    }
    
    private static List<TreeNode> getPath(TreeNode root, TreeNode p)
    {
        if (root == null)
            return null;
        List<TreeNode> path = null;
        if (root == p)
        {
            path = new ArrayList<>();            
        }        
        else if (root.left != null)
            path = getPath (root.left, p);
        if (path == null && root.right != null)
            path = getPath (root.right, p);
        if (path != null)
        	path.add(0,root);
        return path;
    }
    public static void main(String[] args) 
    {
    	TreeNode root = new TreeNode(6);
    	TreeNode left = new TreeNode(2);
    	TreeNode right = new TreeNode (8);
    	root.left = left; root.right = right;
    	TreeNode rroot = new TreeNode(0);
    	left.left = rroot;
    	rroot = new TreeNode(4);
    	left.right = rroot;
    	TreeNode lleft = new TreeNode(7);
    	TreeNode rright = new TreeNode (9);
    	right.left = left; right.right = rright;
    	lleft = new TreeNode(3);
    	rright = new TreeNode (5);
    	rroot.left = lleft; rroot.right = rright;
    	System.out.println(lowestCommonAncestor(root, left,rroot).val);
    	
    }
}

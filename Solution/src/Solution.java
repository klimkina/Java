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
	
	public static  List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new ArrayList<>();
		if(K < 0)
			return res;
		if(K == 0)
		{
			res.add(target.val);
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		if (!findTarget(target, stack))
			return res;
		boolean isLeft = true;
		TreeNode prev = target;
		stack.push(target);
		while(!stack.isEmpty() && K >= 0)
		{
			TreeNode node = stack.pop();
			if(node != target)
			{
				if(node.left == prev)
					isLeft = false;
				else
					isLeft = true;
			}
			List<Integer> temp = distanceK(node, K, isLeft);
			if(!temp.isEmpty())
				res.addAll(temp);
			if(node == target)
			{
				temp = distanceK(node, K, !isLeft);
				if(!temp.isEmpty())
					res.addAll(temp);
			}
			K--; 
			prev = node;
		}
		return res;
    }
	private static boolean findTarget(TreeNode target, Stack<TreeNode> stack) {
		TreeNode root = stack.pop();
		if(root == null)
			return false;
		if(root == target)
			return true;
		if(root.left != null || root.right != null)
			stack.push(root);
		if(root.left != null)
		{
			stack.push(root.left);
			if (findTarget(target, stack))
				return true;
		}
		if(root.right != null)
		{
			stack.push(root.right);
			if(findTarget(target, stack))
				return true;
			else
				stack.pop();
		}
		return false;
	}
	private static List<Integer> distanceK(TreeNode node, int K, boolean isLeft) {
		
			
		List<Integer> res = new ArrayList<>();
		if(node == null) return res;
		if(K == 0)
		{
			res.add(node.val);
			return res;
		}
		if(isLeft)
			node = node.left;
		else
			node = node.right;
		res = distanceK(node, K - 1);
		return res;
	}
	private static List<Integer> distanceK(TreeNode node, int K) {		
		
		List<Integer> res = new ArrayList<>();
		if(node == null) return res;
		if(K == 0)
		{
			res.add(node.val);
			return res;
		}
		
		res.addAll(distanceK(node.left, K - 1));
		res.addAll(distanceK(node.right, K - 1));
		return res;
	}
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(3);
    	TreeNode root2 = root;
    	TreeNode left = new TreeNode(5);
    	TreeNode target = left;
    	TreeNode right = new TreeNode(1);
    	root.left = left; root.right = right;
    	root = new TreeNode(6);
    	left.left = root;
    	root = new TreeNode(2);
    	left.right = root;
    	left = left.right;
    	root = new TreeNode(7);
    	left.left = root;
    	root = new TreeNode(4);
    	left.right = root;
    	root = right;
    	left = new TreeNode(0);
    	right = new TreeNode(8);
    	root.left = left; root.right = right;
    	List<Integer> res = distanceK(root2, target, 2);
    	for(int i : res)
    		System.out.print(i + " ");
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

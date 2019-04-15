import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



class Solution {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
		 
		
	    public static TreeNode recoverFromPreorder(String S) {
	    	Stack<TreeNode> stack = new Stack<>();
	    	int pos = 0;
	    	int n = S.length();
	    	while (pos < n)
	    	{
	    		int lev = 0;
	    		while(S.charAt(pos) == '-')
	    		{
	    			pos++;
	    			lev++;
	    		}
	    		while (!stack.isEmpty() && stack.size() > lev)
	    			stack.pop();
	    		StringBuilder sb = new StringBuilder();
	    		while(pos < n && S.charAt(pos) != '-')
	    			sb.append(S.charAt(pos++));
	    		TreeNode node = new TreeNode(Integer.valueOf(sb.toString()));
	    		if (!stack.isEmpty())
	    		{
	    			TreeNode par = stack.peek();
	    			if (par.left == null)
	    				par.left = node;
	    			else
	    				par.right = node;
	    		}
	    		stack.push(node);
	    	}
	    	TreeNode res = stack.pop();
	    	while(!stack.isEmpty())
	    		res = stack.pop();
	        return res;
	    }
	
	
	public static void main(final String[] args) {
		System.out.print(recoverFromPreorder("1-2--3---4-5--6---7"));
	}
}

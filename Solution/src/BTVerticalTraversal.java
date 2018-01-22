import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
*/
public class BTVerticalTraversal {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		      public TreeNode insertLeft(int x) {
		    	  left = new TreeNode(x);
		    	  return left;
		      }
		      public TreeNode insertRight(int x) {
		    	  right = new TreeNode(x);
		    	  return right;
		      }
	}
	
	private int min = 0, max = 0;
	public List<List<Integer>> verticalOrder(TreeNode root) {
	    List<List<Integer>> list = new ArrayList<>();
	    if(root == null)    return list;
	    computeRange(root, 0);
	    for(int i = min; i <= max; i++) 
	    	list.add(new ArrayList<>());
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> idx = new LinkedList<>();
	    idx.add(-min);
	    q.add(root);
	    while(!q.isEmpty()){
	        TreeNode node = q.poll();
	        int i = idx.poll();
	        list.get(i).add(node.val);
	        if(node.left != null){
	            q.add(node.left);
	            idx.add(i - 1);
	        }
	        if(node.right != null){
	            q.add(node.right);
	            idx.add(i + 1);
	        }
	    }
	    return list;
	}
	private void computeRange(TreeNode root, int idx){
	    if(root == null)    return;
	    min = Math.min(min, idx);
	    max = Math.max(max, idx);
	    computeRange(root.left, idx - 1);
	    computeRange(root.right, idx + 1);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode left = root.insertLeft(9);
		left.insertLeft(4);
		left.insertRight(0);
		TreeNode right = root.insertRight(8);
		right.insertLeft(1);
		right = right.insertRight(7);
		right.insertLeft(2);
		right.insertRight(5);
		BTVerticalTraversal obj = new BTVerticalTraversal();
		List<List<Integer>> res = obj.verticalOrder(root);
		for(List<Integer> list : res) {
			for(Integer i:list)
				System.out.print(i + " ");
			System.out.println();
		}
	}

}

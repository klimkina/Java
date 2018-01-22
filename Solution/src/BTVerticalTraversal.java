import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
    public List<List<Integer>> verticalOrder(TreeNode root) {
    	TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        calcOrder(root, 0, map);
        List<List<Integer>> res = new ArrayList<>();
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        	res.add(entry.getValue());
        return res;
    }
    private void calcOrder(TreeNode root, int curr, TreeMap<Integer, List<Integer>> map){
        if(root == null)
            return;
        if(map.get(curr) == null)
        	map.put(curr, new ArrayList<Integer>());
        map.get(curr).add(root.val);
        calcOrder(root.left, curr-1, map);
        calcOrder(root.right, curr+1, map);
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

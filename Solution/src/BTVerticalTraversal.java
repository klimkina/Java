import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	private static class NodeOrder implements Comparable<NodeOrder>{
        int val;
        int order;
        public NodeOrder(int v, int o){
            val = v;
            order = o;
        }
        @Override
        public int compareTo(NodeOrder that){
            return this.order - that.order;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<NodeOrder> res = new ArrayList<>();
        calcOrder(root, 0, res);
        Collections.sort(res);
        List<List<Integer>> sorted = new ArrayList<>();
        List<Integer> temp = null;
        int last = 0;
        for(int i = 0; i < res.size(); i++){
            if(temp == null || last != res.get(i).order) {
                if(temp != null)
                    sorted.add(temp);
                temp = new ArrayList<>();
            }
            temp.add(res.get(i).val);
            last = res.get(i).order;
        }
        if(temp != null)
        	sorted.add(temp);
        return sorted;
    }
    private void calcOrder(TreeNode root, int curr, List<NodeOrder> res){
        if(root == null)
            return;
        res.add(new NodeOrder(root.val, curr));
        calcOrder(root.left, curr-1, res);
        calcOrder(root.right, curr+1, res);
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

import Solution.TreeNode;

public class MorrisTraversal {
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
		 }
	public void inOrder(TreeNode root) {
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) { //visit 
				System.out.println(curr.val);
				curr = curr.right;
			}
			TreeNode predecessor = curr;
			curr = curr.left;
			while(curr.right != null && curr.right != predecessor)
				curr = curr.right;
			if(curr.right == null) {
				curr.right = predecessor;
				curr = predecessor.left;
			} else { //visit root
				curr.right = null;
				System.out.println(predecessor.val);
				curr = predecessor.right;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

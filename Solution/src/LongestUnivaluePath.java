import java.io.FileNotFoundException;

public class LongestUnivaluePath {
	
	public int longestUnivaluePath(Tree.TreeNode root) {
		if(root == null)
			return 0;
		int left_path = 0;
		int right_path = 0;
		int left_same = 0;
		int right_same = 0;
		int res = 0;
		if(root.left != null) {
			left_path = longestUnivaluePath(root.left);
			if(root.left.val == root.val)
				left_same = longestUnivaluePath(root.left, root.val);
		}
		if(root.right != null) {
			right_path = longestUnivaluePath(root.right);
			if(root.right.val == root.val)
				right_same = longestUnivaluePath(root.right, root.val);
		}
		res = left_same + right_same;
        return Math.max(res, Math.max(left_path, right_path));
    }
	private int longestUnivaluePath(Tree.TreeNode root, int val) {		
		if(root.val == val) {
			int left = 0;
			int right = 0;
			if(root.left != null)
				left = longestUnivaluePath(root.left, val);
			if(root.right != null)
				right = longestUnivaluePath(root.right, val);
			return Math.max(left, right) + 1;
		}
		return 0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestUnivaluePath obj = new LongestUnivaluePath();
		Tree tree = new Tree();
		try {
			tree.readFile("mytree.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		System.out.println(obj.longestUnivaluePath(tree.getRoot()));
	}

}

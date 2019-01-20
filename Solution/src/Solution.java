import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
	private int balance = 0;
    public int distributeCoins(TreeNode root) {
        if (root == null)
            return 0;
        distribute(root);
        return balance;
    }
    private int distribute(TreeNode root)
    {
        if (root == null)
            return 0;
        int res = distribute(root.left) + distribute(root.right) + root.val - 1;
        balance += Math.abs(res);
        return res;
    }
	
	public static void main(final String[] args) {
		int[] A = {2,0,2,4,2,5,0,1,2,3};
	}
}

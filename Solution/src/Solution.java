import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private  static class Node
	{
		int val;
		Node left;
		Node right;
		public Node (int v)
		{
			val = v;
			left = null;
			right = null;
		}
		public  Node addLeft (int v)
		{
			left = new Node (v);
			return left;
		}
		public Node addRight (int v)
		{
			right = new Node (v);
			return right;
		}
	}
	
	public boolean isSearch(Node root) {
		return isSearch(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public boolean isSearch(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.val < min || root.val > max)
			return false;
		return isSearch(root.left, min, root.val) && isSearch(root.right, root.val, max);
    }
	

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextInt();
            }
        }*/
    	Node tree = new Node(5);
    	Node left = tree.addLeft(2);
    	Node right = tree.addRight(7);
    	left.addLeft(1);
    	left.addRight(3);
    	right.addLeft(6);
    	right.addRight(8);
    	Solution obj =  new Solution();
    	System.out.println(obj.isSearch(tree));
    }
}

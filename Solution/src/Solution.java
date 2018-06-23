import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static class Node
	{
		public int val;
		Node left;
		Node right;
		Node (int val)
		{
			this.val = val;
			left = null;
			right  = null;
		}
		public Node insert(int val, boolean isLeft)
		{
			Node node = new Node (val);
			if (isLeft)
				left = node;
			else
				right = node;
			return node;
		}
		public boolean isSearchTree()
		{
			return isSearchTree(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		public boolean isSearchTree(Node node, int left, int right)
		{
			if(node == null)
				return true;
			if(node.val > right || node.val < left)
				return false;
			return isSearchTree (node.left, left, node.val) && isSearchTree(node.right, node.val, right);
		}
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
    	int[] input = {9, 29,10, 2, 50, 24, 100};
    	Node node = new Node(5);
    	Node left = node.insert(3, true);
    	Node right = node.insert(7, false);
    	left.insert(4, false);
    	right.insert(6, true);
    	System.out.println(node.isSearchTree());
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Given a binary tree where every node has a unique value, and a target key k, find the closest leaf node to target k in the tree.

A node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
 */


public class ClosestLeaf {
	int distance = Integer.MAX_VALUE;
    int value = -1;
    
	public int findClosestLeaf(Tree.TreeNode root, int k) {
		distance = Integer.MAX_VALUE;
        value = -1;
        find(root, -1, k);
        return value;
			
    }
	private int find(Tree.TreeNode root, int knownDistance, int target) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            if (root.left == null && root.right == null) {
                distance = 0;
                value = target;
            } else {
                find(root.left, 1, target);
                find(root.right, 1, target);
            }
            return 1;
        } else if (knownDistance != -1) {
            if (root.left == null && root.right == null) {
                if (distance > knownDistance) {
                    distance = knownDistance;
                    value = root.val;
                }
            } else {
                find(root.left, knownDistance + 1, target);
                find(root.right, knownDistance + 1, target);
            }
            return -1;
        } else {
            int left = find(root.left, -1, target);
            int right = find(root.right, -1, target);
            if (left != -1 || right != -1) {
                int dis = Math.max(left, right);
                if (left == -1) {
                    find(root.left, dis + 1, target);
                }
                if (right == -1) {
                    find(root.right, dis + 1, target);
                }
                return dis + 1;
            } else {
                return -1;
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestLeaf sol = new ClosestLeaf();
		Tree tree = new Tree();
		Tree.TreeNode root = tree.init("1,2,3,4,,,,5,,6");
		int k = 2;
		int res = sol.findClosestLeaf(root, k);
		System.out.println(res);
	}

}

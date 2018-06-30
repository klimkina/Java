import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        int maxPos = maxPos(nums, start, end);
        TreeNode node = new TreeNode (nums[maxPos]);
        if(maxPos > start)
            node.left = constructMaximumBinaryTree(nums, start, maxPos);
        if(maxPos < end)
            node.right = constructMaximumBinaryTree(nums, maxPos, end);
        return node;
    }
    
    private static int maxPos(int[] nums, int start, int end)
    {
        if(start >= end) return start;
        int maxPos = start;
        for(int i = start + 1; i <= end; i++)
            if(nums[i] > nums[maxPos])
                maxPos = i;
        return maxPos;
    }
	
    public static void main(String[] args) {
    	int[] Input = {3,2,1,6,0,5};
    	System.out.print(constructMaximumBinaryTree(Input).val);
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

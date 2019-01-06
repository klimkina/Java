import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        int flips = flipMatchVoyage(root, voyage, 0, res);
        if(flips < 0)
        {
            res.clear();
            res.add(-1);
        }
        return res;
    }
    private int flipMatchVoyage(TreeNode root, int[] voyage, int start, List<Integer> res) {
        
        if (root == null)
            return start;
        if(start >= voyage.length)
            return - 1;
        if (voyage[start] != root.val)
            return -1;
        start++;
        if(root.left == null)
            return flipMatchVoyage(root.right, voyage, start, res);
        if(root.left.val != voyage[start])
        {
            res.add(root.val);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        int flip = flipMatchVoyage(root.left, voyage, start, res);
        if (flip < 0)
            return flip;
        return flipMatchVoyage(root.right, voyage, flip, res);
    }
	
    public static void main(String[] args) 
    {
    	List<Integer> res = powerfulIntegers(2,3,10);
    	for(Integer s : res)
    			System.out.print(s + " ");
    }
}

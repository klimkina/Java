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
		 
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < size; i++){
                if(q.peek().left != null){ q.add(q.peek().left);}
                if(q.peek().right != null){ q.add(q.peek().right);}
                if(list.size() % 2 == 1) 
                    tmp.add(0, q.remove().val);
                else 
                    tmp.add(q.remove().val);
            }
            list.add(tmp);
        }
        return list;
    }
	
	
    public static void main(String[] args) {
    	
    	//System.out.println(search(nums, target));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

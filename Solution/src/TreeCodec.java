import java.util.LinkedList;
import java.util.Queue;

public class TreeCodec {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	if (root != null)
    	{
    		Queue<TreeNode> q = new LinkedList<>();
    		q.offer(root);
    		int nulls = 0;
    		while (!q.isEmpty() && nulls < q.size())
    		{
    			int len = q.size();
    			nulls = 0;
    			for (int i = 0; i < len; i++)
    			{
    				TreeNode node = q.poll();
    				if (node != null)
    				{
    					sb.append(node.val);
    					q.offer(node.left);
    					q.offer(node.right);
    					if (node.left == null)
    						nulls++;
    					if (node.right == null)
    						nulls++;
    				}
    				if (!q.isEmpty() && nulls < q.size())
    					sb.append(",");
    			}
    		}
    	}
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	TreeNode root = null;
    	if (!data.isEmpty())
    	{
    		String[] nodes = data.split(",");
    		int val = Integer.valueOf(nodes[0]);
    		root = new TreeNode(val);
    		Queue<TreeNode> q = new LinkedList<>();
    		q.offer(root);
    		boolean isLeft = true;
    		TreeNode node = null;
    		for(int i = 1; i < nodes.length; i++)
    		{
    			if (isLeft)
    				node = q.poll();
    			if (!nodes[i].isEmpty())
    			{
    				TreeNode temp = new TreeNode(Integer.valueOf(nodes[i]));
    				q.offer(temp);
    				if (isLeft)
    					node.left = temp;
    				else
    					node.right = temp;
    			}
    			
    			isLeft = !isLeft;
    		}
    	}
        return root;
    }
	
	public static void main(String[] args) 
	{
		TreeNode root = new TreeNode(6);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		TreeNode lleft = new TreeNode(3);
		TreeNode lright = new TreeNode(5);
		TreeNode rleft = new TreeNode(7);
		TreeNode rright = new TreeNode(9);
		root.left = left; root.right = right;
		left.left = lleft; left.right = lright;
		right.left= rleft; right.right = rright;
		String s = serialize(root);
		System.out.println(s);
		root = deserialize(s);
	}

}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;;

public class Node {
	private TreeNode root;
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	public TreeNode getRoot() {
		return root;
	}
	public TreeNode insert(TreeNode node, int val, boolean toLeft) {
		TreeNode to = new TreeNode(val);
		if (node != null) {
			if(toLeft)
				node.left = to;
			else
				node.right = to;
		}
		else
			root = to;
		return to;	
	}
	public TreeNode init(String tree) {
		Queue<TreeNode> nodesQueue = new LinkedList<>();
        boolean toLeft = false;
        boolean first = true;
        
        String[] strs = tree.split(",");
        for(String str:strs){
            if(!str.isEmpty() && !str.equals("")) {
            	int val = Integer.parseInt(str);
            	TreeNode node;
            	if(nodesQueue.isEmpty())
            		node = this.insert(null, val, toLeft);
            	else
            		node = this.insert(nodesQueue.peek(), val, toLeft);
            	nodesQueue.add(node);
            }    
            if(!toLeft) {
            	if(!first)
            		nodesQueue.remove();
            	else
            		first = false;
            }
            toLeft = !toLeft;
        }
        return root;
	}
	public Node readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(",");
        
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        boolean toLeft = false;
        
        while(scanner.hasNext()){
            String str = scanner.next().trim();
            if(!str.isEmpty() && !str.equals("null")) {
            	int val = Integer.parseInt(str);
            	TreeNode node;
            	if(nodesQueue.isEmpty())
            		node = this.insert(null, val, toLeft);
            	else
            	{
            		node = this.insert(nodesQueue.peek(), val, toLeft);
            		if(!toLeft)
            			nodesQueue.remove();
            	}
            	nodesQueue.add(node);
            }            
            toLeft = !toLeft;
        }
        scanner.close();
        return this;
	}
	
	public void writeFile(String fileName) throws IOException{
		Writer wr = new FileWriter(fileName);
		LinkedList<TreeNode> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);
		while(!nodesQueue.isEmpty()) {
			TreeNode node = nodesQueue.remove();
			String last = isLast(nodesQueue) && (node == null || (node.left == null && node.right == null)) ? "" : ",";
			if(node == null)
				wr.write(" " + last);
			else {
				nodesQueue.add(node.left);
				nodesQueue.add(node.right);
				wr.write(String.valueOf(node.val) + last);
			}			
		}
		wr.flush();
		wr.close();
	}
	private boolean isLast(LinkedList<TreeNode> nodesQueue) {
		if(!nodesQueue.isEmpty())
			for (TreeNode node : nodesQueue) {
				if (node != null)
					return false;
			}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tree = new Node();
		try {
			tree.readFile("mytree.txt");
			tree.writeFile("newtree.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

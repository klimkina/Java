// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED


public class Amazon2
{
	private Node root = null;
	private int size = 0;
	  
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public int bstDistance(int[] values, int n, 
                                int node1, int node2)
  {
    // WRITE YOUR CODE HERE
	  int res = 0;
	  size = n;
	  root = new Node (values[0]);
	  for(int i = 1; i < size; i++) {
		  root.insert(root, values[i]);
	  }
	  res = dist(node1, node2);
	  return res;
  }
  //METHOD SIGNATURE ENDS
  
  private static class Node {
      private int data;      // the point
      private Node left = null;        // the left/bottom subtree
      private Node right = null;        // the right/top subtree
  
	  private Node (int data){
		  this.data = data;
	  }
	  private Node insert(Node node, int data) { 
		  // 1. If the tree is empty, return a new, single node 
		  if (node == null) { 
		    return(new Node(data)); 
		  } 
		  else { 
		    // 2. Otherwise, recur down the tree 
		    if (data <= node.data) node.left = insert(node.left, data); 
		    else node.right = insert(node.right, data);
	
		    return(node); // return the (unchanged) node pointer 
		  } 
		} 
	  
  }
  private Node findCommon(Node node, int data1, int data2) {
	  if (node == null)
		  return null;
	  if (node.data == data1 || node.data == data2)
		  return node;
	  Node left = findCommon(node.left, data1, data2);
	  Node right = findCommon(node.right, data1, data2);
	  if (left != null && right != null)
		  return node;
	  if (left != null)
		  return left;
	  if(right != null)
		  return right;
	  return null;
  }
  private int dist(Node node, int data) {
	  int dist = 0;
	  while(node != null && node.data != data) {
		  if(data < node.data) node = node.left;
		  else node = node.right;
		  dist++;
	  }
	  if (node == null)
		  return -1;
	  return dist;
  }
  private int dist(int data1, int data2) {
	  Node node1 = findCommon(root, data1, data2);
	  Node node2 = node1;
	  int dist1 = dist(node1, data1);
	  
	  if (dist1 == -1)
		  return -1;
	  int dist2 = dist(node2, data2);
	  
	  if (dist2 == -1)
		  return -1;
	  return dist1 + dist2;
	  
  }
  public static void main(final String[] args) {
		int[] nodes = {4,2,1,3,5,6,7};
		int num = 7;
		int node1 = 8;
		int node2 = 3;
		Amazon2 sol = new Amazon2();
		int res = sol.bstDistance(nodes, num, node1, node2);
		System.out.println(res);
	}
  
}
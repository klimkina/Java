import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



class Solution {
	private static class Node {
        private Node[] next = new Node[2];
    }
    private static void add(Node root, char[] charr, int start)
    {
        Node node = root;
        for (int i = start; i < charr.length; i++)
        {
            if (node.next[charr[i]-'0'] == null)
                node.next[charr[i]-'0'] = new Node();
            node = node.next[charr[i]-'0'];
        }
    }
    private static boolean contains(Node root, char[] charr)
    {
        Node node = root;
        for (int i = 0; i < charr.length; i++)
        {
            if (node.next[charr[i]-'0'] == null)
                return false;
            node = node.next[charr[i]-'0'];
        }
        return true;
    }
    public static boolean queryString(String S, int N) {
        Node root = new Node();
        char[] charr = S.toCharArray();
        for (int i = 0; i < charr.length; i++)
            add(root, charr, i);
        for (int i = 1; i <=N; i++)
        {
            char[] num = Integer.toBinaryString(i).toCharArray();
            if (!contains(root, num))
                return false;
        }
        return true;
    }
	
	public static void main(final String[] args) {
		int[] A = {18,12,-18,18,-19,-1,10,10};
		System.out.print(queryString("110101011011000011011111000000", 15));
	}
}

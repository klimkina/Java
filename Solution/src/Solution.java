import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;


class Solution {
	HashMap<Integer, Integer> map = new HashMap<>();
    public int minHeightShelves(int[][] books, int shelf_width) {
        return minHeightShelves(books, shelf_width, 0);
    }
    private int minHeightShelves(int[][] books, int shelf_width, int pos) {
        if (pos >= books.length)
            return 0;
        if (map.containsKey(pos))
            return map.get(pos);
        int currW = 0;
        int maxH = 0;
        int minTotalH = Integer.MAX_VALUE;
        int i = pos;
        while (i < books.length && currW + books[i][0] <= shelf_width)
        {
            currW = currW + books[i][0];
            maxH = Math.max(maxH, books[i][1]);
            minTotalH = Math.min(minTotalH, maxH + minHeightShelves(books, shelf_width, i+1));
            i++;
        }
        map.put(pos, minTotalH);
        return minTotalH;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] books = {{9,9},{5,4},{3,1},{1,5},{7,3}};
		System.out.println(obj.minHeightShelves(books, 10));
	}
}

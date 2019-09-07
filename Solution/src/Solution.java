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

// Consider a matrix M with dimensions width * height, such that every cell has value 0 or 1, and any square sub-matrix of M of size sideLength * sideLength has at most maxOnes ones.

// Return the maximum possible number of ones that the matrix M can have.
class Solution {
	class Point implements Comparable<Point>
    {
        int x;
        int y;
        int count;
        public Point(int x, int y, int width, int height, int sideLength)
        {
            this.x = x;
            this.y = y;
            count = (width/sideLength)*(height/sideLength) + (x < width% sideLength ? 1 : 0)*(height/sideLength) +
                (y < height % sideLength ? 1 : 0)*(width/sideLength) + (x < width% sideLength &&  y < height % sideLength ? 1 : 0);
        }
        @Override
        public int compareTo(Point other)
        {
            return - this.count + other.count;
        }
    }
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int x = 0; x < sideLength; x++)
            for (int y = 0; y < sideLength; y++)
                pq.offer(new Point(x, y, width, height, sideLength));
        int res = 0;
        for (int i = 0; i < maxOnes; i++)
        {
            Point p = pq.poll();
            res += p.count;
        }
        return res;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		String[] queries = {"bbb","cc"};
		String[] words = {"a","aa","aaa","aaaa", "bb"};
		System.out.println(obj.numSmallerByFrequency(queries, words));
	}
}

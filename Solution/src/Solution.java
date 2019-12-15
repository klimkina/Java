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

/*
Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.
 */
class Solution {
	public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        if (m == 0)
            return 0;
        int n = mat[0].length;
        int[][] sums = new int[m+1][n+1];
        for(int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                sums[i+1][j+1] = sums[i+1][j] + sums[i][j+1] - sums[i][j] + mat[i][j];
        
        for(int k = Math.min(m, n); k > 0; k--) {
            for(int i = 1; i+k <= m; i++) {
                for(int j = 1; j+k <= n; j++) {
                    if(sums[i+k][j+k] - sums[i-1][j+k] - sums[i+k][j-1] + sums[i-1][j-1] <= threshold) {
                        return k+1;
                    }
                }
            }
        }
        return 0;
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
		System.out.println(obj.maxSideLength(mat, 4));
	}
}

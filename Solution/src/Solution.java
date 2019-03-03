import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
	
	public static int longestOnes(int[] A, int K) {
		int start = 0;
        int max = 0;
        if (A.length > 0) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 0)
                    K--;
                
                while (K < 0)
                    if (A[start++] == 0)
                        K++;
                max = Math.max(max, i - start + 1); 
            }
        }
        return max;
    }
	
	public static void main(final String[] args) {
		int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		System.out.println(longestOnes(A, 3));
	}
}

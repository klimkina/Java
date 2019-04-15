import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



class Solution {
	public static int longestArithSeqLength(int[] A) {
		int res = 0;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for(int i = 0; i < A.length; i++){
            dp[i] = new HashMap<>();
        }
        for(int i = A.length-1; i >= 0; i--){
            for(int j = i+1; j < A.length; j++){
                int diff = A[i] - A[j];
                int len = dp[j].containsKey(diff)? dp[j].get(diff)+1: 2;
                dp[i].put(diff, Math.max(len, dp[i].getOrDefault(diff, 0)));
                res = Math.max(res, len);
            }
        }
        return res;
        
    }
	
	
	public static void main(final String[] args) {
		int[] A = {3,6,9,12};
		System.out.print(longestArithSeqLength(A));
	}
}

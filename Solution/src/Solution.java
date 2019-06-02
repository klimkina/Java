import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return 0;
        
        int n = matrix.length, m = matrix[0].length;
        int[][] cum = new int[n+1][m+1];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                cum[i+1][j+1] = cum[i+1][j] + cum[i][j+1] - cum[i][j] + matrix[i][j];
            }
        }

        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                Map<Integer, Integer> map = new HashMap<>();
                for(int k = 0;k <= m;k++){
                    int v = cum[j+1][k] - cum[i][k];
                    if(map.containsKey(v - target)){
                        ans += map.get(v-target);
                    }
                    map.put(v, map.getOrDefault(v, 0)+1);
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] nums1 = {{0,1,0},{1,1,1},{0,1,0}};
		System.out.println(obj.numSubmatrixSumTarget(nums1, 0));
	}
}

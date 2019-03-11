import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
	
	public static int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for(int i = 0; i < M.length; i++)
            for(int j = 0; j < M[0].length; j++)
                res[i][j] = calc(M, i, j);
        return res;
        
    }
    private static int calc(int[][] M, int i, int j)
    {
        int[] dx = {-1,0,1};
        int[] dy = {-1,0,1};
        int sum = 0;
        int num = 0;
        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++)
            {
                int new_x = i + dx[x];
                int new_y = j + dy[y];
                if (inBound(M, new_x, new_y))
                {
                    sum += M[new_x][new_y];
                    num++;
                }
            }
        return sum/(num);
    }
    
    private static boolean inBound(int[][]M, int i, int j)
    {
        return i >= 0 && j >= 0 && i < M.length && j < M[0].length;
    }
	
	public static void main(final String[] args) {
		int[][] M = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
		int[][] N = imageSmoother(M);
		for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++)
            	System.out.print(N[i][j]);
            System.out.println();
		}
	}
}

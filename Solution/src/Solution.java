import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



class Solution {
	
	private static boolean enclosed = true;
    public static int numEnclaves(int[][] A) {
        int n = A.length;
        if (n == 0)
            return 0;
        int m = A[0].length;
        int[][] visited = new int[n][m];
        int counter = 0;
        for (int i = 0 ; i < n; i++)
            for (int j = 0; j < m; j++)
                if (A[i][j] == 1 && visited[i][j] == 0)
                {
                    enclosed = true;
                    int t = dfs(A, visited, i, j);
                    if (enclosed)
                        counter += t;
                }
        return counter;
    }
    private static int dfs(int[][] A, int[][] visited, int i, int j)
    {
        int[] dx = {-1,0, 1,0};
        int[] dy = {0, -1, 0, 1};
        int count = 1;
        visited[i][j] = 1;
        for (int k = 0; k < 4; k++)
        {
            int new_x = i + dx[k];
            int new_y = j + dy[k];
            if (new_x < 0 || new_y < 0 || new_x >= A.length || new_y >= A[0].length)
                enclosed = false;
            else if (A[new_x][new_y] == 1 && visited[new_x][new_y] == 0)
                count += dfs(A, visited, new_x, new_y);
        }
        return count;
    }
	
	public static void main(final String[] args) {
		int[][] arr = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		System.out.print(numEnclaves(arr));
	}
}

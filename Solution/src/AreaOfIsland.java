import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class AreaOfIsland {
	
	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		if(grid.length == 0)
			return 0;
		int[][] visited = fillZeroes(grid.length, grid[0].length);
		for(int i =0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++)
				if(grid[i][j] == 1)
					max = Math.max(max, findNeighbours(grid, i, j, visited));
		}
        return max;
    }
	private int[][] fillZeroes(int i, int j) {
		int[][] visited = new int[i][j];
		for(int k = 0; k < visited.length; k++)
			Arrays.fill(visited[k], 0);
		return visited;
	}
	
	private int findNeighbours(int[][] grid, int i, int j, int[][] visited) {
		int dx[] = {0, 0, -1, 1};
		int dy[] = {-1, 1, 0, 0};
		
		visited[i][j] = 1;
		int res = 1;
		
		for(int k = 0; k < 4; k++) {
			int new_x = i + dx[k];
			int new_y = j + dy[k];
			if (new_x >= 0 && new_x < grid.length
					&& new_y >= 0 && new_y < grid[0].length 
					&& grid[new_x][new_y] == 1
					&& visited[new_x][new_y] == 0) 
				res += findNeighbours(grid, new_x, new_y, visited);
			
		}		  
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,0,0,0,0,0,0,0}};
		AreaOfIsland obj = new AreaOfIsland();
		System.out.println(obj.maxAreaOfIsland(grid));

	}

}

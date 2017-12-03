
public class CherryPickup {
	boolean isFinished = false;
	public int cherryPickup(int[][] grid) {
		int res = 0;
		if(grid.length > 0) {
			res = dfs(grid, 0, 0) + dfs(grid, 0, 0);
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[0].length; j++)
					System.out.print(grid[i][j] + " ");
				System.out.println();
			}
		}
        return res;
    }
	private int dfs(int[][] grid, int i, int j) {
		
		if(i == grid.length - 1 && j == grid[0].length - 1) {
			isFinished = true;
			return grid[i][j];
		}
		if(grid[i][j] == -1)
			return 0;
		int dfs_right = 0;
		int dfs_down = 0;
		if(i < grid.length - 1)
			dfs_down = dfs(grid, i+1, j);
		if(j < grid[0].length - 1)
			dfs_right = dfs(grid, i, j+1);
		if(dfs_down >= dfs_right && i < grid.length - 1)
			grid[i+1][j] = 0;
		else
			grid[i][j+1] = 0;
		return grid[i][j] + Math.max(dfs_down, dfs_right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]grid =
				{{0, 1, 1},
				 {1, 0, 1},
				 {1, 1,  1}};
		CherryPickup sol = new CherryPickup();
		System.out.println(sol.cherryPickup(grid));
		
	}

}

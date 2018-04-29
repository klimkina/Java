import java.util.Arrays;

public class SwimInWater {
	private int gridSize;
	private int[] union_grid;
	int[][] grid;
	public int swimInWater(int[][] grid) {
		gridSize = grid.length;
		union_grid = new int[gridSize*gridSize];
		this.grid = new int[gridSize][];
		for(int i = 0; i < gridSize; i++) {
			this.grid[i] = Arrays.copyOf(grid[i], gridSize);
			for(int j = 0; j < gridSize; j++) 
				union_grid[calcIndex(i, j)] = grid[i][j];
		}
		int res = 0;
		while(true) {
			if(connected(0, gridSize*gridSize -1))
				return res;
			rain();
			res++;
		}
    }
	private int calcIndex(int row, int col)
    {
        return row * gridSize + col;
    }
	private boolean checkBoundaries(int row, int col)
    {
        if (row >= 0 && col >= 0 && row < gridSize && col < gridSize)
            return true;
        return false;
    }
	private int root(int i)
	 {
		 while (i != union_grid[i]){
			 union_grid[i] = union_grid[union_grid[i]];//path compression
			 i = union_grid[i];
		 }
		 return i;
	 }
	private boolean connected(int p, int q)
	 {
		 return root(p) == root(q);
	 }
	private void rain() {
		for(int i = 0; i < gridSize; i++)
			for(int j = 0; j < gridSize; j++) {
				if(grid[i][j] > 0) {
					grid[i][j]--;
					if(grid[i][j] == 0)
						connect(i, j);
				}
			}
	}
	private void union(int p, int q)
	 {
		 int i = root(p);
		 int j = root(q);
		 
		 if (i == j) return;
		 
		 union_grid[i] = j;
	 }
	private void connect(int row, int col) {
		int currIndex = calcIndex(row, col);
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		for(int i = 0; i < 4; i++) {
			int new_row = row + dr[i];
			int new_col = col + dc[i];
			if(checkBoundaries(new_row, new_col) && grid[new_row][new_col] == 0)
				union(currIndex, calcIndex(new_row, new_col));        
	       
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
		SwimInWater obj =  new SwimInWater();
        int result = obj.swimInWater(grid);
        System.out.println(result);
	}

}

import java.util.Arrays;

public class CandyCrush {
	private int[][] board;
	private int[][] visited;
	private boolean crushed;
	public int[][] candyCrush(int[][] board) {
		if(board.length < 1)
			return null;
		init(board);
		
		do {
			crush();
		}
		while (crushed);
			
		return this.board;
    }
	private void printBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(String.format("%1$" + 5 + "s", board[i][j]) + " ");
			}
			System.out.println();
		}
	}
	private void crush() {
		crushed = false;
		initVisited();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				int to_right = 0;
				if(j == 0 || board[i][j] != board[i][j-1])
					to_right = findHorizontalNeighbours(i, j);
				int down = 0;
				if(i == 0 || board[i-1][j] != board[i][j])
					down = findVerticalNeighbours(i, j); 
				
				if(to_right > 2) {
					for(int k = j; k < j + to_right; k++)
						visited[i][k] = 0;
					crushed = true;
				}
				if(down > 2) {
					for(int k = i; k < i + down; k++)
						visited[k][j] = 0;
					crushed = true;
				}
			}
		}
		if(crushed) {
			setZeroes();
			collapse();
		}
	}
	
	private void collapse() {
		for(int i = board.length - 1; i > 0; i--) 
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0) {
					int k = i - 1;
					while(k > 0 && board[k][j] == 0)
						k--;
					for(int l = 0; l <= k; l++)
						board[i-l][j] = board[k-l][j];
					for(int l = i - k - 1; l >= 0; l--)
						board[l][j] = 0;
				}
			}
	}
	private void setZeroes() {
		for(int i = 0; i < board.length; i++) 
			for(int j = 0; j < board[0].length; j++) 
				if(visited[i][j] == 0)
					board[i][j] = 0;
			
	}
	private int findHorizontalNeighbours(int i, int j) {
		if(board[i][j] == 0)
			return 0;
		int res = 1;
		
		//go right
		for(int k = j+1; k < board[0].length; k++) {
			if (board[i][k] == board[i][j]) 
				res++;
			else 
				break;
		}		
		return res;
	}
	private int findVerticalNeighbours(int i, int j) {
		if(board[i][j] == 0)
			return 0;
		int res = 1;
		
		//go down
		for(int k = i+1; k < board.length; k++) {
			if (board[k][j] == board[i][j]) 
				res++;
			else
				break;
		}		  
		return res;
	}
	private void init(int[][] board) {
		this.board = new int[board.length][];
		this.visited = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) 
			this.board[i] = board[i].clone();
		initVisited();
	}

	private void initVisited() {
		for(int i = 0; i < board.length; i++) {
		    Arrays.fill(visited[i], 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = 
				{{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
		int[][] res_board = 
				{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{110,0,0,0,114},{210,0,0,0,214},{310,0,0,113,314},{410,0,0,213,414},{610,211,112,313,614},{710,311,412,613,714},{810,411,512,713,1014}};
		CandyCrush obj = new CandyCrush();
		int[][] my_res = obj.candyCrush(board);
		for(int i = 0; i < my_res.length; i++) {
			for(int j = 0; j < my_res[0].length; j++) {
				if(my_res[i][j] != res_board[i][j])
					System.out.print((char)31 + String.format("%1$" + 5 + "s", my_res[i][j]) + " ");
				else
					System.out.print(String.format("%1$" + 5 + "s", my_res[i][j]) + " ");
			}
			System.out.println();
		}
	}

}

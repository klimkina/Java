
public class TicTacToeBoard {
	char[][] boardValues;
	public TicTacToeBoard() {
		boardValues = new char[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				boardValues[i][j] = '-';
	}
	public void addToken(int x, int y, boolean isX) {
		boardValues[x][y] = isX ? 'X' : 'O';
	}
	public void print() {
		for(int i = 0; i < 3; i++) 
			for(int j = 0; j < 3; j++) {
				System.out.print(boardValues[i][j]);
				System.out.print(j == 2 ? System.lineSeparator() : '|');
			}
		
	}
	public boolean isFull() {
		for(int i = 0; i < 3; i++) 
			for(int j = 0; j < 3; j++) 
				if(boardValues[i][j] == '-')
					return false;
		return true;
	}
	public boolean isEmpty(int x, int y) {
		return (boardValues[x][y] == '-');
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToeBoard board = new TicTacToeBoard();
		board.print();
		board.addToken(0, 1, true);
		board.print();
		Solution s = new Solution();
		for(int i = 0; i < 9; i++)
			s.makeMove(board);
		board.print();
	}

}


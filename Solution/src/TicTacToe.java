/*Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.*/
public class TicTacToe {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
	    rows = new int[n];
	    cols = new int[n];
	}

	/** Player {player} makes a move at ({row}, {col}).
	    @param row The row of the board.
	    @param col The column of the board.
	    @param player The player, can be either 1 or 2.
	    @return The current winning condition, can be either:
	            0: No one wins.
	            1: Player 1 wins.
	            2: Player 2 wins. */
	public int move(int row, int col, int player) {
	    int toAdd = player == 1 ? 1 : -1;
	    
	    rows[row] += toAdd;
	    cols[col] += toAdd;
	    
	    if (row == col)
	        diagonal += toAdd;
	    
	    if (col == (cols.length - row - 1))
	        antiDiagonal += toAdd;
	    
	    
	    int size = rows.length;
	    if (Math.abs(rows[row]) == size ||
	        Math.abs(cols[col]) == size ||
	        Math.abs(diagonal) == size  ||
	        Math.abs(antiDiagonal) == size)
	        	return player;
	    	    
	    return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe toe = new TicTacToe(3);

		System.out.println(toe.move(0, 0, 1));
		System.out.println(toe.move(0, 2, 2));
		System.out.println(toe.move(1, 1, 1));
		System.out.println(toe.move(2, 2, 2));
		System.out.println(toe.move(1, 2, 1)); 
		System.out.println(toe.move(1, 0, 2));
		System.out.println(toe.move(0, 1, 1));
		System.out.println(toe.move(2, 1, 2));
		System.out.println(toe.move(2, 0, 1));
	}

}

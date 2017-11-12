
public class Solution {
	public void makeMove(TicTacToeBoard b) {
		if (b.isFull())
			throw new IllegalArgumentException("The board is full!");
		for(int i = 0; i < 3; i++) 
			for(int j = 0; j < 3; j++)
				if(b.isEmpty(i, j)) {
					b.addToken(i, j, false);
					return;
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

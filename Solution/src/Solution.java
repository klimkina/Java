import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static class Board
	{
		public int[][] board;
		private int[] horizontals;
		private int[] verticals;
		private int[] diagonals;
		public Board(int size)
		{
			board = new int[size][size];
			horizontals = new int[size];
			verticals = new int[size];
			diagonals = new int[2];
		}
		public int play(int x, int y, boolean isFirst)
		{
			int val = isFirst ? 1 : -1;
			if(board[x][y] != 0)
				throw new IllegalArgumentException();
			board[x][y] = val;
			horizontals[x] += val;
			verticals[y] += val;
			if(x == y)
				diagonals[0] += val;
			if (x == board.length - y)
				diagonals[1] += val;
			if(Math.abs(horizontals[x]) == board.length || Math.abs(verticals[y]) == board.length ||
					Math.abs(diagonals[0]) == board.length || Math.abs(diagonals[1]) == board.length)
				return val;
			return 0;
		}
	}
	
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextInt();
            }
        }*/
    	Board game = new Board(3);
    	game.play(0, 0, true);
    	game.play(1, 0, false);
    	game.play(2, 1, true);
    	game.play(1, 2, false);
    	System.out.println(game.play(2, 2, true));
    	System.out.println(game.play(1, 1, false));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

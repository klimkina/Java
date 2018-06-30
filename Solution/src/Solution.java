import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static int countBattleships(char[][] board) {
		int res = 0;
		if(board.length != 0 && board[0].length != 0)
			for(int i = 0; i < board.length; i++)
				for(int j = 0; j < board[0].length; j++)
					if(board[i][j] == 'X')
					{
						res++;
						markShip(board, i, j);
					}
        return res;
    }
	
	private static void markShip(char[][] board, int i, int j)
	{
		if(board[i][j] != 'X')
			return;
		board[i][j] = 'V';
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for(int k = 0; k < 4; k++)
		{
			int newx = i + dx[k] + dy[k];
			int newy = j + dx[k] + dy[k];
			if(onBoard(board, newx, newy))
				markShip(board, newx, newy);
		}
	}
	
	private static boolean onBoard(char[][] board, int i, int j)
	{
		return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
	}
	
    public static void main(String[] args) {
    	char[][] field = {{'X', '.','.', 'X'},
    			{'.', '.','.', 'X'},
    			{'.', '.','.', 'X'}};
    	System.out.print(countBattleships(field));
    	
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

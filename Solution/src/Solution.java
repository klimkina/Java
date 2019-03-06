import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
	
	public static void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
            {
                int count = countNeib(board, i, j);
                if (board[i][j] > 0) {
                    if (count < 2)
                        board[i][j] = 4;
                    else if (count > 3)
                        board[i][j] = 4;
                } else if (count == 3)
                    board[i][j] = -1;
            }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 4)
                    board[i][j] = 0;
                else if (board[i][j] < 0)
                    board[i][j] = 1;
            }
    }
    
    private static int countNeib(int[][] board, int x, int y)
    {
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        int counter = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0 ; j < 3; j++)
                if (i != 1 || j != 1)
                {
                    int new_x = x + dx[i];
                    int new_y = y + dy[j];
                    if (inBounds(board, new_x, new_y) &&
                       board[new_x][new_y] > 0)
                        counter++;
                }
        return counter;
    }
    
    private static boolean inBounds(int[][] board, int x, int y)
    {
        return (x >=0 && x < board.length && y >= 0 && y < board[0].length);
    }
	
	public static void main(final String[] args) {
		int[][] board = {{0,1,0},
				  {0,0,1},
				  {1,1,1},
				  {0,0,0}};
		gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
}

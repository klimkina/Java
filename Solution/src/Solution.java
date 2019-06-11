import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


class Solution {
	public int[][] candyCrush(int[][] board) {
        while(crush(board))
            compress(board);
        return board;
    }
    private boolean crush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];
        boolean res = false;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                next[i][j] = board[i][j];
        for(int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            	if (board[i][j] != 0)
	            {
	                if (checkHor(board, i, j))
	                {
	                    res = true;
	                    next[i][j] = 0;
	                    int nx = j-1;
	                    while (nx >= 0)
	                        if (board[i][nx] == board[i][j])
	                            next[i][nx--] = 0;
	                        else
	                            break;
	                    nx = j+1;
	                    while (nx < board[0].length)
	                        if (board[i][nx] == board[i][j])
	                            next[i][nx++] = 0;
	                        else
	                            break;
	                }
	                if (checkVert(board, i, j))
	                {
	                    res = true;
	                    int nx = i-1;
	                    while (nx >= 0)
	                        if (board[nx][j] == board[i][j])
	                            next[nx--][j] = 0;
	                        else
	                            break;
	                    nx = i+1;
	                    while (nx < board.length)
	                        if (board[nx][j] == board[i][j])
	                            next[nx++][j] = 0;
	                        else
	                            break;
	                }
	            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = next[i][j];
        return res;
    }
    private boolean checkHor(int[][] board, int row, int col)
    {
        int count = 1;
        int next = col-1;
        while (next >= 0)
            if (board[row][next--] == board[row][col])
                count++;
            else
                break;
        next = col+1;
        while (next < board[0].length)
            if (board[row][next++] == board[row][col])
                count++;
            else
                break;
        return count >= 3;
    }
    private boolean checkVert(int[][] board, int row, int col)
    {
        int count = 1;
        int next = row-1;
        while (next >= 0)
            if (board[next--][col] == board[row][col])
                count++;
            else
                break;
        next = row+1;
        while (next < board.length)
            if (board[next++][col] == board[row][col])
                count++;
            else
                break;
        return count >= 3;
    }
    private void compress(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < n; i++)
        {
            int low = m-1;
            int curr = m-1;
            while(curr >= 0)
                if (board[curr][i] != 0)
                    board[low--][i] = board[curr--][i];
                else
                    curr--;
            while (low >= 0)
                board[low--][i] = 0;
        }
    }
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] board = {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
		obj.candyCrush(board);
	}
}

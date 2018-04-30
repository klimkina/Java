import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public int tickTackToe(int[][] game) {
		int zero = 0;
		int one = 0;
		//horizontal
		for (int i = 0; i < game.length; i++)
		{
			zero = 0; one = 0;
			for (int j = 0; j < game[0].length; j++)
			{
				if (game[i][j] == 0) zero++;
				else one++;
			}
			if (zero == 3) return 0;
			else if (one == 3) return 1;
		}
		//vertical
		for (int i = 0; i < game.length; i++)
		{
			zero = 0; one = 0;
			for (int j = 0; j < game[0].length; j++)
			{
				if (game[j][i] == 0) zero++;
				else one++;
			}
			if (zero == 3) return 0;
			else if (one == 3) return 1;
		}
		//diagonal
		zero = 0; one = 0;
		for(int i = 0; i < game.length; i++)
		{
			if (game[i][i] == 0) zero++;
			else one++;
		}
		if (zero == 3) return 0;
		else if (one == 3) return 1;
		//contrdiagonal
		zero = 0; one = 0;
		for(int i = 0; i < game.length; i++)
		{
			if (game[i][2-i] == 0) zero++;
			else one++;
		}
		if (zero == 3) return 0;
		else if (one == 3) return 1;
		return 2;
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
    	int[][] game = {{0,0,1},
    			{1,1,0},
    			{1,1,0}};
    	Solution obj =  new Solution();
    	System.out.println(obj.tickTackToe(game));
    }
}

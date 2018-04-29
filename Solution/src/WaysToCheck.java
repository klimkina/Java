import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WaysToCheck {
	private static int[] king_pos = new int[2];
	private static int[] my_king_pos = new int[2];
	private static int pawn_pos;
    static int waysToGiveACheck(char[][] board) {
        // Complete this function
    	int res = 0;
    	findPawn(board);
    	findKing(board);
    	if(promoteKnight(board))
    		res++;
    	if(promoteRook(board))
    		res +=2; //queen
    	if(promoteBishop(board))
    		res +=2; //queen
    	return res;
    }
    private static void findKing(char[][] board) {
    	boolean found = false;
    	for(int i = 0; i < 8; i++)
    		for(int j = 0; j < 8; j++)
    			if(board[i][j] == 'k') {
    				king_pos[0] = i;
    				king_pos[1] = j;
    				if(found)
    					break;
    				else
    					found = true;
     			} else if(board[i][j] == 'K') {
    				my_king_pos[0] = i;
    				my_king_pos[1] = j;
    				if(found)
    					break;
    				else
    					found = true;
     			}
    }
    private static boolean checkMyKing(char[][] board, int pos) {
    	boolean checked;
    	if(my_king_pos[0] == 1) { // check rook
    		for(int i = 0; i < 8; i++)
    			if(board[1][i] == 'r' || board[1][i] == 'q') {
    				if(pos > my_king_pos[1] && pos < i
    						|| pos < my_king_pos[1] && pos > i) {
    					checked = true;
    					for(int j = Math.min(my_king_pos[0], i); j < Math.max(my_king_pos[0], i); j++)
    						if(board[1][j] != '#')
    							checked = false;
    					if(checked)
    						return true;
    				}
    			}
    	} else {
    		if(pos > 0 && (board[0][pos-1] == 'b' || board[0][pos-1] == 'q' || board[0][pos-1] == 'K')) {    		
	    		for(int j = 1; j < 8 - pos; j++)
	    			if(board[j + 1][pos + j] != '#') {
	    				if(board[j + 1][pos + j] == 'b' || board[j + 1][pos + j] == 'q' && board[0][pos-1] == 'K')
	    					return true;
	    				else if(board[j + 1][pos + j] == 'K' && (board[0][pos-1] == 'b' || board[0][pos-1] == 'q'))
	    					return true;
	    				break;
	    			}
    		
    		} 
	    	if(pos < 8 && (board[0][pos+1] == 'b' || board[0][pos+1] == 'q' || board[0][pos+1] == 'K')) { // check bishop
	    		for(int j = 1; j < 8 - pos; j++)
	    			if(board[j + 1][pos - j] != '#') {
	    				if(board[j + 1][pos - j] == 'b' || board[j + 1][pos - j] == 'q' && board[0][pos-1] == 'K')
	    					return true;
	    				else if(board[j + 1][pos - j] == 'K' && (board[0][pos-1] == 'b' || board[0][pos-1] == 'q'))
	    					return true;
	    				break;
	    			}
	    	}
    	}
    	return false;
    }
    private static void findPawn(char[][] board) {
    	for(int i = 0; i < 8; i++)
    		if(board[1][i] == 'P' && board[0][i] == '#' && !checkMyKing(board, i)) {
    			pawn_pos = i;
				break;
 			}
    }
    private static boolean promoteKnight(char[][] board) {
    	if(king_pos[0] == 1) {
    		if(pawn_pos > 2 && pawn_pos - king_pos[1] == 2 
    				|| pawn_pos < 6 && king_pos[1] - pawn_pos == 2) 
    			return true;
    	} else if(king_pos[0] == 2){
    		if(pawn_pos > 1 && pawn_pos - king_pos[1] == 1
    				|| pawn_pos < 7 && king_pos[1] - pawn_pos == 1) 
    			return true;
    	}
    	return false;
    }
    private static boolean checkDiagonal(char[][] board) {
    	int inc = (king_pos[1] > pawn_pos ? 1 : -1);
    	for(int i = 1; i < king_pos[0]; i++)
    		for(int j = 1; j < Math.abs(pawn_pos - king_pos[1]); j++)
    			if(board[i][pawn_pos + inc * j] != '#')
    				return false;
    	return true;
    }
    private static boolean checkHorizontal(char[][] board) {
    	for(int i = Math.min(king_pos[1], pawn_pos); i < Math.max(king_pos[1], pawn_pos); i++)
    		if(board[0][i] != '#')
				return false;
    	return true;
    }
    private static boolean checkVertical(char[][] board) {
    	for(int i = 1; i < king_pos[0]; i++)
			if(board[i][pawn_pos] != '#')
				return false;
    	return true;
    }
    private static boolean promoteRook(char[][] board) {
    	if(king_pos[0] == Math.abs(pawn_pos - king_pos[1])
    			&& checkDiagonal(board))
    		return true;
    	return false;
    }
    private static boolean promoteBishop(char[][] board) {
    	if(king_pos[0] == 0 && checkHorizontal(board)
    			|| king_pos[1] == pawn_pos && checkVertical(board))
    		return true;
    	return false;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[8][8];
            for(int board_i = 0; board_i < 8; board_i++){
                for(int board_j = 0; board_j < 8; board_j++){
                    board[board_i][board_j] = in.next().charAt(0);
                }
            }*/
            char[][] board = {{'#','#','#','#','#','#','#','#'},
            		{'r','#','#','#','#','#','P','K'},
            		{'#','#','#','#','k','#','#','#'},
            		{'#','#','#','#','#','#','#','#'},
            		{'#','#','#','#','#','#','#','#'},
            		{'#','#','#','#','#','#','#','#'},
            		{'#','#','#','#','#','#','#','#'},
            		{'#','#','#','#','#','#','#','#'}};
            int result = waysToGiveACheck(board);
            System.out.println(result);
        /*}
        in.close();*/
    }
}


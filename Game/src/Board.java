import java.util.Scanner;

public class Board {
	char[][] board = new char[3][3];
	int size = 0;
	public Board()
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = '-';
	}
	public void placeToken(int i, int j, boolean isX)
	{
		if (!isEmpty(i, j))
			throw new IllegalArgumentException("Place already taken");
		if (isX)
			board[i][j] = 'X';
		else
			board[i][j] = 'O';
		size++;
	}
	public void print()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(board[i][j]);
				if ( j < 2)
					System.out.print("|");
			}
			System.out.println();
		}
	}
	public boolean isFull()
	{
		return size == 9;
	}
	public boolean isEmpty(int i, int j)
	{
		return board[i][j] == '-';
	}
	public boolean readInput(String s, int[] move)
	{
		String[] inp = s.split(" ");
		if (inp.length != 2)
			return false;
		try
		{
			move[0] = Integer.valueOf(inp[0]);
			move[1] = Integer.valueOf(inp[1]);
			if (!(move[0]>= 0 && move[0] < 3) ||
					!(move[1]>= 0 && move[1] < 3))
				return false;
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	public static void main(String[] args) {   	
		Scanner in = new Scanner(System.in);
		Board obj = new Board();
		//obj.placeToken(1, 1, true);
		Solver solv = new Solver();
		int[] move = new int[2];
		boolean user_inp = false;
		for (int i = 0; i < 10; i++)
		{
			
			user_inp = false;
			//obj.placeToken(0, 1, false);
			while(!user_inp)
			{
				System.out.print("Enter a number: ");
				//String inp = in.next();				
				String s = in.nextLine();
				user_inp = obj.readInput(s, move);
				if (!user_inp)
					System.out.println("Please enter two numbers separated by space");
				else if (!obj.isEmpty(move[0], move[1]))
				{
					user_inp = false;
					System.out.println("This cell is alredy taken");
				}
				else 
					obj.placeToken(move[0], move[1], true);
			}
			if (obj.isFull())
			{
				System.out.println("Game Over!");
				return;
			}
			solv.makeMove(obj);
			obj.print();
		}
	}
}

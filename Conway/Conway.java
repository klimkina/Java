import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Conway {
	public static class Coordinate
	{
		public int x;
		public int y;
		public Coordinate(int x, int y)
		{
			this.x = x; this.y = y;
		}
	}
	public void createBoard(int[][] alive)
	{
		//stil don't understand this one. lol noooope
	}
	
	public boolean isAlive(int x, int y)
	{
		if( x== 0 && y == 1)
			return false;
		return true;
	}
	public List<Coordinate> getNeighbors(int x, int y)
	{
		List<Coordinate> res = new ArrayList<>();
		res.add(new Coordinate(0,0));
		res.add(new Coordinate(1,0));
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

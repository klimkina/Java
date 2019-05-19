
public class Solver {
	public void makeMove(Board b)
	{
		if (b.isFull())
			throw new IllegalArgumentException("Can't move");
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (b.isEmpty(i,  j))
				{
					b.placeToken(i, j, false);
					return;
				}
	}
}

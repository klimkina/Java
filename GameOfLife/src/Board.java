import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Board {
	HashSet<Cell> grid;
	boolean isLive;
	public Board() {
		grid = new HashSet<>();
		isLive = false;
	}
	public boolean isAlive(int x, int y) {
		return isLive;
	}
	public void addCell(Cell cell) {
		grid.add(cell);
		isLive = true;
	}
	public List<Cell> getNeighbors(Cell cell) {
		return null;
	}
}


import java.util.LinkedList;
import java.util.Queue;

class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    class Position
    {
        int x;
        int y;
        public Position(int x, int y)
        {
            this.x = x; this.y = y;
        }
        public Position(Position other)
        {
            this.x = other.x; this.y = other.y;
        }
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position pos2 = (Position) o;

        if (pos2.x != this.x) return false;
        if (pos2.y != this.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return x*width + y;
    }

    }
    int width, height;
    int[][] food;
    LinkedList<Position> snake = new LinkedList<>();
    int idx = 0;
    Set<Position> set = new HashSet<>();
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake.offer(new Position(0, 0));
        set.add(new Position(0, 0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Position pos = new Position(snake.peekFirst());
        switch (direction)
        {
            case "U": pos.x--;break;
            case "D": pos.x++;break;
            case "L": pos.y--;break;
            case "R": pos.y++;break;
        }
        if (!checkBounds(pos) )
            return -1;
        snake.offerFirst(pos);
        if (idx < food.length && pos.x == food[idx][0] && pos.y == food[idx][1])
        {
            
            idx++;
        }
        else
        {
            Position pos2 = snake.pollLast();
            set.remove(pos2);            
        }
        if (set.contains(pos))
            return -1;
        set.add(pos);
        return idx;
    }
    private boolean checkBounds(Position pos)
    {
        return pos.x >= 0 && pos.y >= 0 && pos.x < height && pos.y < width;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] food = {{1,2}, {0,1}};
		SnakeGame snake = new SnakeGame(2,3, food);
		snake.move("R");
		snake.move("D");
		snake.move("R");
		snake.move("U");
		snake.move("L");
		snake.move("U");
	}

}

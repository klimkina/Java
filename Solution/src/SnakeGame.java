import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Deque;

class SnakeGame {
	
	private int curr_col = 0;
	private int[][] food;
	private int width;
	private int height;
	private Deque<Integer> snake;
	Set<Integer> set; // for fast search
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = new int[food.length][food[0].length];
        for(int i = 0; i < food.length; i++)
        	this.food[i] = food[i].clone();
        snake = new LinkedList<>();
        snake.add(0);
        set = new HashSet<>();
        set.add(0);
    }
    private boolean outOfBounds(Integer pos) {
    	int x = pos / width;
    	int y = pos % width;
    	return (x < 0 || x >= width || y < 0 || y >= height);
    }
    private boolean crossedBody(Integer pos) {
    	if(set.contains(pos))
			return true;
    	return false;
    }
    private boolean isFood(Integer pos) {
    	if(curr_col < food.length)
			return(pos == food[curr_col][0]* width + food[curr_col][1]);
    	return false;
    }
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        char[] charr = direction.toCharArray();
        Integer curr_pos = snake.getLast();
        Integer new_pos = 0;
        for(int i = 0; i < charr.length; i++) {
        	switch(charr[i]) {
	        	case 'U' : new_pos = curr_pos-width;
	        				break;
	        	case 'L' : new_pos = curr_pos-1;
							break;
	        	case 'R' : new_pos = curr_pos+1;
							break;
	        	case 'D' : new_pos = curr_pos+width;
							break;
        	}
        	if(outOfBounds(new_pos) || crossedBody(new_pos))
        		return -1;
        	snake.offerFirst(new_pos);
        	set.add(new_pos);
        	if(isFood(new_pos)) {
        		curr_col++;
        	}
        	else {
        		set.remove(snake.peekLast());
        		snake.removeLast();
        		
        	}
        	curr_pos = new_pos;
        }
        return snake.size()-1;
    }
    public static void main(String[] args) {   	
    	int[][] food = {{1,2},{0,1}};
    	SnakeGame obj = new SnakeGame(3, 3, food);
    	System.out.println(obj.move("R"));
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
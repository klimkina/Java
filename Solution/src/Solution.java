import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) return;
	    Queue<int[]> queue = new LinkedList<>();
	    for (int i = 0; i < rooms.length; i++) {
	        for (int j = 0; j < rooms[0].length; j++) {
	            if (rooms[i][j] == 0) queue.add(new int[]{i, j});
	        }
	    }
	    while (!queue.isEmpty()) {
	        int[] top = queue.remove();
	        int row = top[0], col = top[1];
	        int[] dx = {1, -1, 0, 0};
	        int[] dy = {0, 0, 1, -1};
	        
	        for(int i = 0; i < 4; i++) {
	        	int new_row = row + dy[i];
	        	int new_col = col + dx[i];
	        	if(new_row >= 0 && new_row < rooms.length &&
	        			new_col >= 0 && new_col < rooms[0].length &&
	        			rooms[new_row][new_col] == Integer.MAX_VALUE) {
	        		
	        		rooms[new_row][new_col] = rooms[row][col] + 1;
	        		queue.add(new int[]{new_row, new_col});
	        	}
	        
	        }
	    }
	}
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[][] house = {{2147483647,  -1,  0,  2147483647},
    			{2147483647, 2147483647, 2147483647,  -1},
    			{2147483647,  -1, 2147483647,  -1},
    			  {0,  -1,2147483647, 2147483647}};
    	obj.wallsAndGates(house);
    	for(int row = 0; row < house.length; row++) {
    		for(int col = 0; col < house[0].length; col++)
    			System.out.print(house[row][col] + " ");
    		System.out.println();
    	}
        
    }
}
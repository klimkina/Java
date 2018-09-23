import java.util.PriorityQueue;

public class SnakesAndLadders {
	public int snakesAndLadders(int[][] board) {
		int[] path = new int[board.length * board[0].length];
        int idx = 0;
        for (int i = board.length-1; i >= 0; i--)
        {
            for (int j = 0; j < board[0].length; j++)
                path[idx++] = board[i][j]-1;
            i--;
            if (i==-1)
                break;
            for (int j = board[0].length-1; j >= 0; j--) {
                path[idx++] = board[i][j]-1;
            }
        }
        int[] dist = new int[idx];
        for (int i = 0; i < idx; i++)
        	dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(0);
        dist[0] = 0;
        while (!q.isEmpty())
        {
        	int u = q.poll();
            int d = dist[u];
            for (int v = u+1; v < idx && v-u <= 6; v++) {
                int v2 = v;
                if (path[v] >= 0)
                    v2 = path[v];
                if (d+1 < dist[v2]) {
                    q.add(v2);
                    dist[v2] = d+1;
                }
            }
        }
        return dist[idx-1] == Integer.MAX_VALUE ? -1 : dist[idx-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}
		};
		SnakesAndLadders obj = new SnakesAndLadders();
		System.out.println(obj.snakesAndLadders(board));
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/*
On an infinite number line, the position of the i-th stone is given by stones[i].  Call a stone an endpoint stone if it has the smallest or largest position.

Each turn, you pick up an endpoint stone and move it to an unoccupied position so that it is no longer an endpoint stone.

In particular, if the stones are at say, stones = [1,2,5], you cannot move the endpoint stone at position 5, since moving it to any position (such as 0, or 3) will still keep that stone as an endpoint stone.

The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.

When the game ends, what is the minimum and maximum number of moves that you could have made?  Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]
 */

class Solution {
	public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int[] res = new int[2];
        res[1] = Math.max(stones[n-1] - stones[1] - n + 2, stones[n-2] - stones[0] - n + 2);
        res[0] = res[1];
        int start = 0;
        for (int i = 0; i < n; i++)
        {
            while (stones[i] >= stones[start] + n)
                start++;
            if (i - start == n - 2 && stones[i] - stones[start] == n - 2)
                res[0] = Math.min(res[0], 2);
            else
                res[0] = Math.min(res[0], n - (i - start + 1));    
        }
        return res;
    }
    
	public static void main(final String[] args) {
		Solution obj = new Solution();
		int[][] points = {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
		int[][] closest = obj.kClosest(points,  5);
		obj.print(closest, 5);
	}
}

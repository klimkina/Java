/*In ordinary chess, the pieces are only of two colors, black and white. In our version of chess, we are including new pieces with unique movements. One of the most powerful pieces in this version is the red knight.

The red knight can move to six different positions based on its current position (UpperLeft, UpperRight, Right, LowerRight, LowerLeft, Left) as shown in the figure below.

image

The board is a grid of size . Each cell is identified with a pair of coordinates , where  is the row number and  is the column number, both zero-indexed. Thus,  is the upper-left corner and  is the bottom-right corner.

Complete the function printShortestPath, which takes as input the grid size , and the coordinates of the starting and ending position  and  respectively, as input. The function does not return anything.

Given the coordinates of the starting position of the red knight and the coordinates of the destination, print the minimum number of moves that the red knight has to make in order to reach the destination and after that, print the order of the moves that must be followed to reach the destination in the shortest way. If the destination cannot be reached, print only the word "Impossible".

Note: There may be multiple shortest paths leading to the destination. Hence, assume that the red knight considers its possible neighbor locations in the following order of priority: UL, UR, R, LR, LL, L. In other words, if there are multiple possible options, the red knight prioritizes the first move in this list, as long as the shortest path is still achievable. Check sample input  for an illustration.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RedKnight {
	private static class Point implements Comparable<Point> {
		int i;
		int j;
		int move;
		int dist;
		Point(int i, int j, int m, int dist) {
			this.i = i;
			this.j = j;
			move = m;
			this.dist = dist;
		}
		public int compareTo(Point p) {
			if(this.dist != p.dist)
				return this.dist - p.dist;
			return this.move - p.move;
		}
	}
	private static String[] moveCodes = {"UL", "UR", "R", "LR", "LL", "L"};
	private static int[][] distTo;
	private static Point[][] pointFrom;
	private static Queue<Point> pathPriorityQueue;
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.
    	distTo = new int[n][n];
    	for(int i = 0; i < n; i++)
    		Arrays.fill(distTo[i], Integer.MAX_VALUE);
    	distTo[i_start][j_start] = 0;
    	pathPriorityQueue = new PriorityQueue<>();
    	pointFrom = new Point[n][n];
    	pathPriorityQueue.add(new Point(i_start, j_start, -1, 0));
        while (!pathPriorityQueue.isEmpty() && !(distTo[i_end][j_end] < Integer.MAX_VALUE)) {
        	Point p = pathPriorityQueue.remove();
            relax(p, n);
        }
        if((distTo[i_end][j_end] < Integer.MAX_VALUE)) {
        	Deque<String> path = new ArrayDeque<>();
        	Point p = pointFrom[i_end][j_end];
        	while(p.i != i_start || p.j != j_start) {
        		path.push(moveCodes[p.move]);
        		p = pointFrom[p.i][p.j];
        	}
        	path.push(moveCodes[p.move]);
        	System.out.println(path.size());
        	while(!path.isEmpty()) {
        		System.out.print(path.pop());
        		if(!path.isEmpty())
					System.out.print(" ");
        	}
        }
        else
        	System.out.println("Impossible");
    }
    
    private static void relax(Point p, int n) {
        int[] dy = {-1, 1, 2, 1, -1, -2};
        int[] dx = {-2, -2, 0, 2, 2, 0};
        for(int k = 0; k < 6; k++) {
        	int new_i = p.i + dx[k];
        	int new_j = p.j + dy[k];
        	if(new_i >= 0 && new_j >= 0 &&
        		new_i < n && new_j < n)
        
	        if (distTo[new_i][new_j] > distTo[p.i][p.j] + 1) {
	            distTo[new_i][new_j] = distTo[p.i][p.j] + 1;
	            pointFrom[new_i][new_j] = new Point(p.i, p.j, k, distTo[new_i][new_j]);
	            pathPriorityQueue.add(new Point(new_i, new_j, k, distTo[new_i][new_j]));
	        }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}

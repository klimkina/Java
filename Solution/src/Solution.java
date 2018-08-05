import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = matrix[0].length;
        int m = matrix.length;
        int layer = 0;
        List<Integer> res = new ArrayList<>();
        int xpos = 0;
        int ypos = 0;
        res.add(matrix[0][0]);
        while (layer < (Math.min(m,n)+1)/2)
        {
            for (int i = 0; i < 4; i++)
            {
                int newx = xpos + dx[i];
                int newy = ypos + dy[i];
                if (!inside(newx,newy,m,n,layer, dy[i]))
                	break;
                while(inside(newx,newy,m,n,layer, dy[i]))
                {
                    res.add(matrix[newy][newx]);
                    newx = newx + dx[i];
                    newy = newy + dy[i];
                }
                xpos = newx - dx[i];
                ypos = newy - dy[i];
            }
            layer++;
        }
        return res;
    }
    
    private static boolean inside(int xpos, int ypos, int m, int n, int layer, int dy)
    {
        return (xpos >= layer && xpos < n - layer) && (ypos >= layer && ypos < m - layer) 
        		&& (dy == 0 || xpos != layer || ypos != layer);
    }
	
    public static void main(String[] args) {
    	int[][] matrix = {
    	                  {1, 2, 3, 4},
    	                  {5, 6, 7, 8},
    	                  {9,10,11,12}
    					};
    	List<Integer> res = spiralOrder(matrix);
    	for (int i : res)
    	{
            System.out.print(i + " ");
    	}
    	
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	public static class Baloon implements Comparable<Baloon>
	{
		int left;
		int right;
		public Baloon(int l, int r)
		{
			left = l; right = r;
		}
		public int compareTo(Baloon that)
		{
			if (this.left != that.left)
				return this.left - that.left;
			return this.right - that.right;
		}
	}
	public static int findMinArrowShots(int[][] points) {
		if(points.length == 0)
			return 0;
        Baloon[] baloons = new Baloon[points.length];
        for (int i = 0; i < baloons.length; i++)
        	baloons[i] = new Baloon(points[i][0], points[i][1]);
        Arrays.sort(baloons);
        int res = 0;
        int last_arrow = baloons[0].left-1;
        Queue<Integer> right_ends = new PriorityQueue<>();
        for (int i = 0; i < baloons.length; i++)
        {        	
        	if(!right_ends.isEmpty() && baloons[i].left > right_ends.peek()) //add new arrow to prev baloons
        	{
        		res++;
        		last_arrow = right_ends.poll();
        		right_ends.clear();
        	}   
            right_ends.offer(baloons[i].right);
        }
        return res+1;
    }
		
    public static void main(String[] args) {
    	int[][] baloons = {{10,16}, {2,8}, {1,6}, {7,12}};
    	System.out.println(findMinArrowShots(baloons));
    	//System.out.println(calculate("1 + 1"));
    	//System.out.println(calculate("2*(5+5*2)/3+(6/2+8)")); //21
    	//System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // -12
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}

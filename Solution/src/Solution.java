import java.util.Arrays;
import java.util.HashSet;

class Solution {
	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object that) 
		{
			if (this == that) return true;
		    if (that == null || getClass() != that.getClass()) return false;
			return (this.x == ((Point)that).x && this.y == ((Point)that).y);
		}
		public int hashCode() {
	        return x*10000009 + y;
	    }
	}
	public boolean isReflected(int[][] points) {
		if(points.length < 2)
			return true;
        Arrays.sort(points, (a,b)->(a[0] - b[0]));
        HashSet<Point> set = new HashSet<>();
        for(int i = 0; i < points.length; i++)
        	set.add(new Point(points[i][0], points[i][1]));
        int y2 = 2*points[0][0] + (points[points.length-1][0] - points[0][0]);
        for(int i = 0; i < (points.length-1) / 2 + 1; i++)
        	if(!set.contains(new Point(y2 - points[i][0], points[i][1])))
        		return false;
        return true;
    }
	    
    public static void main(String[] args) {   	
    	int[][] points = {{-16,1},{16,1},{16,1}};
    	Solution obj = new Solution();
    	System.out.println(obj.isReflected(points));
    }
}
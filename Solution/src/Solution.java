import java.util.Arrays;
import java.util.HashSet;

class Solution {
	
	public boolean isReflected(int[][] points) {
		if(points.length < 2)
			return true;
        Arrays.sort(points, (a,b)->(a[0] - b[0]));
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < points.length; i++)
        	set.add(points[i][0] + "#" + points[i][1]);
        int y = points[0][0] + points[points.length-1][0];
        for(int i = 0; i < points.length / 2; i++)
        	if(!set.contains(y - points[i][0] + "#" + points[i][1]))
        		return false;
        return true;
    }
	    
    public static void main(String[] args) {   	
    	int[][] points = {{-16,1},{16,1},{16,1}};
    	Solution obj = new Solution();
    	System.out.println(obj.isReflected(points));
    }
}
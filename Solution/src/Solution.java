import java.util.ArrayList;

class Solution {
	public int maxArea(int[] height) {
		if ( (height == null) || (height.length <= 1) )
			return 0;
		int res = 0;
		int low = 0, high = height.length - 1;
		while(low < high) {
			int area = (high - low) * Math.min(height[low], height[high]);
			if(area > res)
				res = area;
			if(height[low] < height[high])
				low++;
			else
				high--;
		}
        return res;
    }
    public static void main(String[] args) {
    	int[] height = {1,2,3,5,2};
    	Solution obj = new Solution();
    	System.out.println(obj.maxArea(height));
    }
}
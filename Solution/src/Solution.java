import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution {
	public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points, (a,b)-> a[0] == b[0] ? a[1]-b[1] :a[0]-b[0]);
        HashMap<Integer, Set<Integer>> mapY = new HashMap<>();
        for (int i = 0; i < points.length; i++)
        {
            if (!mapY.containsKey(points[i][1]))
                mapY.put(points[i][1], new HashSet<>());
            mapY.get(points[i][1]).add(points[i][0]);
        }
        int max = Integer.MAX_VALUE;
        int lo = 0;
        int hi = points.length-1;
        while(lo < hi)
        {
            int llX = points[lo][0];
            int llY = points[lo][1];
            if (mapY.get(llY).size() > 1)            
            {
                int i = lo+1;
                while(i < points.length)
                    if (points[i][0] == llX)
                        i++;
                    else
                        break;
                i--;
                if (i > lo)
                {
                    for (int k = i; k > lo; k--)
                    {
                        Set<Integer> upset = mapY.get(points[k][1]);
                        Set<Integer> loset = mapY.get(llY);
                        loset.retainAll(upset);
                        for (int l : loset)
                    		if (l > llX && points[k][1] > llY)
                    		    max = Math.min(max, (l-llX)*(points[k][1] - llY));
                    }
                }                
            }
            lo++;
        }
        return max == Integer.MAX_VALUE ? 0 : max;
	}
    
	public static void main(String[] args) {   	
		Solution obj = new Solution();
		int[][] nums1 = {{1,2},{3,2},{1,3},{3,3},{3,0},{1,4},{4,2},{4,0}};
		System.out.println(obj.minAreaRect(nums1));
	}
}

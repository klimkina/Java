import java.util.Arrays;

public class PourWater {
	public int[] pourWater(int[] heights, int V, int K) {
        int[] res = Arrays.copyOf(heights, heights.length);
        for(int i = 0; i < V; i++) {
        	res[findNext(res, K)]++;
        }
        return res;
    }
	private int findNext(int[] curr_heights, int k) {
		int pos = k;
		for(int i = k-1; i >= 0; i--) {
			if(curr_heights[i] < curr_heights[pos])
				pos = i;
			else if (curr_heights[i] > curr_heights[pos])
				break;
		}
		if(pos == k)
			for(int i = k+1; i < curr_heights.length; i++) {
				if(curr_heights[i] < curr_heights[pos])
					pos = i;
				else if (curr_heights[i] > curr_heights[pos])
					break;
			}
		return pos;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1,2,3,4,3,2,1,2,3,4,3,2,1};
		int v = 2, k = 5;
		PourWater obj = new PourWater();
		int[] arr = obj.pourWater(heights, v, k);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]);
	}

}

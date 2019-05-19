import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 */
class Solution {
	public int lastStoneWeightII(int[] stones) {
        return last(stones, stones.length);
    }
    private int last(int[] arr, int last)
    {
        if (last == 0)
            return 0;
        if (last == 1)
            return arr[0];
        if (last == 2)
            return Math.abs(arr[0] - arr[1]);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < last-1; i++)
        {
            //print(arr, last);
            int t = arr[i];
            if (arr[i] == arr[last-1])
            {
                arr[i] = arr[last-2];
                res = Math.min(res, last(arr, last-2));
            }
            else
            {
                arr[i] = Math.abs(arr[i] - arr[last-1]);
                res = Math.min(res, last(arr, last-1));
            }
            arr[i] = t;
            if (res < 2)
                return res;
        }
        return res;
    }    

	public static void main(String[] args) {   	
    	
	}
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
	public static int smallestRangeII(int[] A, int K) {
		if (A == null || A.length < 2)
            return 0;
        Arrays.sort(A);
        int n = A.length;
        int res = A[n-1] - A[0];
        int min = A[0];
        int max = A[n-1];
        for (int i = 0; i < n-1; i++)
        {
            if (A[i] + 2*K > max)
                max = A[i] + 2*K;
            min = Math.min(A[i+1],A[0] + 2*K);
            if (max - min < res)
                res = max-min;
                
        }
        return res;
    }
	
    public static void main(String[] args) 
    {
    	int[]  A = { 8038,9111,5458,8483,5052,9161,8368,2094,8366,9164,53,7222,9284,5059,4375,2667,2243,5329,3111,5678,5958,815,6841,1377,2752,8569,1483,9191,4675,6230,1169,9833,5366,502,1591,5113,2706,8515,3710,7272,1596,5114,3620,2911,8378,8012,4586,9610,8361,1646,2025,1323,5176,1832,7321,1900,1926,5518,8801,679,3368,2086,7486,575,9221,2993,421,1202,1845,9767,4533,1505,820,967,2811,5603,574,6920,5493,9490,9303,4648,281,2947,4117,2848,7395,930,1023,1439,8045,5161,2315,5705,7596,5854,1835,6591,2553,8628};
    	System.out.println(smallestRangeII(A, 4643));
    }
}

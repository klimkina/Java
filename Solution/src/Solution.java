import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public int numFriendRequests(int[] ages) {
		Arrays.sort(ages);
		int less = 0;
		int count = 0;
		int num = 0;
		TreeMap<Integer, Integer> hashmap = new TreeMap<>();
		for(int i = 0; i < ages.length; i++)
		{
			double dfloor = ((double)ages[i])/2 + 7;
			int floor = (int)Math.floor(dfloor);
			if(!hashmap.isEmpty() && hashmap.floorEntry(floor) != null)
				less = hashmap.floorEntry(floor).getValue() + 1;
			else
				less = 0;
			num += count - less;
			int k = 1;
			dfloor = ((double)ages[i])/2 + 7;
			if(dfloor < ages[i])
				while( i+k < ages.length && ages[i+k] == ages[i])
				{
					num++; k++;
				}
			count++;
			hashmap.put(ages[i], i);
		}
		
        return num;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int q = in.nextInt();
        int[][] queries = new int[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextInt();
            }
        }*/
    	int[] arr1 = {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
    	int[] arr2 = {16,17,18};
    	int[] arr3 = {20,30,100,110,120};
    	Solution obj =  new Solution();
    	System.out.println(obj.numFriendRequests(arr1));
    	System.out.println(obj.numFriendRequests(arr2));
    	System.out.println(obj.numFriendRequests(arr3));
        //in.close();
    }
}

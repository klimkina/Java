import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public char max(String str) {
		if (str.isEmpty())
			throw new IllegalArgumentException("No characters in string");
		char[] charr = str.toCharArray();
		char max_char = charr[0];
		int max_val = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < charr.length; i++)
		{
			int curr = map.getOrDefault(charr[i], 0);
			curr++;
			if (curr > max_val)
			{
				max_val = curr;
				max_char = charr[i];
			}
			map.put(charr[i], curr);
		}
		return max_char;
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
    	String str = "aaabbrrrrrr";
    	Solution obj =  new Solution();
    	System.out.println(obj.max(str));
    }
}

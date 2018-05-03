import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	public String longestsub(String s) {
		char[] charr = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;
		int maxpos = 0;
		int currlen = 0;
		for(int i = 0; i < charr.length; i++)
		{
			Integer prev = map.get(charr[i]);
			if (prev == null || prev < i - currlen)
				currlen++;
			else
				currlen = 1;
			if(currlen > max)
			{
				max = currlen;
				maxpos = i - max + 1;
			}
			map.put(charr[i], i);
		}
		return s.substring(maxpos, maxpos+max);
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
    	String s = "abcabcvbb";
    	Solution obj = new Solution();
    	System.out.println(obj.longestsub(s));
    }
}

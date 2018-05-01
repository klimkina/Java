import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	public String reverseWords(String str) {
		char[] charr = str.toCharArray();
		int prev = -1;
		for(int i = 0; i < charr.length; i++)
		{
			if(charr[i] == ' ')
			{
				reverse(charr, prev, i);
				prev = i;
			}
		}
		reverse(charr, prev, charr.length);
		reverse(charr, -1, charr.length);
		return String.valueOf(charr);
    }
	
	private void reverse (char[] charr, int start, int end)
	{
		char temp;
		for(int i = 1; i <= (end-start)/2; i++)
		{
			temp = charr[start+i];
			charr[start+i] = charr[end-i];
			charr[end-i] = temp;
		}
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
    	String s= "Quick brown fox jumped over a red box";
    	Solution obj =  new Solution();
    	System.out.println(obj.reverseWords(s));;
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	static String compress(String str)
    {
		if(str == null || str.length() < 2)
			return str;
        StringBuilder sb = new StringBuilder();
        char[] charr = str.toCharArray();
        char prev = charr[0];
        int count = 1;
        for(int i = 1; i <= charr.length; i++)
        {
        	if(i < charr.length && charr[i] == prev)
        		count++;
        	else
        	{
        		helper(sb, prev, count);
        		count = 1;
        		if(i < charr.length)
        			prev = charr[i];
        	}
        }
        helper(sb, prev, count);
        return sb.toString();
    }
	private static void helper(StringBuilder sb, char ch, int count)
	{
		if(count > 1)
			sb.append(count);
		sb.append(ch);
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
    	String s = "aabbbcabcc";
    	System.out.println(compress(s));
    }
}

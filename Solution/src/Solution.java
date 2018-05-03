import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	public static class Buffer
	{
		private int currpos = 0;
		private int size = 4;
		private char[] charr;
		public Buffer(char[] arr)
		{
			String s = String.valueOf(arr);
			s = s.replaceAll("\n", "\r\n");
			charr = s.toCharArray();
		}
		public char[] read()
		{
			if(currpos >= charr.length)
				return null;
			int newpos = Math.min(currpos + size, charr.length);
			char[] res = Arrays.copyOfRange(charr, currpos, newpos);
			currpos = newpos;
			return res;
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
    	String s = "abcabcvbb\nadsafdsdfs\r\ntsdsfsd";
    	Buffer obj = new Buffer(s.toCharArray());
    	char[] buff = obj.read();
    	while (buff != null)
    	{
    		System.out.println(buff);
    		buff = obj.read();
    	}
    }
}

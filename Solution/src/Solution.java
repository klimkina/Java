import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	
	public static class SmallChunks
	{
		private char[] charr;
		int curr = 0;
		boolean isNLeft = false;
		public SmallChunks(char[] charr)
		{
			this.charr = Arrays.copyOf(charr, charr.length);
		}
		public char[] GetChunk(int size)
		{
			char[] res = new char[size];
			if(size < 1)
				return res;
			int start = 0;
			if (isNLeft)
				res[start++] = '\n';
			
			for(int i = start; i < size; i++)
			{
				if (curr >= charr.length)
					return res;
				if(charr[curr] == '\n')
				{
					curr++;
					res[i] = '\r';
					if(i < size - 1)
						res[++i] = '\n';
					else
						isNLeft = true;
				}
				else
					res[i] = charr[curr++];
			}
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
    	char[] charr = {'a', 'b', 'v', '\n', 'a', 'b', 'c', 'f', '\n', 'a', 'b', '\n'};
    	SmallChunks chuncks = new SmallChunks(charr);
    	System.out.println(String.valueOf(chuncks.GetChunk(3)));
    	System.out.println(String.valueOf(chuncks.GetChunk(3)));
    	System.out.println(String.valueOf(chuncks.GetChunk(3)));
    	System.out.println(String.valueOf(chuncks.GetChunk(3)));
    	System.out.println(String.valueOf(chuncks.GetChunk(3)));
    	//String res = Arrays.stream(findPair(input, n)).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(", "));
    	//System.out.println(res);
    	
    }
}
